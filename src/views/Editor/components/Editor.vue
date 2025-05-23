<script setup>
import * as monaco from 'monaco-editor'
import { onMounted, ref } from 'vue'

const editorContainer = ref(null)
const preview = ref(null)
let editorInstance = null

// 默认 HTML/JS 示例代码
const defaultCode = `<h1>Hello Monaco!</h1>
<script>
  document.body.style.backgroundColor = 'lightblue';
  console.log("Code is running...");
<\/script>
`

onMounted(() => {
  editorInstance = monaco.editor.create(editorContainer.value, {
    value: defaultCode,
    language: 'html',
    theme: 'vs-dark',
    automaticLayout: true,
  })
})

function runCode() {
  const code = editorInstance.getValue()
  if (preview.value) {
    preview.value.srcdoc = code
  }
}
</script>

<template>
  <div class="monaco-runner">
    <div class="editor-container">
      <button class="run-btn" @click="runCode">运行代码</button>
      <div ref="editorContainer" class="editor"></div>
    </div>
    <iframe ref="preview" class="preview" sandbox="allow-scripts allow-same-origin"></iframe>
  </div>

</template>

<style scoped>
.monaco-runner {
  margin-top: 4vh;
  display: flex;
  gap: 1rem;
  height: 88vh;
}
.editor-container{
  width: 50%;
  height: 100%;
  display: flex;
  flex-direction: column;
}
.editor{
  height: 100%;
}
.run-btn{
  color:white;
  border-radius: 10px;
  background-color: var(--theme-color);
  width: 60px;
  height: 30px;
  text-align: center;
}
.preview{
  width: 50%;
  height: 100%;
}
</style>
