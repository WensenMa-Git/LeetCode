import React, { Component } from 'react'


//编写第一个高阶组件。传递一个组件进去，返回一个新的组件

const withLearnReact=(Comp)=>{
    const NewComponent=(props)=>{
        return <Comp {...props} name="欢迎大家来到小D课堂学习React"></Comp>
    }
    return NewComponent
}

class HOC extends Component {
    render() {
        return (
            <div>
               <h1>欢迎大家体验高级组件的写法</h1> 
               {this.props.title}
              <p>姓名：{this.props.name}</p> 
            </div>
        )
    }
}
export default  withLearnReact(HOC)