import React, { Component } from 'react'
// import store from './store'
import { connect } from 'react-redux'

//返回数据的方法，供我们connect使用，他会帮我们把数据转换成props
 const mapStateToProps=(state)=>{
     return {
         count:state
     }
 }
//返回dispatch方法的方法，供我们connect使用，他会帮我们把dispatch转换成props
const mapDispatchToProps=(dispatch)=>{
    return {
        add:()=>dispatch({type:'add'}),
        reduce:()=>dispatch({type:'reduce'}),
    }
}


class FirstRedux extends Component {
    render() {
        return (
            <div>
                <h1>学习redux，编写第一个redux累加器</h1>
                {/* redux写法 */}
                {/* 通过我们的store的getState方法可以获取到状态数据 */}
                {/* {store.getState()} */}
                {/* react-redux的获取状态的写法 */}
                {this.props.count}
                <div>
                    <button onClick={()=>this.props.add()}>加一</button>
                    <button onClick={()=>this.props.reduce()}>减一</button>
                </div>
            </div>
        )
    }
}
export default connect(mapStateToProps,mapDispatchToProps)(FirstRedux)