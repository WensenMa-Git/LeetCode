//封装ajax调用事件
function ajax(url,fnSucceed,fnFailed){
	//1、创建ajax对象
	//创建ajax对象需要兼容，看看是否是ie5、6
	if(window.XMLHttpRequest){
		var oAjax=new XMLHttpRequest()
	}else{
		var oAjax=new ActiveXObject("Microsoft.XMLHTTP")
	}
	//2、连接服务器
	//传入三个参数，第一个为请求类型、第二个给请求地址，第三个是同步(true)或异步(false)
	oAjax.open('GET',url,true)
	//3、发送请求
	oAjax.send()
	//4、接收数据

	oAjax.onreadystatechange=function(){
		if(oAjax.readyState==4){
			if(oAjax.status==200){
				fnSucceed(oAjax.responseText)
			}else{
				if(fnFailed){
					fnFailed()
				}
			}
		}
	}











}