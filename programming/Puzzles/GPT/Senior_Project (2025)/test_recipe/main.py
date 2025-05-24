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
                open("template.txt").read()
            ),
            # The `variable_name` here is what must align with memory
            MessagesPlaceholder(variable_name="chat_history"),
            HumanMessagePromptTemplate.from_template("{question}"),
        ]
    )

    # Notice that we `return_messages=True` to fit into the MessagesPlaceholder
    # Notice that `"chat_history"` aligns with the MessagesPlaceholder name
    memory = ConversationBufferMemory(memory_key="chat_history", return_messages=True)
    conversation = LLMChain(llm=llm, prompt=prompt, verbose=False, memory=memory)
    return conversation




def output_recipe(conversation):
    # Get OpenAI Response
    response = conversation(
        {
            "question": open("template.txt").read()
        })
    return response['text']
 


def __main__():

    if __name__ == "__main__":
        conv = define_model()
        recipe = output_recipe(conv)

        with open("output.txt", "w") as file:
            file.write(recipe)

__main__()



