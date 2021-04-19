export default {
    "post /api/login":function(req,res){
        const {username , password} =req.body
        if(username=="xiaod" && password=="123456"){
            return res.json({
                code:0,
                data:{
                    token:"xdclass",
                    role:"admin",
                    username:"xiaod",
                    userimg:'https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1566400577&di=52614f11afb03df632301e7d5f6486f6&src=http://m.360buyimg.com/pop/jfs/t25291/51/240832757/36633/7109614a/5b696d12N1fa998f1.jpg'
                }
            })
        }
        if(username=="tim" && password=="123456"){
            return res.json({
                code:0,
                data:{
                    token:"xdclass",
                    role:"user",
                    username:"tim",
                    userimg:'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566410664355&di=2472237155ce7797ffb74d79a41d17ff&imgtype=0&src=http%3A%2F%2Fi2.hexun.com%2F2018-11-06%2F195121843.jpg'
                }
            })
        }
        return res.status(401).json({
            code:-1,
            msg:"账号或密码错误"
        })
    }
}