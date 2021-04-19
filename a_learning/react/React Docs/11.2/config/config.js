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
            component: "../layout/index",
            routes: [
                { path: "/", component: "./index" }, //路径是相对于pages
                { path: "/goods", component: "./goods" },
                {
                    path: "/about",
                    component: "./about",
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
                { component: "./notfound" }
            ]
        },

    ]
}