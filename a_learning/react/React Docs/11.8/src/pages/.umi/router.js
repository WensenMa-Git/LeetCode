import React from 'react';
import { Router as DefaultRouter, Route, Switch } from 'react-router-dom';
import dynamic from 'umi/dynamic';
import renderRoutes from 'umi/lib/renderRoutes';
import history from '@tmp/history';
import { routerRedux } from 'dva';

const Router = routerRedux.ConnectedRouter;

const routes = [
  {
    path: '/',
    redirect: '/home',
    name: '首页',
    exact: true,
  },
  {
    path: '/login',
    component: require('../login').default,
    exact: true,
  },
  {
    path: '/',
    component: require('../../layout').default,
    routes: [
      {
        path: '/home',
        component: require('../home').default,
        name: '首页',
        exact: true,
      },
      {
        path: '/home/pageview',
        component: require('../home/report/pageview').default,
        name: '页面浏览人次',
        exact: true,
      },
      {
        path: '/home/userview',
        component: require('../home/report/userview').default,
        name: '用户浏览人次',
        exact: true,
      },
      {
        path: '/home/setpage',
        component: require('../home/setting/setpage').default,
        name: '页面设置',
        exact: true,
      },
      {
        path: '/home/setlanguage',
        component: require('../home/setting/setlanguage').default,
        name: '语言设置',
        exact: true,
      },
      {
        path: '/goods',
        component: require('../goods').default,
        name: '商品页',
        exact: true,
      },
      {
        path: '/about',
        component: require('../about').default,
        name: '关于页面',
        Routes: [require('../../../routes/PrivateRoute.js').default],
        exact: true,
      },
      {
        path: '/users',
        component: require('../users/_layout').default,
        routes: [
          {
            path: '/users/',
            component: require('../users/index').default,
            exact: true,
          },
          {
            path: '/users/:name',
            component: require('../users/$name').default,
            exact: true,
          },
          {
            component: () =>
              React.createElement(
                require('/Users/qinyoutian/Desktop/class/reactProject/umi-xiaod/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
                  .default,
                { pagesPath: 'src/pages', hasRoutesInConfig: true },
              ),
          },
        ],
      },
      {
        component: require('../notfound').default,
        name: '404页面',
        exact: true,
      },
      {
        component: () =>
          React.createElement(
            require('/Users/qinyoutian/Desktop/class/reactProject/umi-xiaod/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
              .default,
            { pagesPath: 'src/pages', hasRoutesInConfig: true },
          ),
      },
    ],
  },
  {
    component: () =>
      React.createElement(
        require('/Users/qinyoutian/Desktop/class/reactProject/umi-xiaod/node_modules/umi-build-dev/lib/plugins/404/NotFound.js')
          .default,
        { pagesPath: 'src/pages', hasRoutesInConfig: true },
      ),
  },
];
window.g_routes = routes;
const plugins = require('umi/_runtimePlugin');
plugins.applyForEach('patchRoutes', { initialValue: routes });

export { routes };

export default class RouterWrapper extends React.Component {
  unListen = () => {};

  constructor(props) {
    super(props);

    // route change handler
    function routeChangeHandler(location, action) {
      plugins.applyForEach('onRouteChange', {
        initialValue: {
          routes,
          location,
          action,
        },
      });
    }
    this.unListen = history.listen(routeChangeHandler);
    routeChangeHandler(history.location);
  }

  componentWillUnmount() {
    this.unListen();
  }

  render() {
    const props = this.props || {};
    return <Router history={history}>{renderRoutes(routes, props)}</Router>;
  }
}
