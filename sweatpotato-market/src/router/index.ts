import type {RouteRecordRaw} from "vue-router";
import HomeView from "@/views/HomeView.vue";
import SecondHand from "@/views/SecondHand.vue";
import Login from "@/views/Login.vue";
import Signup from "@/views/Signup.vue";
import {createRouter, createWebHistory} from "vue-router";
import store from "@/store";

const routes: RouteRecordRaw[] = [
  {
    path: "/",
    name: "home",
    component: Login,
    meta: { requiresAuth: true },
  },
  {
    path: "/secondhand",
    name: "secondhand",
    component: SecondHand,
    meta: { requiresAuth: true },
  },
  {
    path: "/login",
    name: "login",
    component: Login,
  },
  {
    path: "/signup",
    name: "signup",
    component: Signup,
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (!store.getters["user/isLoggedIn"]) {
      next({ name: "login" });
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;


