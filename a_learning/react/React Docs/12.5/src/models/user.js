import axios from 'axios'
import router from "umi/router"
import { notification } from 'antd';

const inituserinfo = JSON.parse(localStorage.getItem("userinfo")) || {
    token: "",
    role: "",
    username: "",
    userimg: ""
}
//api请求 接口调用
function login(data) {
    return axios.post("/api/login", data)
}




export default {
    namespace: "user",//命名空间，可省略，省略了就拿文件名做命名空间
    state: inituserinfo,
    effects: { //异步操作
        *login(action, { put, call }) {
            try {
                const res = yield call(login, action.payload)
                if (res.data.code == 0) {
                    //登录成功，要把用户信息做缓存
                    localStorage.setItem("userinfo", JSON.stringify(res.data.data))
                    yield put({ type: "init", payload: res.data.data })
                    router.push('/') //登录成功。跳转到首页
                }
            } catch (error) {
                // alert("登录失败，账号或密码错误")
                notification.error({
                    message:"登录失败",
                    description:"账号或密码错误"
                })
            }

        },
        //退出登录
        *logout(action,{put ,call}){
            //清除本地存储信息
            localStorage.removeItem("userinfo")
            yield put({type:'out'})
            router.push("/login")
        }
    },
    reducers: {
        init(state, action) {
            return action.payload
        },
        out(state,action){
            return inituserinfo
        }
    }
}