//因为本地mock没数据库，所以我们在这里模拟数据
let data=[
    {title:'vue单页面电商项目'},
    {title:'react单页面后台管理项目'}
]

export default {
    //method  url   跟我们node编写的express是一样的
    "get /api/goods" :function(req,res){
        setTimeout(()=>{
            res.json({result:data})
        },1000)
    }
}