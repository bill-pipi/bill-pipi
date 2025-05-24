import csv
from langchain.memory import ConversationBufferMemory
from langchain.chains import LLMChain
from langchain_openai import ChatOpenAI
from langchain.prompts import (
    ChatPromptTemplate,
    MessagesPlaceholder,
    SystemMessagePromptTemplate,
    HumanMessagePromptTemplate,
)
import os



prompt_file = open("prompt.txt", mode = 'r')
question_file = open("question.txt", mode = 'r')

index = int(input())
output_length = 20



class Person:

    def __init__(self, line_entry):
        self.fn = line_entry[0]
        self.ln = line_entry[1]
        self.cat = line_entry[2]
        self.org = line_entry[3]
        self.ttl = line_entry[4]
        self.year = line_entry[5]
        self.email = line_entry[6]
        self.phone = line_entry[7]
        self.adrs = line_entry[8]


    
    def info(self):
        info =  (
            " Community Sponsor First Name: " + self.fn
            + "\n Community Sponsor Last Name: " + self.ln 
            + "\n Field/Specialization Category: " + self.cat 
            + "\n Organization Name: " + self.org 
            + "\n Community Sponsor Title: " + self.ttl 
            + "\n Last year Comunity Sponsor Participated: " + self.year 
            + "\n Community Sponsor Email: " + self.email 
            + "\n Community Sponsor Phone Address: " + self.phone
            + "\n Community Sponsor Organization Address: " + self.adrs
        )
        return info





def define_model():
    # LLM

    llm = ChatOpenAI(
        model_name="gpt-3.5-turbo",
        openai_api_key=os.environ.get('OPENAI_API_KEY'),
    )

    # Prompt
    prompt = ChatPromptTemplate(
        messages=[
            SystemMessagePromptTemplate.from_template(
                prompt_file.read()
            ),
            MessagesPlaceholder(variable_name="chat_history"),
            HumanMessagePromptTemplate.from_template("{question}"),
        ]
    )

    memory = ConversationBufferMemory(memory_key="chat_history", return_messages=True)
    conversation = LLMChain(llm=llm, prompt=prompt, verbose=False, memory=memory)
    return conversation



def output_letter(conversation, person):
    # Get OpenAI Response
    response = conversation(
        {
            "question": question_file.read() + person.info()
        })
    return response['text']


  
def __main__():

    if __name__ == "__main__":

        conv = define_model()
        database = []

        with open('database.csv', mode = 'r') as input_file:
            csvFile = csv.reader(input_file)

            for lines in csvFile:
            
                lines.pop(0)
                database.append(Person(lines))

        output_file = open("output_" + str(index) + ".txt", 'w+')
        for person in [database[i] for i in range((index - 1) * output_length, index * output_length-1)]:

            letter = (output_letter(conv, person) + (5 * "\n") )
            output_file.write(letter)





__main__()