import React from 'react'
import ReactDOM from 'react-dom'
// import App from './App.js'
// import LifeCycle from './LifeCycle.js'
// import App1 from './App1'
// import Purememo from './Purememo'
// import Composition from './Composition'
// import HOC from './HOC/HOC.js'
// import Context1 from './HOC/Context1'
// import Context2 from './HOC/Context2'

import FirstRedux from './Reduxfloder/FirstRedux'
import store from './Reduxfloder/store'
import {Provider} from 'react-redux'
// ReactDOM.render(<App></App>,document.getElementById('root'))
//演示声明周期
// ReactDOM.render(<LifeCycle></LifeCycle>,document.getElementById('root'))
//演示antd组件库
// ReactDOM.render(<App1></App1>,document.getElementById('root'))
//演示purecomponent和memo
// ReactDOM.render(<Purememo></Purememo>,document.getElementById('root'))
//组件复合的写法
// ReactDOM.render(<Composition></Composition>,document.getElementById('root'))
//演示高阶组件
// ReactDOM.render(<HOC title="我是高阶组件体验人员"></HOC>,document.getElementById('root'))\
//演示上下文的使用
// ReactDOM.render(<Context2 ></Context2>,document.getElementById('root'))
// 演示redux编写的第一个累加器程序
// ReactDOM.render(<FirstRedux ></FirstRedux>,document.getElementById('root'))

// const render=()=>{
//     ReactDOM.render(<FirstRedux ></FirstRedux>,document.getElementById('root'))
// }
// render()

// store.subscribe(render)
ReactDOM.render(
    <Provider store={store}>
        <FirstRedux ></FirstRedux>
    </Provider>
,document.getElementById('root'))