import { connect } from 'dva'
import React, { Component } from 'react'
import styles from './goods.css';
import {Card,Button} from 'antd'
@connect(
  state=>({
    goodsList:state.goods ,//获取指定命名空间里面的state
    loading:state.loading //通过loading命名空间拿到我们加载状态
  }),
  {
    getList:()=>(
      {type:'goods/getList'}  //action的type是需要命名空间为前缀+我们的reducer
    ),
    addGood:title=>(
      {
        type:'goods/addGood',
        payload:{title}
      }
    )
  }
)
export default class extends Component {
  componentDidMount(){
    this.props.getList()
  }
  render() {
    if(this.props.loading.models.goods){
      return <div>loading...</div>
    }
    return (
      <div className={styles.normal}>
        <h1>Page goods</h1>
        {/* 商品列表 */}
        <div>
          {
            this.props.goodsList.map((good,ind)=>{
              return <Card title={`课程${ind+1}`} key={good.title}>
                <div>{good.title}</div>
              </Card>
            })
          }
        </div>
        <div>
          <Button onClick={()=>this.props.addGood("商品3"+new Date().getTime())}>
            添加商品
          </Button>
        </div>
      </div>
    );
  }

}
