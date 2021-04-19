import React, { Component } from 'react'
// import store from './store'
import { connect } from 'react-redux'

// //返回数据的方法，供我们connect使用，他会帮我们把数据转换成props
//  const mapStateToProps=(state)=>{
//      return {
//          count:state
//      }
//  }
// //返回dispatch方法的方法，供我们connect使用，他会帮我们把dispatch转换成props
// const mapDispatchToProps=(dispatch)=>{
//     return {
//         add:()=>dispatch({type:'add'}),
//         reduce:()=>dispatch({type:'reduce'}),
//     }
// }

// @connect(
//     // state=>{
//     //     return {
//     //         count:state
//     //     }
//     // }
//     //这一行代码等价上面的几行代码
//     state=>({count:state}),
//     // dispatch=>({
//     //    add:()=>dispatch({type:'add'}) ,
//     //    reduce:()=>dispatch({type:'reduce'}) ,
//     // })
//     // 因为redux默认只支持同步写法，所以上面的返回dispatch的方法可以简写成下面的代码
//     {
//         add:()=>({type:'add'}) ,
//         reduce:()=>({type:'reduce'})
//     }
// )
@connect(
    state=>({count:state}),
    {
        add:()=>({type:'add'}) ,
        reduce:()=>({type:'reduce'}),
        asyncAdd:()=>dispatch=>{
            setTimeout(()=>{
                dispatch({type:'add'})
            },2000) 
        }
    }
)
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
                    <button onClick={()=>this.props.asyncAdd()}>延时加一</button>
                </div>
            </div>
        )
    }
}
export default FirstRedux