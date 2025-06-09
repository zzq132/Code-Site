
const domain="http://127.0.0.1:8080"

async function getAllCourses(){
    try {
        let response=await fetch(`${domain}`+"/courses")
        let data=await response.json()
        return data.data.course
    }catch (error){
        console.log(error)
    }
}

export {
    getAllCourses
}