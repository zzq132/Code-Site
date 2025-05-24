<script setup>
import { ref } from 'vue'
import Card from './Card.vue'

import frontendImage from "@/assets/categories/Frontend.png"
import backendImage from "@/assets/categories/Backend.png"
import databaseImage from "@/assets/categories/Database.png"
import developtoolImage from "@/assets/categories/DevelopmentTools.png"

let offset = ref(0)
let categories = ref([
  { name: "Frontend", image: frontendImage },
  { name: "Backend", image: backendImage },
  { name: "Database", image: databaseImage },
  { name: "DevelopmentTools", image: developtoolImage },
])
</script>

<template>
  <div class="container">
    <div class="anchor-bar">
      <el-anchor type="underline" :offset="offset">
        <el-anchor-link href="#category-based">
          Category Based
          <template #sub-link>
            <el-anchor-link v-for="maps in categories" :key="maps.name" :href="`#${maps.name.toLowerCase()}`">{{
              maps.name }}</el-anchor-link>
          </template>
        </el-anchor-link>
      </el-anchor>
    </div>
    <div class="category-container">
      <h1 class="category-title" id="category-based">Category Based</h1>
      <div class="category-based">
        <Card v-for="category in categories" :key="category.name" :title="category.name" :image="category.image"></Card>
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

.category-based {
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