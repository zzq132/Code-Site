<script setup>
import { useRoute, RouterLink } from "vue-router"

let route = useRoute()
let part = route.params
</script>

<template>
  <div class="panel">
    <div class="logo">
      <h1>Code Site</h1>
    </div>
    <hr>
    <div class="user">
      <img src="@/assets/logo/zzz.jpg" alt="user-image">
      <p>Zzz</p>
    </div>
    <hr>
    <div class="nav">
      <RouterLink to="/user/overview" class="nav-item" active-class="active">
        <i class="iconfont icon-home"></i>
        <span>Overview</span>
      </RouterLink>
      <RouterLink to="/user/account" class="nav-item" active-class="active">
        <i class="iconfont icon-Account"></i>
        <span>Account</span>
      </RouterLink>
      <RouterLink to="/user/settings" class="nav-item" active-class="active">
        <i class="iconfont icon-setting"></i>
        <span>Settings</span>
      </RouterLink>
    </div>
    <hr>
    <div class="log-out">
      <img src="@/assets/logo/zzz.jpg" alt="user-image">
      <p><span>Zzz</span><i class="iconfont icon-logout"></i></p>
    </div>
  </div>
</template>

<style scoped>
hr {
  border: none;
  height: 1px;
  background-color: var(--shadow-color);
}

.container {
  height: 110vh;
  display: flex;
  margin-top: 4vh;
  gap: 5%;
}

.panel {
  display: flex;
  flex-direction: column;
  align-self: start;
  width: 15%;
  height: 80vh;
  box-shadow: 0 0 10px var(--shadow-color);
  border-radius: 20px;
  margin-left: 3%;
  margin-top: 3%;
}

.logo {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
  gap: 20px;
  color: var(--theme-color);
  font-size: 1.3rem;
}

img {
  max-width: 50%;
  max-height: 50%;
}

.user {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
  gap: 20px;
  font-weight: bold;
  font-size: 1.4rem;
}

.user img {
  max-width: 35%;
  max-height: 35%;
  border-radius: 50%;
  box-shadow: 0 0 10px var(--shadow-color);
}

.nav {
  display: flex;
  flex-direction: column;
  flex-grow: 4;
}

.nav-item {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  height: 50px;
}

.nav-item span {
  width: 50%;
  font-size: 1.2rem;
  font-weight: bold;
  color: var(--icon-color);
}

.nav-item i {
  color: var(--icon-color);
}

.log-out {
  display: flex;
  gap: 20px;
  justify-content: center;
  align-items: center;
}

.log-out i {
  color: var(--icon-color);
}

.log-out img {
  max-width: 30%;
  max-height: 30%;
  border-radius: 50%;
}

.log-out p {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
}

.active {
  background-color: var(--theme-color-light);
  color: var(--theme-color);
}

.active i {
  color: var(--theme-color);
}
</style>