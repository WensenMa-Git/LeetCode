import React, { Component } from 'react'
//演示使用上下文context

//1.先创建一个数据源，供等一下使用
let store={
    name:'Tim',
    form:'小D课堂'
}
//创建上下文
const XdContext=React.createContext()
const {Provider,Consumer} =XdContext

class  Info extends Component{
    render(){
        return (
            <Consumer>
                {
                    store =>{
                        return (
                            <div>
                                <p>姓名：{store.name}</p>
                                <p>来自哪里：{store.form}</p>
                            </div>
                        )
                    }
                }
            </Consumer>
        )
    }
}
 
function ToolBar(){
    return (
        <Info ></Info>
    )
}
export default class Context2 extends Component {
    render() {
        return (
            <div>
                <Provider value={store}>
                  <ToolBar></ToolBar>
                </Provider>
            </div>
        )
    }
}
