
const domain="http://127.0.0.1:8080"

async function getUserLearning(userId){
    try{
        let response=await fetch(`${domain}`+"/learning"+`/${userId}`)
        response=await response.json()
        return response.data.learning
    }catch (error){
        console.log(error)
    }
}

async function updateUserLearning(requestBody){
    try {
        let response=await fetch(`${domain}`+"/learning",{
            method:"PATCH",
            body:JSON.stringify(requestBody),
            headers:new Headers({"Content-Type":"application/json"})
        })
        response=await response.json()
        return response.code
    }catch (error){
        console.log(error)
    }
}

async function createLearning(learning){
    try {
        let response=await fetch(`${domain}`+"/learning",{
            method:"POST",
            body:JSON.stringify(learning),
            headers:new Headers({"Content-Type":"application/json"})
        })
        response=response.json()
        return response
    }catch (error){
        console.log(error)
    }
}

export {
    getUserLearning,updateUserLearning,createLearning
}