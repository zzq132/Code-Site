const domain="http://127.0.0.1:8080"

async function login(config){
    try {
        let response=await fetch(`${domain}`+"/login",config)
        response=await response.json()
        return response
    }catch (error){
        console.log(error)
    }
}

async function getUserInfo(userId){
    try {
        let response=await fetch(`${domain}`+"/user"+`/${userId}`)
        response=await response.json()
        return response.data
    }catch (error){
        console.log(error)
    }
}

export {
    login,getUserInfo
}