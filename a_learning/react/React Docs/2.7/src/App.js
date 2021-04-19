import React from 'react'
import PropsDemo from './PropsDemo'
import ConditionLoop from './ConditionLoop'
import logo from './logo.png'
import './App.css'
export default class App extends React.Component{
    constructor(props){
        super(props)
        this.state={
            msg1:'你好呀，我是state里面的msg1',
            count:0
        }
    }
    //这里的写法跟上面的constructor里面的this.state是一样的
    // state={
    //     msg1:'你好呀，我是state里面的msg1'
    // }
    //组件渲染完成生命周期
    componentDidMount(){
        // this.setState({
        //     count:this.state.count+1
        // },()=>{
        //     console.log(this.state.count,'这里是后面输出的，因为setState是异步的')
        // })
        // console.log(this.state.count,'这里是先输出的')
        //如果修改的state是依赖上次一更新的state,那么可以这样写
        // this.setState((prevState,prevProps)=>{
        //     return {
        //         count:prevState.count+1
        //     }
        // })
        //上面代码的简略写法  具体的可以去深入学习一下es6的箭头函数
        this.setState((prevState,prevProps)=>(
            {
                count:prevState.count+1
            }
        ),()=>{
            console.log(this.state.count,'这里是后面输出的，因为setState是异步的')
        })
        console.log(this.state.count,'这里是先输出的')
    }
    render(){
        const msg='大家好，我是Tim,接下来由我教大家React'
        return (
            <div>
                <p>欢迎大家来到小D课堂学习React</p>
                {/* 变量渲染 */}
                {msg}
                <h1>{this.state.msg1}</h1>
                <h2>{this.state.count}</h2>
                {/* 组件属性传递 props */}
                <PropsDemo title="Tim老师教react,我们一起来学习"></PropsDemo>
                {/* 条件渲染和数据循环渲染 */}
                <ConditionLoop title="条件渲染"></ConditionLoop>
                <img src={logo} style={{width:'240px',height:'60px'}} className="xdlogo" alt=""/>
            </div>
        )
    }
}

