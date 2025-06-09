import "@/styles/main.css"
import { createApp } from 'vue'
import {router} from "@/router/router.js"
import {createPinia} from "pinia"
import piniaPluginPersistedstate from "pinia-plugin-persistedstate"
import App from './App.vue'
import 'element-plus/dist/index.css'
import "//at.alicdn.com/t/c/font_4817142_qf67gbs3fch.js"

const app=createApp(App)
const pinia=createPinia()
pinia.use(piniaPluginPersistedstate)
app.use(router)
app.use(pinia)
app.mount('#app')
