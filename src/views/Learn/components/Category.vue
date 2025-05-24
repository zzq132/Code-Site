<script setup>
import { ref } from "vue"
import Card from "./Card.vue"

// 导入所有图片
import cImage from '@/assets/languages/c.png'
import cppImage from '@/assets/languages/cpp.png'
import pythonImage from '@/assets/languages/python.png'
import javaImage from '@/assets/languages/java.png'
import htmlImage from '@/assets/languages/html.png'
import cssImage from '@/assets/languages/css.png'
import jsImage from '@/assets/languages/javascript.png'

import vueImage from '@/assets/skills/vue.png'
import tailwindImage from '@/assets/skills/tailwind.png'
import bootstrapImage from '@/assets/skills/bootstrap.png'
import springImage from '@/assets/skills/spring.png'
import springBootImage from '@/assets/skills/springboot.png'
import springCloudImage from '@/assets/skills/springcloud.png'
import mysqlImage from '@/assets/skills/mysql.png'
import gitImage from '@/assets/skills/git.png'

let offset = ref(0)
let languages = ref([
  { name: "C", image: cImage },
  { name: "C++", image: cppImage },
  { name: "Python", image: pythonImage },
  { name: "Java", image: javaImage },
  { name: "HTML", image: htmlImage },
  { name: "CSS", image: cssImage },
  { name: "JavaScript", image: jsImage }
])

let skills = ref([
  { name: "Vue", image: vueImage },
  { name: "Tailwind", image: tailwindImage },
  { name: "Bootstrap", image: bootstrapImage },
  { name: "Spring", image: springImage },
  { name: "SpringBoot", image: springBootImage },
  { name: "SpringCloud", image: springCloudImage },
  { name: "MySQL", image: mysqlImage },
  { name: "Git", image: gitImage }
])
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
        <Card v-for="language in languages" :key="language.name" :title="language.name" :image="language.image" tag="1">
        </Card>
      </div>
      <h1 class="category-title" id="skill-based">Skill Based</h1>
      <div class="skill-based">
        <Card v-for="skill in skills" :key="skill.name" :title="skill.name" :image="skill.image" tag="2"></Card>
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