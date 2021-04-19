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
                {/* 配置课程详情页，演示路由传参取参 */}
                <Route path="/detail/:course" component={Detail}></Route>
                {/* 配置404组件 */}
                <Route  component={Notfound}></Route>
                
            </Switch>
        </div>
    )
}
//详情页组件
function Detail({match,location,history}){
    //没解构的写法是直接获取参数
    // console.log(props)
    console.log(match,location,history)
    console.log(location,'location')
    return (
        <div>
            我是{match.params.course}课程详情页
            <button onClick={()=>history.push({pathname:'/',state:{foo:'bar'}})}>返回首页</button>
        </div>
    )
}
//首页组件
function Home({location}){
    if(location.state &&location.state.foo){
        console.log('路由跳转带回来的参数：'+location.state.foo)
    }
    return(
        <div>首页
           {location.state &&location.state.foo?<p>从详情页带回来的参数{location.state.foo}</p>:null} 
        </div>
    )
}
//课程组件
function Classes(){
    return(
        <div>
            <ul>
                <li>
                    <Link to="/detail/react">react</Link>
                </li>
                <li>
                    <Link to="/detail/vue">vue</Link>
                </li>
            </ul>
        </div>
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
