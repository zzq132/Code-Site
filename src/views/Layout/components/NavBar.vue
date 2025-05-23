<script setup>
import {ref} from "vue";

const category=ref(["Home","Learn","RoadMap","Editor"])

</script>

<template>
  <nav class="navbar">
    <div class="container">
      <!--Logo-->
      <div class="nav-left">
        <RouterLink to="/">Logo</RouterLink>
      </div>
      <!--Collapse Button-->
<!--      <button>Show</button>-->
      <!--Nav Link-->
      <div class="nav-center">
        <RouterLink v-for="item in category" key="item" :to="`/${item.toLowerCase()}`">{{item}}</RouterLink>
      </div>
      <div class="nav-right">
        <RouterLink to="/user/overview">User</RouterLink>
        <RouterLink to="/login">Register | Login</RouterLink>
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
a:hover{
  background-color: var(--theme-hover-color);
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
  width: 30%;
}
.nav-left{
  display: flex;
  align-items: center;
  gap:10%;
  width: 30%;
  padding-left: 20px;
}
.nav-right{
  display: flex;
  justify-content: right;
  align-items: center;
  gap:10%;
  width: 30%;
  padding-right: 20px;
}
</style>