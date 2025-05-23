<script setup>
import {ref,reactive} from "vue"
import {useRoute} from "vue-router"

let offset=ref(0)
let classList=ref(["Lesson1","Lesson2","CheckPoint1","Lesson3","Lesson4","Project"])
let chapters=reactive({"Chapter1":classList,"Chapter2":classList,"Chapter3":classList})

let route=useRoute()
let skill=route.params.skill
</script>

<template>
  <div class="container">
    <div class="anchor-bar">
      <el-anchor type="underline" :offset="offset">
        <el-anchor-link v-for="(value,key) in chapters" :key="key" :href="`#${key}`">
          {{key}}
          <template #sub-link>
              <el-anchor-link v-for="content in value" :key="content" :href="`#${key+content}`">{{content}}</el-anchor-link>
          </template>
        </el-anchor-link>
      </el-anchor>
    </div>
    <div class="content-container">
      <h1 class="title">{{skill}}</h1>
      <div class="block" v-for="(value,key) in chapters" :key="key">
        <h2 class="subtitle" :id="key">{{key}}</h2>
        <RouterLink :to="`/learn/${skill}/${content.toLowerCase()}`" class="content" v-for="content in value" :key="content" :id="`${key+content}`">{{content}}</RouterLink>
      </div>
    </div>
  </div>
  <RouterView></RouterView>
</template>

<style scoped>
.container{
  margin:4vh 0;
  height: 84vh;
  display: flex;
  column-gap:5%;
  overflow: auto;
}
.anchor-bar{
  padding-left: 5%;
  position: sticky;
  top:100px;
  align-self: start;
}
.content-container{
  width: 70%;
  display: flex;
  flex-direction: column;
  gap:50px;
}
.title{
  font-size: 5rem;
  align-self: center;
  color:var(--theme-color);
}
.block{
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  gap:20px;
  padding-bottom:20px;
}
.subtitle{
  font-size: 3rem;
  color:var(--theme-color);
}
.content{
  display: flex;
  align-items: center;
  height: 60px;
  font-size: 2rem;
  padding-left: 5%;
  border-radius: 20px;
  box-shadow: 0 0 10px lightgray;
}
.content:hover{
  background-color: var(--theme-hover-color);
  color: white;
}
</style>