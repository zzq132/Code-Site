from flask import Flask,jsonify,request
from flask_cors import CORS
from .model import query

app = Flask(__name__)
CORS(app)

@app.route('/')
def hello_world():  # put application's code here
    return 'Hello World!'

@app.route("/model",methods=["POST"])
def query_model():
    question=request.json.get("query")
    result=query(question)

    response={"code":1,"message":"Success","data":{"response":result}}
    return jsonify(response)

if __name__ == '__main__':
    app.run(debug=True)
