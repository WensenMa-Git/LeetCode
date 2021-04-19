import React, { Component } from 'react'

export default class ConditionLoop extends Component {
    constructor(props){
        super(props)
        this.state={
            showTitle:true,
            goods: [
                { title: 'html+css基础入门', price: 19.8},
                { title: 'js零基础阶级', price: 29.8},
                { title: 'vue基础入门', price: 19.8},
                { title: 'vue电商单页面项目实战', price: 39.8},
                { title: 'react零基础进阶单页面项目实战', price: 59.8},
              ]
        }
        // setTimeout(()=>{
        //     this.setState({
        //         showTitle:false
        //     })
        // },3000)
    }
    render() {
        //条件渲染第二种写法
        // let result=this.state.showTitle?<h2>{this.props.title}</h2>:null
        //条件渲染的第三种写法、
        let result
        if(this.state.showTitle){
            result=(<h2>{this.props.title}</h2>)
        }else{
            result=null
        }
        return (
            <div>
                <h1>条件渲染和数据循环渲染展示</h1> 
                {/* 条件渲染的第一种写法 */}
                {/* {this.state.showTitle?<h2>{this.props.title}</h2>:null} */}
                {/* 条件渲染的第二种写法 */}
                {result}
                {/* 数据循环渲染 */}
                <ul>
                    {
                        this.state.goods.map(good=>{
                            return <li key={good.title}>
                                <span>课程名称：{good.title}</span>---
                                <span>价格：{good.price}</span>
                            </li>
                        })
                    }
                </ul>
            </div>
        )
    }
}
