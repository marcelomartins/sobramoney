import Vue from 'vue'
import Router from 'vue-router'
import ListaRegistros from './components/ListaRegistros.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/', name: 'lista', component: ListaRegistros
    },
    {
      path: '/edita', name: 'edita', component: () => import(/* webpackChunkName: "about" */ './components/EditaRegistros.vue')
    }
  ]
})
