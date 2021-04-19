import { createStore } from 'redux'

//编写我们的第一个reducer

const firstReducer =(state=10,action)=>{
    switch(action.type){
        //当我们传入的action的type是add的时候给我们的state+1
        case 'add':
        return state+1;
         //当我们传入的action的type是reduce的时候给我们的state-1
         case 'reduce':
         return state-1; 
         //当我们传入的action的type不是以上的情况，我们就返回旧的state
         default:
         return state;
    }
}

//创建数据仓库，把我们编写好的reducer传入给createStore
const store = createStore(firstReducer)

export default store