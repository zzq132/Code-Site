from langchain_core.prompts import ChatPromptTemplate
from langchain_ollama import ChatOllama

def query(question):
    #Prompt
    prompt_template=ChatPromptTemplate.from_messages([
        ("system","你是一个辅助用户学习编程的助手。将你的回答以markdown格式返回。"),
        ("user","{question}")
    ])
    prompt=prompt_template.invoke({"question":question})

    #Model
    model=ChatOllama(model="deepseek-r1:7b")

    return model.invoke(prompt).content