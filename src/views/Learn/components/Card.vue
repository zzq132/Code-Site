<script setup>
defineProps(["title", "tag","image","author","description"])
</script>

<template>
  <RouterLink :to="`/learn/${title}`" class="card-container">
    <img class="image" :src="image" :alt="`${title}-image`" />
    <div class="content">
      <p v-if="tag == '1'" class="title">{{ title }} Programming</p>
      <p v-else-if="tag == '2'" class="title">{{ title }}</p>
      <p class="author">Author: {{author}}</p>
      <p class="description">{{description.replace("。","")}}</p>
    </div>
  </RouterLink>
</template>

<style scoped>
.card-container {
  color: black;
  width: 280px;
  height: 300px;
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 0 10px lightgray;
}

.content {
  margin-top: 10px;
  padding: 5%;
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.title {
  font-size: 1.8rem;
  font-weight: bolder;
  color: var(--theme-color);
}

.title:hover {
  color: #0099ff;
}

.author {
  font-size: 1.6rem;
  font-weight: bold;
}

.description {
  font-size: 1.4rem;
}
</style>