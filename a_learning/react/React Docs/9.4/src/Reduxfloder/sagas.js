import {call,put,takeEvery} from 'redux-saga/effects'

//编写模拟登陆接口
const api={
    login(){
        //返回一个propmise对象
        return new Promise((resolve,reject)=>{
            //模拟异步登录
            setTimeout(()=>{
                //通过一个生成随机数去判断登陆成功与失败概率各占一半
                if(Math.random()>0.5){
                    //登陆成功
                    resolve({id:1,name:'tim'})
                }else{
                    reject({message:'用户名或密码错误!'})
                }
            },1000)
        })
    }
}

//编写真正工作的saga ES6里面的星星函数 Generator生成器
function* login(action){
    try {
        //call调用异步方法
    const res=yield call(api.login)
    //put派发action，触发reducer
    yield put({type:'login',res})
    } catch (error) {
        yield put({type:'login_failed',message:error.message})
    }
    
}

function* mySaga(){
    //事件监听，监听我们action来了就触发一个函数，其实是触发上面的login星星函数
    yield takeEvery('login_request',login)
}

export default mySaga