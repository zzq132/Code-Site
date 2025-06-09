import {defineStore} from "pinia"
import {ref,computed} from "vue"

let useUserStore=defineStore("userStore",()=>{
    let userInfo=ref({})
    let userLearning=ref({})
    let userLearningProgress=computed(()=>{
        let learn={}
        if(Object.keys(userLearning.value).length!==0){
            Object.entries(userLearning.value).forEach((pair)=>{
                let totalCourse=0
                let learnedCoures=0
                Object.entries(pair[1]).forEach((pair1)=>{
                    Object.entries(pair1[1]).forEach((pair2)=>{
                        totalCourse+=1
                        if(pair2[1])
                            learnedCoures+=1
                    })
                })
                learn[pair[0]]=Math.round((learnedCoures/totalCourse)*100)
            })
        }
        return learn
    })
    return {userInfo,userLearning,userLearningProgress}
},{
    persist:true
})

export {
    useUserStore
}