// import React, { Component } from 'react'

// export default class PropsDemo extends Component {
//     render() {
//         return (
//             <div>
//                 {this.props.title}   
//             </div>
//         )
//     }
// }
import React from 'react'

// export default function PropsDemo(props) {
//     return (
//         <div>
//             {props.title}
//         </div>
//     )
// }
//接收参数的结构写法
export default function PropsDemo({title}) {
    return (
        <div>
            {title}
        </div>
    )
}