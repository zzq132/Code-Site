<script setup type="module">
import {onMounted} from "vue"
import {useRoute} from "vue-router"
import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@11/dist/mermaid.esm.min.mjs'

import ChatAI from "@/components/ChatAI.vue"

mermaid.initialize({
  startOnLoad: false,
  theme:"base",
  themeVariables:{
    mainBkg:"#FDFF00",
    primaryBorderColor:"#000000",
    fontSize:"18px"
  }
});

let route=useRoute()

async function renderRoadMap(){
  let response=await fetch(`/src/graph/${route.params.road}.mmd`)
  let data=await response.text()
  const container = document.querySelector(".mermaid");
  container.innerHTML = data;
  await mermaid.run()
}

function addHoverListener(){
  let nodes=document.querySelectorAll(".node")
  nodes.forEach((node)=>{
    let child=node.querySelector("rect")
    node.addEventListener("mouseover",()=>{
      child.style.fill="#d3d841"
    })
    node.addEventListener("mouseout",()=>{
      child.style.fill="#fdff00"
    })
  })
}

onMounted(async ()=>{
  await renderRoadMap()
  addHoverListener()
})

</script>

<template>
  <div class="mermaid-container">
    <div class="mermaid"></div>
  </div>
  <ChatAI></ChatAI>
</template>

<style scoped>
.mermaid-container{
  display: flex;
  justify-content: center;
  margin:2rem auto;
}
.mermaid{
  width: 80%;
  display: flex;
  justify-content: center;
}
svg{
  width: 100%;
}
</style>