const domain="http://127.0.0.1:5000"

async function queryModel(query){
    try {
        let response=await fetch(`${domain}`+"/model",{
            method:"POST",
            headers:new Headers({"Content-Type":"application/json"}),
            body:JSON.stringify({"query":query})
        })
        response=await response.json()
        return response.data.response
    }catch (error){
        console.log(error)
    }
}

export {
    queryModel
}