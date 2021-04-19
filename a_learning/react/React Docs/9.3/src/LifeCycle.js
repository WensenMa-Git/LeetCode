import React, { Component } from 'react'

class LifeCycleSon extends Component {
    constructor(props){
        super(props)
        console.log('1.构造函数')
    }
    componentWillMount(){
        //组件将要挂在，这个时候我们可以进行api的调用，获取数据，但是不能进行dom操作
        console.log('2.组件将要挂载')
    }
    componentDidMount(){
        //此时组件已经挂载，我们可以进行dom操作，可以对我们的状态进行更新操作了
        console.log('4.组件已经挂载')
    }
    componentWillReceiveProps(){
        //父组件传递的属性有变化，我们可以在这里做相应的响应操作
        console.log("5.父组件传递的属性更新了")
    }
    shouldComponentUpdate(){
        //组件是否需要更新，需要返回一个布尔值，返回true则更新，返回flase不更新，这是一个优化点
        console.log('6.组件是否应该更新，需要返回布尔值')
        return true
    }
    componentWillUpdate(){
        //组件将要更新
        console.log('7.组件将要更新')
    }
    componentDidUpdate(){
        //组件已经更新
        console.log('8.组件已经更新')
    }
    componentWillUnmount(){
        //组件销毁
        console.log("组件已经销毁")
    }
    render() {
        console.log('3.组件渲染')
        return (
            <div>
                组件生命周期
            </div>
        )
    }
}

export default class LifeCycle extends Component {
    constructor(props){
        super(props)

        this.state={
            son:'我是生命周期',
            showSon:true
        }
        setTimeout(()=>{
            this.setState({
                son:'更新',
            })
        },2000)
        setTimeout(()=>{
            this.setState({
                showSon:false
            })
        },4000)
    }
    render() {
        return (
            <div>
               {this.state.showSon?<LifeCycleSon title={this.state.son}></LifeCycleSon>:<div>组件已销毁</div>} 
            </div>
        )
    }
}
