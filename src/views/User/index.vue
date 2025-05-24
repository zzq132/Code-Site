<script setup>
import UserInfo from "@/views/User/components/UserInfo.vue"
import {RouterView} from "vue-router"
</script>

<template>
  <div class="user-container">
    <UserInfo />
    <div class="content-area">
      <RouterView></RouterView>
    </div>
  </div>
</template>

<style scoped>
.user-container {
  display: flex;
  width: 100%;
  height: 100%;
}

.content-area {
  flex: 1;
  padding: 10px;
  margin-left: 110px;
}
</style>