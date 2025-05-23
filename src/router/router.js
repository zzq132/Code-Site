import {createRouter,createWebHistory} from "vue-router"
import Layout from "@/views/Layout/index.vue"
import Home from "@/views/Home/index.vue"
import Learn from "@/views/Learn/index.vue"
import Category from "@/views/Learn/components/Category.vue"
import CourseLayout from "@/views/Learn/components/CourseLayout.vue"
import CourseCategory from "@/views/Learn/components/CourseCategory.vue"
import CourseContent from "@/views/Learn/components/CourseContent.vue"
import Login from "@/views/Login/index.vue"
import User from "@/views/User/index.vue"
import Editor from "@/views/Editor/index.vue"
import RoadMap from "@/views/RoadMap/index.vue"

const routes=[
    {
        path:"/",
        component:Layout,
        children:[
            {
                path:"",
                component:Home
            },
            {
                path: "home",
                component: Home
            },
            {
                path: "learn",
                component: Learn,
                children:[
                    {
                        path: "",
                        component: Category
                    },
                    {
                        path:":skill",
                        component:CourseLayout,
                        children:[
                            {
                              path: "",
                              component: CourseCategory
                            },
                            {
                                path:":type",
                                component:CourseContent
                            }
                        ]
                    }
                ]
            },
            {
                path: "user/:part",
                component: User
            },
            {
                path: "editor",
                component: Editor
            },
            {
                path:"roadmap",
                component: RoadMap
            }
        ]
    },
    {
        path:"/login",
        component: Login
    }
]

export const router=createRouter({
    history:createWebHistory(),
    routes:routes
})