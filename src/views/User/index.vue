<script setup>
import UserInfo from "@/views/User/components/UserInfo.vue"
import {RouterView} from "vue-router"
</script>

<template>
  <div class="user-container">
    <UserInfo></UserInfo>
    <div class="content-area">
      <RouterView></RouterView>
    </div>
  </div>
</template>

<style scoped>
.user-container {
  display: flex;
  height: 92vh;
  margin-top: 8vh;
  position: relative;
}

.content-area {
  flex-grow: 1;
  padding: 0 20px;
  margin-left: 20%;
  z-index: -1;
}
</style>