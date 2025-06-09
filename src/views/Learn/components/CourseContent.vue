<script setup>
import {nextTick, onMounted, ref} from "vue"
import {useRoute} from "vue-router"
import {marked} from "marked"
import "github-markdown-css/github-markdown.css"
import hljs from "highlight.js";
import "highlight.js/styles/github.css"

import ChatAI from "@/components/ChatAI.vue"

let htmlContent=ref("")
let route=useRoute()

let fileName=route.params.type
let skill=route.params.skill

marked.setOptions({
  highlight: function (code, language) {
    const validLanguage = hljs.getLanguage(language) ? language : 'plaintext';
    return hljs.highlight(code, {language: validLanguage}).value;
  },
})

async function loadMarkdown() {
  try {
    const md = await import(`@/content/C++/lesson1.md?raw`)
    htmlContent.value =await marked(md.default)
    await nextTick()
    hljs.highlightAll()
  } catch (err) {
    htmlContent.value = `<h2>❌ 文档 "${fileName}".md 未找到</h2>`
  }
}

onMounted(async ()=>{
  await loadMarkdown()
})
</script>

<template>
  <div v-html="htmlContent" class="markdown-body"></div>
  <ChatAI></ChatAI>
</template>

<style scoped>
.markdown-body {
  max-width: 800px;
  margin: 2rem auto;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 0 20px var(--shadow-color);
}
</style>