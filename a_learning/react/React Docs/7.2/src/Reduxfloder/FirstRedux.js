import React, { Component } from 'react'
import store from './store'
export default class FirstRedux extends Component {
    render() {
        return (
            <div>
                <h1>学习redux，编写第一个redux累加器</h1>
                {/* 通过我们的store的getState方法可以获取到状态数据 */}
                {store.getState()}
                <div>
                    <button onClick={()=>store.dispatch({type:'add'})}>加一</button>
                    <button onClick={()=>store.dispatch({type:'reduce'})}>减一</button>
                </div>
            </div>
        )
    }
}
