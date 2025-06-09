<script setup>
import {ref, onMounted, nextTick} from "vue"
import {queryModel} from "@/apis/modelAPI.js";
import {marked} from "marked";
import "github-markdown-css/github-markdown.css"
import hljs from "highlight.js";
import "highlight.js/styles/github.css"

let msg=ref("")
let messages=ref([])

async function sendMsg(){
  let message={user:msg.value,model:"...."}
  messages.value.push(message)
  msg.value=""
  let md=await queryModel(msg.value)
  md=md.replace(/<think>[\s\S]*<\/think>/,"")
  messages.value[messages.value.length-1].model=await marked(md)
  await nextTick()
  hljs.highlightAll()
}

function addCloseListener(){
  let hideBtn=document.querySelector(".icon")
  let chatBox=document.querySelector(".chatBox")
  let showBtn=document.querySelector(".show-button")
  hideBtn.addEventListener("click",()=>{
    chatBox.classList.toggle("hide")
    showBtn.classList.toggle("show")
  })
  showBtn.addEventListener("click",()=>{
    chatBox.classList.toggle("hide")
    showBtn.classList.toggle("show")
  })
}

onMounted(()=>{
  addCloseListener()
})
</script>

<template>
  <div class="chatBox">
    <div class="header">
      <svg class="icon hide-button" aria-hidden="true">
        <use xlink:href="#icon-cuowu2"></use>
      </svg>
      <h2 class="title">Coding Assistant</h2>
    </div>
    <hr class="segregate">
    <div class="message-box">
      <div v-for="(message,index) in messages" :key="index" class="message">
        <div>
          <i class="iconfont icon-yonghu"></i><span>{{message.user}}</span>
        </div>
        <div>
          <i class="iconfont icon-robot"></i><span v-html="message.model" class="markdown-body"></span>
        </div>
      </div>
    </div>
    <div class="operation-bar">
      <input type="text" placeholder="Input your question..." v-model="msg" @keyup.enter="sendMsg">
      <input type="button" value="Send" @click="sendMsg">
    </div>
  </div>
  <button class="show-button"><i class="iconfont icon-shuangzuojiantou"></i></button>
</template>

<style scoped>
.markdown-body {
  max-width: 400px;
  box-shadow: 0 0 20px var(--shadow-color);
}
.iconfont{
  font-size: 2rem;
}
.chatBox{
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  width: 350px;
  height: 550px;
  position: fixed;
  right: 30px;
  top:200px;
  background-color: white;
  box-shadow: 0 0 10px var(--shadow-color);
  border-radius: 10px;
  padding: 10px 10px;
  transition: transform 1s ;
}
.header{
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 6%;
  position: relative;
}
.segregate{
  width: 90%;
  height: 1px;
  background-color: var(--icon-color);
  border-radius: 5px;
  border:none;
}
.hide{
  transform:scale(0);
}
.hide-button{
  fill:orange;
  position: absolute;
  padding:0 2px;
  top:5px;
  left:5px;
  width: 17px;
  height: 17px;
}
.title{
  justify-self: center;
  text-align: center;
  color: var(--theme-color);
}
.message-box{
  width: 100%;
  height: 80%;
  display: flex;
  flex-direction: column;
  align-items: start;
  font-size: 1.5rem;
  overflow-y: scroll;
}
.message{
  width: 100%;
}
.message > div{
  margin-bottom:10px;
  display: flex;
  align-items: start;
}
.message span{
  display: inline-block;
  max-width: 80%;
  min-height: 5%;
  background-color: lightgray;
  border-radius: 10px;
  padding:5px 10px;
  margin:0 5px;
  overflow-wrap: anywhere;
}
.operation-bar{
  width: 100%;
  height: 7%;
  display: flex;
  align-items: center;
  gap:3%;
}
.operation-bar input[type="text"]{
  width: 80%;
  height: 25px;
  border:black 2px solid;
  border-radius: 7px;
  padding-left: 10px;
}
.operation-bar input[type="button"]{
  width: 15%;
  height: 25px;
  background-color: var(--theme-color);
  border-radius: 5px;
  color:white;
  text-align: center;
}
.operation-bar input[type="button"]:hover{
  background-color: var(--theme-hover-color);
}
button.show{
  transform: scale(1);
}
.show-button{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30px;
  height: 50px;
  position: fixed;
  right: 0;
  top:50vh;
  transform:scale(0);
  transition: transform 1s;
  background-color: white;
  box-shadow: 0 0 10px lightgray;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
}
.show-button:hover{
  background-color: #d6d6d6;
}
</style>