import Redirect from 'umi/redirect'

export default function(props){
    //判断是否登录成功 50%的成功率
    if(Math.random()>0.5){
        return <Redirect to="/login"></Redirect>
    }
    return (
        <div>
            {props.children}
        </div>
    )
}