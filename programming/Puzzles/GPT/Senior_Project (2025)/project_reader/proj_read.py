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




class proj_read:


    #Initialize class with settings
    def __init__(self, settings):
        self.settings = settings
        

    def define_model(self, prompt_file, document_file):
         # LLM

        llm = ChatOpenAI(
            model_name="gpt-3.5-turbo",
            openai_api_key=os.environ.get('OPENAI_API_KEY'),
        )

        # Prompt
        prompt = ChatPromptTemplate(
            messages=[
                SystemMessagePromptTemplate.from_template(
                    prompt_file.read() + document_file.read()
                ),
                MessagesPlaceholder(variable_name="chat_history"),
                HumanMessagePromptTemplate.from_template("{question}"),
            ]
        )

        memory = ConversationBufferMemory(memory_key="chat_history", return_messages=True)
        conversation = LLMChain(llm=llm, prompt=prompt, verbose=False, memory=memory)
        return conversation
    


    def output_info(self, conversation, question_file):
        # Get OpenAI Response
        response = conversation(
            {
                "question": question_file.read()
            })
        return response['text']
    


    def run(self):

        #Find local directory
        path = os.path.dirname(__file__) + "/"

        #Download prompt, question, and proposal
        id = int(self.settings[0])
        prompt_file = open(path + self.settings[1][:-1])
        question_file = open(path + self.settings[2][:-1])
        document_file = open(path + "input/" + str(id) + ".txt", 'r')
        output_file = open(path + "output/" + self.settings[3], 'a')

        #Init conv
        conv = self.define_model(
            prompt_file = prompt_file, document_file = document_file
            )

        #Return proposal info

        output_file.write(self.output_info(conv, question_file))
    







    

