import React,{ useMemo ,useCallback,useRef} from 'react'

const UseRefComp= () => {
    const inputref=useRef()
    const getValue=()=>{
        console.log(inputref.current.value)
    }
    return (
        <div>
            <input ref={inputref} type="text"/>
            <button onClick={getValue}>获取input的值</button>
        </div>
    )
}


export default function OtherHooks() {
    const obj1={taller:'180',name:'tim',age:'15'}
    const obj2={taller:'170',name:'jerry',age:'18',sex:'女'}
    //使用useMemo 跟useCallback唯一的不同是返回值不同，usecallback返回的是callback整个函数
    // const memoValue=useMemo(()=>Object.assign(obj1,obj2),[obj1,obj2])
    // 使用useCallback
    const memoCallback=useCallback(()=>Object.assign(obj1,obj2),[obj1,obj2])
    //输出useMemo返回值
    // console.log(memoValue)
    //输出useCallback返回值
    console.log(memoCallback)
    return (
        <div>
            {/* 使用useMemo返回值 */}
            {/* 姓名：{memoValue.name} */}
            {/* 使用useCallback返回值 */}
            {memoCallback().name}
            <UseRefComp></UseRefComp>
        </div>
    )
}
