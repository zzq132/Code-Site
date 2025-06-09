import {defineStore} from "pinia"
import {ref} from "vue"

let useCourseStore=defineStore("courseStore",()=>{
    let courseInfo=ref([])
    return {courseInfo}
},{
    persist:true
})

export {
    useCourseStore
}