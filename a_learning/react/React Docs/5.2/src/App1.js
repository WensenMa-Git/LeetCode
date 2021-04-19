import React, { Component } from 'react'
import { Button } from 'antd'
//配置按需加载之后不需要引入antd的css
// import 'antd/dist/antd.css'
export default class App1 extends Component {
    render() {
        return (
            <div>
               <h1>演示antd组件库的使用</h1> 
               <Button type="primary">按钮</Button>
            </div>
        )
    }
}
