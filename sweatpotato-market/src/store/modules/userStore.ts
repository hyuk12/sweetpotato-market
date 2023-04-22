import type { Module } from "vuex";
import router from "@/router";

interface UserState {
    userId: string;
    userName: string;
    accessToken: string;
}

interface LoginPayload {
    userId: string;
    userName: string;
    accessToken: string;
}

const userStore: Module<UserState, {}> = {
    state: {
        userId: "",
        userName: "",
        accessToken: "",
    },
    mutations: {
        login(state, payload: LoginPayload) {
            state.userId = payload.userId;
            state.userName = payload.userName;
            state.accessToken = payload.accessToken;
        },
        logout(state) {
            state.userId = "";
            state.userName = "";
            state.accessToken = "";
        },
    },
    getters: {
        isLoggedIn: (state) => {
            return !!state.accessToken;
        },
    },
};

export default userStore;
