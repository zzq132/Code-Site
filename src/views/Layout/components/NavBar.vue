<script setup>
import {ref} from "vue"
import {useUserStore} from "@/stores/user.js"

const category=ref(["Home","Learn","Roadmap","Editor"])

let userStore=useUserStore()
let tag=ref(("token" in userStore.userInfo))

</script>

<template>
  <nav class="navbar">
    <div class="container">
      <!--Logo-->
      <div class="nav-left">
        <RouterLink to="/"><img src="@/assets/logo/zzz.jpg" alt="logo"/><span>Code Site</span></RouterLink>
      </div>
      <!--Collapse Button-->
<!--      <button>Show</button>-->
      <!--Nav Link-->
      <div class="nav-center">
        <RouterLink class="nav-item" v-for="item in category" key="item" :to="`/${item.toLowerCase()}`">{{item}}</RouterLink>
      </div>
      <div class="nav-right">
        <RouterLink class="nav-item" to="/user/overview" v-if="tag">User</RouterLink>
        <RouterLink class="nav-item" to="/login" v-if="!tag">Register | Login</RouterLink>
        <button class="nav-item logout-btn" v-else>Logout</button>
      </div>
    </div>
  </nav>
</template>

<style scoped>
.navbar{
  height: 8vh;
  position: sticky;
  top:0;
}
a{
  color:white;
  height: 60%;
  display: flex;
  align-items: center;
  padding:0 10px;
  border-radius: 10px;
}
.nav-item:hover{
  background-color: var(--theme-hover-color);
}
.logout-btn{
  color:white;
  height: 60%;
  display: flex;
  align-items: center;
  padding:0 10px;
  border-radius: 10px;
}
.container{
  height: inherit;
  display: flex;
  justify-content: space-between;
  background-color: var(--theme-color);
  font-size: 1.8rem;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  box-shadow: 0 10px 10px rgba(182, 181, 181, 0.78);
}
.nav-center{
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 35%;
}
.nav-left{
  display: flex;
  align-items: center;
  width: 30%;
  padding-left: 20px;
}
.nav-left img{
  max-height: 100%;
  border-radius: 10px;
}
.nav-left span{
  margin-left: 15px;
}
.nav-right{
  display: flex;
  justify-content: right;
  align-items: center;
  gap:3%;
  width: 30%;
  padding-right: 20px;
}
</style>