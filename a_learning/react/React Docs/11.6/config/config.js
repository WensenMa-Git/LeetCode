export default {
    //插件配置
    plugins: [
        [
            "umi-plugin-react",
            {
                antd: true,
                dva: true,
            }
        ]
    ],
    //路由配置
    routes: [
        { path: "/login", component: "./login" },
        {
            path: "/",
            component: "../layout",
            routes: [
                { path: "/", redirect:"/home" ,name:'首页'}, //路径是相对于pages
                { path: "/home", component: "./home" ,name:'首页'}, //路径是相对于pages
                { path: "/home/pageview", component: "./home/report/pageview",name:'页面浏览人次' },
                { path: "/home/userview", component: "./home/report/userview",name:'用户浏览人次' },
                { path: "/home/setpage", component: "./home/setting/setpage",name:'页面设置' },
                { path: "/home/setlanguage", component: "./home/setting/setlanguage",name:'语言设置' },
                { path: "/goods", component: "./goods",name:"商品页" },
                {
                    path: "/about",
                    component: "./about",
                    name:"关于页面",
                    Routes: ["./routes/PrivateRoute.js"]  //路由守卫配置编写 路径相对于根目录， 后缀名不能省略
                },
                {
                    path: "/users",
                    component: "./users/_layout",
                    routes: [
                        { path: "/users/", component: "./users/index" },
                        { path: "/users/:name", component: "./users/$name" }
                    ]
                },
                { component: "./notfound",name:'404页面' }
            ]
        },

    ]
}