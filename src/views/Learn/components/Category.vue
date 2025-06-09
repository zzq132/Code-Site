<script setup>
import { ref,onMounted } from "vue"
import Card from "./Card.vue"
import {createLearning} from "@/apis/learningAPI.js"
import {useUserStore} from "@/stores/user.js"
import {useCourseStore} from "@/stores/course.js"

let offset = ref(0)
let languages = ref([])
let skills = ref([])
let chapterContents=["Lesson1","Lesson2","CheckPoint1","Lesson3","Lesson4","Project"]
let chapters=["Chapter1","Chapter2","Chapter3"]
let courseStructure=ref({})
for(let chapter of chapters){
  let temp={}
  for(let content of chapterContents){
    temp[content]=false
  }
  courseStructure.value[chapter]=temp
}
courseStructure.value.isLearn=false

let userStore=useUserStore()
let courseStore=useCourseStore()

async function parseResponse(){
  for (let val of courseStore.courseInfo) {
    if("token" in userStore.userInfo)
      userStore.userLearning[val.course_name]=courseStructure.value
    if(val.type==="language"){
      let image=await import(`@/assets/languages/${val.course_name.toLowerCase()}.png`)
      languages.value.push({
        "name":val.course_name,
        "image":image.default,
        "author":val.author,
        "description":val.description
      })
    }
    else if(val.type==="skill"){
      let image=await import(`@/assets/skills/${val.course_name.toLowerCase()}.png`)
      skills.value.push({
        "name":val.course_name,
        "image":image.default,
        "author":val.author,
        "description":val.description
      })
    }
  }
}

async function learn(skill){
  if(!userStore.userLearning[skill]){
    userStore.userLearning[skill]=true
    let learning={user_id:userStore.userInfo.user.id,progress:0}
    for(let course of courseStore.courseInfo){
      if(course.course_name===skill.name){
        learning.course_id=course.id
      }
    }
    console.log(learning)
    let response=await createLearning(learning)
    if(response.code){
      console.log("Success")
    }else{
      console.log("Failed")
    }
  }
}

onMounted(()=>{
  parseResponse()
})

</script>

<template>
  <div class="container">
    <div class="anchor-bar">
      <el-anchor type="underline" :offset="offset">
        <el-anchor-link href="#language-based">
          Language Based
          <template #sub-link>
            <el-anchor-link v-for="language in languages" :key="language.name"
              :href="`#${language.name.toLowerCase()}`">{{ language.name }}</el-anchor-link>
          </template>
        </el-anchor-link>
        <el-anchor-link href="#skill-based">
          Skill Based
          <template #sub-link>
            <el-anchor-link v-for="skill in skills" :key="skill.name" :href="`#${skill.name.toLowerCase()}`">{{
              skill.name }}</el-anchor-link>
          </template>
        </el-anchor-link>
      </el-anchor>
    </div>
    <div class="category-container">
      <h1 class="category-title" id="language-based">Language Based</h1>
      <div class="language-based">
        <Card v-for="language in languages" @click="learn(language)" :key="language.name" :title="language.name" :image="language.image" :author="language.author" :description="language.description" tag="1">
        </Card>
      </div>
      <h1 class="category-title" id="skill-based">Skill Based</h1>
      <div class="skill-based">
        <Card v-for="skill in skills" @click="learn(skill)" :key="skill.name" :title="skill.name" :image="skill.image" :author="skill.author" :description="skill.description"  tag="2"></Card>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  margin-top: 5%;
  height: auto;
  display: flex;
  column-gap: 5%;
  justify-content: center;
  align-items: center;
}

.anchor-bar {
  position: sticky;
  top: 100px;
  padding-left: 5%;
  align-self: start;
}

.category-container {
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  gap: 50px;
}

.language-based {
  display: flex;
  flex-wrap: wrap;
  gap: 50px;
}

.skill-based {
  display: flex;
  flex-wrap: wrap;
  gap: 50px;
}

.category-title {
  font-size: 3rem;
}
</style>