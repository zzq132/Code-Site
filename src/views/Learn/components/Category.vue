<script setup>
import {ref} from "vue"
import Card from "./Card.vue"

let offset=ref(0)
let languages=ref(["C","C++","Python","Java","HTML","CSS","JavaScript"])
let skills=ref(["Vue","Tailwind","Bootstrap","Spring","SpringBoot","SpringCloud","MySQL","Git"])
</script>

<template>
  <div class="container">
    <div class="anchor-bar">
      <el-anchor type="underline" :offset="offset">
        <el-anchor-link href="#language-based">
          Language Based
          <template #sub-link>
            <el-anchor-link v-for="language in languages" :key="language" :href="`#${language.toLowerCase()}`">{{language}}</el-anchor-link>
          </template>
        </el-anchor-link>
        <el-anchor-link href="#skill-based">
          Skill Based
          <template #sub-link>
            <el-anchor-link v-for="skill in skills" :key="skill" :href="`#${skill.toLowerCase()}`">{{skill}}</el-anchor-link>
          </template>
        </el-anchor-link>
      </el-anchor>
    </div>
    <div class="category-container">
      <h1 class="category-title" id="language-based">Language Based</h1>
      <div class="language-based">
        <Card v-for="title in languages" key="title" :title="title" tag="1"></Card>
      </div>
      <h1 class="category-title" id="skill-based">Skill Based</h1>
      <div class="skill-based">
        <Card v-for="title in skills" key="title" :title="title" tag="2"></Card>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container{
  margin-top: 5%;
  height: auto;
  display: flex;
  column-gap:5%;
  justify-content: center;
  align-items: center;
}
.anchor-bar{
  position: sticky;
  top:100px;
  padding-left: 5%;
  align-self: start;
}
.category-container{
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  gap:50px;
}
.language-based{
  display: flex;
  flex-wrap: wrap;
  gap:50px;
}
.skill-based{
  display: flex;
  flex-wrap: wrap;
  gap:50px;
}
.category-title{
  font-size: 3rem;
}
</style>