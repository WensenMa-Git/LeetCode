import styles from './$name.css';

export default function(props) {
  return (
    <div className={styles.normal}>
      <h1>我是动态路由页面---详情页</h1>
      <p>欢迎来到{props.match.params.name}的详情页</p>
      <button onClick={()=>props.history.goBack()}>返回</button>
    </div>
  );
}