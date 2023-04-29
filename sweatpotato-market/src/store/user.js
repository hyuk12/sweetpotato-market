export default {
    state: {
        accessToken: null,
    },
    mutations: {
        login(state, payload) {
            state.accessToken = payload.accessToken;
        },
    },
    getters: {
        isLoggedIn(state) {
            return !!state.accessToken;
        },
    },
};