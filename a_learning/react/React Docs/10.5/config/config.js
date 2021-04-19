export default {
    //路由配置
    routes: [
        {path:"/",component:"./index"}, //路径是相对于pages
        {path:"/about",component:"./about"},
        {
            path:"/users",
            component:"./users/_layout",
            routes:[
                {path:"/users/",component:"./users/index"},
                {path:"/users/:name",component:"./users/$name"}
            ]
        },
        {component:"./notfound"}
    ]
}