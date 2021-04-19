import React ,{ useState }from 'react'

export default function App() {
    const [count, setCount] =useState(10)
    return (
        <div>
            我是函数式组件，今天学习React Hook
            <div>你点击了{count}次</div>
            <button onClick={()=>setCount(count+1)}>点击+1</button>
            <button onClick={()=>setCount(count-1)}>点击-1</button>
        </div>
    )
}
