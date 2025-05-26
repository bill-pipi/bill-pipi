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
import itertools



class let_gen:


    #Initialize letter_generator with settings file
    def __init__(self, settings):
        self.settings = settings


    #Create inner class Person with attributes from database
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


        #Debug function to return info 
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
                + "\n Community Sponsor Organization Address: " + self.adrs + (3*"\n")
            )
            return info


    def define_model(self, prompt):
        # LLM

        llm = ChatOpenAI(
            model_name="gpt-3.5-turbo",
            openai_api_key=os.environ.get('OPENAI_API_KEY'),
        )

        # Prompt
        prompt = ChatPromptTemplate(
            messages=[
                SystemMessagePromptTemplate.from_template(
                    prompt.read()
                ),
                MessagesPlaceholder(variable_name="chat_history"),
                HumanMessagePromptTemplate.from_template("{question}"),
            ]
        )

        memory = ConversationBufferMemory(memory_key="chat_history", return_messages=True)
        conversation = LLMChain(llm=llm, prompt=prompt, verbose=False, memory=memory)
        return conversation



    def output_letter(self, conversation, person, question_file):
        # Get OpenAI Response
        response = conversation(
            {
                "question": question_file.read() + person.info()
            })
        return response['text']





    #Main method
    def run(self):
        
        #Find directory path
        path = os.path.dirname(__file__) + "/"
        #Find max output size and block index
        index, max_size = int(self.settings[0]), int(self.settings[1])
        #Download files
        database_file = open(path + self.settings[2][:-1])
        prompt_file = open(path + self.settings[3][:-1])
        question_file = open(path + self.settings[4][:-1])

        #Init conversation   
        conv = self.define_model(
            prompt = prompt_file
        )
        #Create database of persons
        database = []
        csvFile = csv.reader(database_file)
        #Iterate through database csv


        
        start, end = (index - 1) * max_size, index * max_size

        for lines in itertools.islice(csvFile, (index - 1) * max_size, index * max_size - 1):
                
                lines.pop(0)
                #Add person
                database.append(self.Person(line_entry = lines))

        #Open output_file 
        output_file = open(path + "/output/" + "output_" + str(index) + ".txt", 'w+') 
        #Iterate through each person   
        for person in database:
            #Generate letter
            letter = (
                self.output_letter(conv, person, 
                    question_file = question_file)
                    + (5 * "\n"))
            #Write letter to output_file
            output_file.write(letter)

        output_file.close()


