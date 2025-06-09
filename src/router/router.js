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
import RoadmapLayout from "@/views/Roadmap/index.vue"
import Categories from "@/views/Roadmap/components/Categories.vue"
import Roadmap from "@/views/Roadmap/components/Roadmap.vue"
import Overview from "@/views/User/components/Overview.vue"
import Account from "@/views/User/components/Account.vue"
import Settings from "@/views/User/components/Settings.vue"

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
                                name:"content",
                                component:CourseContent
                            }
                        ]
                    }
                ]
            },
            {
                path: "user",
                component: User,
                children:[
                    {
                        path:"overview",
                        component: Overview
                    },
                    {   
                        path:"account",
                        component: Account
                    },
                    {
                        path:"settings",
                        component: Settings
                    }
                ]
            },
            {
                path: "editor",
                component: Editor
            },
            {
                path:"roadmap",
                component: RoadmapLayout,
                children:[
                    {
                        path:"",
                        component:Categories
                    },
                    {
                        path: ":road",
                        component: Roadmap
                    }
                ]
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