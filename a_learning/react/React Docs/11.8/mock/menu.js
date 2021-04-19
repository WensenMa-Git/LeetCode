//左侧菜单栏数据，根据点击头部一级菜单动态改变
const menuList = [
    //第一个一级菜单的二级菜单数据
    [
        {
            title: '统计报表',
            keyValue: 'sub1',
            iconType: 'user',
            children: [
                {
                    title: '浏览页面人次报表',
                    keyValue: '1',
                    routeurl:'/home/pageview'
                },
                {
                    title: '浏览用户人次报表',
                    keyValue: '2',
                    routeurl:'/home/userview'
                },
            ]
        },
        {
            title: '设置',
            keyValue: 'sub2',
            iconType: 'laptop',
            children: [
                {
                    title: '页面设置',
                    keyValue: '3',
                    routeurl:'/home/setpage'
                },
                {
                    title: '语言设置',
                    keyValue: '4',
                    routeurl:'/home/setlanguage'
                },
            ]
        }
    ],
    //第二个一级菜单的二级菜单数据
    [
        {
            title: '关于在线教育',
            keyValue: 'sub1',
            iconType: 'notification',
            children: [
                {
                    title: '在线教育类别',
                    keyValue: '1',
                    routeurl:'/about/educationtype'
                },
                {
                    title: '在线教育如何选择',
                    keyValue: '2',
                    routeurl:'/about/seleducation'
                },
            ]
        },
        {
            title: '关于小D课堂',
            keyValue: 'sub2',
            iconType: 'user',
            children: [
                {
                    title: '前端讲师',
                    keyValue: '3',
                    routeurl:'/about/frontend'
                },
                {
                    title: '后端讲师',
                    keyValue: '4',
                    routeurl:'/about/backend'
                },
            ]
        }
    ],
    //第三个一级菜单的二级菜单数据
    [
        {
            title: '直播课程',
            keyValue: 'sub1',
            iconType: 'laptop',
            children: [
                {
                    title: 'java零基础进阶',
                    keyValue: '1',
                    routeurl:'/goods/livejava'
                },
                {
                    title: '冲啊！架构师',
                    keyValue: '2',
                    routeurl:'/goods/livearchitect'
                },
            ]
        },
        {
            title: '录播课程',
            keyValue: 'sub2',
            iconType: 'notification',
            children: [
                {
                    title: '前端课程',
                    keyValue: '3',
                    routeurl:'/goods/frontcourse'
                },
                {
                    title: '后端课程',
                    keyValue: '4',
                    routeurl:'/goods/backendcourse'
                },
            ]
        }
    ],

]
export default menuList

