import React from 'react'
import { BrowserRouter,Link,Route,Switch} from 'react-router-dom'

function App(){
    return (
        <div>
            {/* 编写路由导航 */}
            <ul>
                <li>
                    <Link to="/">首页</Link>
                </li>
                <li>
                    <Link to="/classes">课程</Link>
                </li>
                <li>
                    <Link to="/mine">我的</Link>
                </li>
                <li>
                    <Link to="/mineaaaa">没有的组件</Link>
                </li>
            </ul>
            {/* 路由配置 */}
            <Switch>
                <Route exact path="/" component={Home}></Route>
                <Route path="/classes" component={Classes}></Route>
                <Route path="/mine" component={Mine}></Route>
                {/* 配置404组件 */}
                <Route  component={Notfound}></Route>
            </Switch>
        </div>
    )
}
//首页组件
function Home(){
    return(
        <div>首页</div>
    )
}
//课程组件
function Classes(){
    return(
        <div>课程</div>
    )
}
//我的组件
function Mine(){
    return(
        <div>我的</div>
    )
}
//配置404组件
function Notfound(){
    return (
        <div>404页面</div>
    )
}


export default function RouterSample() {
    return (
        <div>
            <h1>演示react-router4.x版本的使用</h1>
            <BrowserRouter>
                <App></App>
            </BrowserRouter>
        </div>
    )
}
