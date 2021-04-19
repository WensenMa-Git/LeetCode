function* g() {
    yield "a";
    yield "b";
    yield "c";
    return "ending";
  }
  console.log(g()); //返回迭代器Iterator
  const gen = g();
//   console.log(gen.next()) // 返回结果对象
//   // // { value: 'a', done: false }
//   // // value是yield后面表达式的结果
//   console.log(gen.next())
//   console.log(gen.next())
//   console.log(gen.next())
  
  // 使用递归函数执行生成器里面所有步骤
  function next(){
    let { value, done } = gen.next() // 启动
    console.log(value) // 依次打印输出 a b c end
    if(!done) next() // 直到迭代完成
  }
  next()