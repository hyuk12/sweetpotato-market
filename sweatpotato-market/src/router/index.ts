import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SecondHand from "@/views/SecondHand.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },

    {
      path: '/secondhand',
      name: 'secondhand',
      component: SecondHand
    }

  ]
})

export default router
