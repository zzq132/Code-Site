<script setup>
import {ref} from "vue"
import {useRouter} from "vue-router"
import {ElNotification} from "element-plus"
import {login} from "@/apis/userAPI.js"
import {useUserStore} from "@/stores/user.js"

let email=ref("")
let password=ref("")

let router=useRouter()
let userStore=useUserStore()

async function submit(){
  let config={
    method:"POST",
    body:JSON.stringify({"email":email.value,"password":password.value}),
    headers:new Headers({"Content-Type":"application/json"})
  }
  try {
    let response=await login(config)
    if(response.code==1){
      Object.entries(response.data).forEach((pair)=>{
        userStore.userInfo[pair[0]]=pair[1]
      })
      ElNotification({
        title:"Info",
        message:"Login Successfully!",
        type:"success"
      })
      setTimeout(()=>{
        router.push("/")
      },2000)
    } else{
      ElNotification({
        title: "Info",
        message: "Login Failed!",
        type: "error"
      })
    }
  }catch (err){
    console.log(err)
    ElNotification({
      title: "Info",
      message: "Login Failed!",
      type: "error"
    })
  }

}
</script>

<template>
  <div class="container">
    <div class="login">
      <div class="left-side">
        <p class="image"></p>
      </div>
      <div class="right-side">
        <form @submit.prevent="submit">
          <fieldset class="input-fields">
            <legend>Login</legend>
            <div class="field">
              <label for="email">Email</label>
              <input type="email" id="email" v-model="email"/>
            </div>
            <div class="field">
              <label for="password">Password</label>
              <input type="password" id="password" v-model="password"/>
            </div>
          </fieldset>
          <fieldset class="link-fields">
            <a href="#">Sign Up</a>
            <a href="#">Forget Password</a>
          </fieldset>
          <button class="submit-btn" @click="submit">Login</button>
        </form>
        <RouterLink to="/" class="home-link">Back Home</RouterLink>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container{
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login{
  display: flex;
  width: 50%;
  height: 60%;
  justify-content: center;
  align-items: center;
  border-radius: 20px;
  box-shadow: 0 0 20px var(--shadow-color);
}
.left-side{
  width: 50%;
  height: 100%;
  overflow: hidden;
}
.image{
  width: 100%;
  height: 100%;
  background-image: url("../../../assets/background/snow-mountain.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  border-radius: 20px 25% 25% 20px;
}
.right-side{
  width: 50%;
  height: 100%;
  padding:5%;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
form{
  display: flex;
  flex-direction: column;
  gap:20px;
}
legend{
  width: 100%;
  display: flex;
  margin-bottom: 30px;
  justify-content: center;
  font-size: 2rem;
  font-weight: bold;
}
label{
  font-size: 1.7rem;
  font-weight: bold;
}
.input-fields{
  display: flex;
  flex-direction: column;
  gap:30px;
}
.field{
  display: flex;
  flex-direction: column;
  gap:20px;
}
.input-fields input{
  border: solid black 2px;
  border-radius: 10px;
  padding-left: 10px;
  height: 25px;
}
.link-fields{
  display: flex;
  justify-content: space-between;
}
.link-fields a{
  color:gray;
  cursor: pointer;
}
.submit-btn{
  margin-top: 30px;
  padding:5px 20px;
  align-self: center;
  font-size: 1.5rem;
  border: solid 2px black;
  border-radius: 10px;
}
.submit-btn:hover{
  background-color: var(--theme-hover-color);
  border-color: white;
  color:white;
}
.home-link{
  align-self: end;
  cursor: pointer;
  color: gray;
}
</style>