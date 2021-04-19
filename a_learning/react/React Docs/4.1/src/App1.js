import React, { Component } from 'react'
import Button from 'antd/lib/button'
import 'antd/dist/antd.css'
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
