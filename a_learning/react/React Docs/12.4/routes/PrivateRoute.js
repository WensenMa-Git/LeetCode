import Redirect from 'umi/redirect'
import React,{Component} from 'react'
import {connect } from 'dva'

@connect(
    state=>({token:state.user.token})
)
export default class extends Component{
    render(){
        if(this.props.token){
            return <div>{this.props.children}</div>
        } 
        return <Redirect to="/login"></Redirect> 
    }
}

