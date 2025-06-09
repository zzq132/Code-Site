<script setup>
defineProps(["title","image"])
</script>

<template>
  <RouterLink :to="`/roadmap/${title}`" class="card-container">
    <img class="image" :src="image" :alt="`${title}-image`" />
    <div class="content">
      <p class="title">{{ title }} Roadmap</p>
      <p class="category">Category: {{ title }} technique</p>
      <p class="description">Description:The intelligent AI model provides road map</p>
    </div>
  </RouterLink>
</template>

<style scoped>
.card-container {
  color: black;
  width: 60%;
  height: 600px;
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 0 10px lightgray;
  margin-bottom: 20px;
}

.content {
  margin-top: 2px;
  padding: 5%;
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.title {
  font-size: 3rem;
  font-weight: bolder;
  color: var(--theme-color);
}

.title:hover {
  color: #0099ff;
}

.category {
  font-size: 2rem;
  font-weight: bold;
}

.description {
  font-size: 2rem;
  font-weight: bold;
}

.image {
  max-width: 100%;
  height: 65%;
}
</style>