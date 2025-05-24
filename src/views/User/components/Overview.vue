<script setup>
import { reactive } from "vue"

let userInfo = reactive({ "User Name": "Zzz", "Age": 21, "Gender": "Male", "Occupation": "Student" })
let learningInfo = reactive({ "Python": 30, "C++": 20, "HTML": 80 })
</script>

<template>
  <div class="content">
    <h1 class="title">Overview</h1>
    <div class="info">
      <h1>User Information</h1>
      <div class="user-info">
        <div v-for="(value, key) in userInfo" :key="key" class="userInfo-item">
          <h2>{{ key }}</h2>
          <p>{{ value }}</p>
        </div>
      </div>
      <br>
      <h1>Learning Progress</h1>
      <div class="learning-info">
        <div v-for="(value, key) in learningInfo" :key="key" class="learningInfo-item">
          <span>{{ key }}</span>
          <div class="progress-container">
            <p class="progress-bar" :style="{ width: value + '%' }"></p>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>
.title {
  font-size: 3rem;
}

.content {
  width: 80%;
  height: auto;
  display: flex;
  flex-direction: column;
  gap: 5%;
  margin-right: 5%;
}

.info {
  display: flex;
  height: 100%;
  padding: 5%;
  flex-direction: column;
  gap: 5%;
  box-shadow: 0 0 10px var(--shadow-color);
  border-radius: 20px;
}

.user-info {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  padding: 5%;
  gap: 20px;
  border-radius: 10px;
  background-color: #F7FAFC;
  box-shadow: 0 0 10px var(--shadow-color);
}

.userInfo-item {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.userInfo-item p {
  font-size: 1.5rem;
}

.learning-info {
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 5%;
  border-radius: 10px;
  background-color: #F7FAFC;
  box-shadow: 0 0 10px var(--shadow-color);
}

.learningInfo-item {
  display: flex;
  align-items: center;
  gap: 5%;
  font-size: 1.5rem;
  height: 30px;
}

.learningInfo-item span:nth-child(1) {
  width: 15%;
  height: 30px;
}

.progress-container {
  width: 80%;
  height: 60%;
  border-radius: 10px;
  overflow: hidden;
  background-color: #e1e0e0;
}

.progress-bar {
  height: 100%;
  background-color: #4eacf8;
}
</style>