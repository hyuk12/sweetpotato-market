<script setup lang="ts">
import { ref } from "vue";
import axios from "axios";
import router from "@/router";
import { useStore } from "vuex";

const username = ref("");
const password = ref("");
const store = useStore();

const Login = async () => {
    const data = {
        username: username.value,
        password: password.value,
    };

    const options = {
        headers: {
            "Content-Type": "application/json",
        },
    };

    try {
        const response = await axios.post("/api/member/login", JSON.stringify(data), options);
        if (response.status === 200) {
            store.commit("userStore/login", {
                userId: response.data.userId,
                userName: response.data.userName,
                accessToken: response.data.accessToken,
            });
            await router.push({name: "home"});
        }
    } catch (error) {
        console.log(error);
    }
};
</script>

<template>
    <div class="main-container">
        <div class="title">
            <h1>로그인</h1>
        </div>
        <div class="username-input">
            <el-input
                    v-model="username"
                    type="text"
                    placeholder="Please input username"
            />
        </div>

        <div class="password-input">
            <el-input
                    v-model="password"
                    type="password"
                    placeholder="Please input password"
                    show-password
            />
        </div>

        <div>
            <el-button class="submit-button" type="primary" @click="Login()">로그인</el-button>
        </div>
    </div>
</template>



<style scoped lang="scss">
.main-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  margin : 300px 0 0;

  .username-input {
    margin: 10px 0;
    width: 250px;

    overflow: hidden;

  }

  .password-input {
    margin: 10px 0;
    width: 250px;

    overflow: hidden;

  }

  .submit-button {
    margin: 10px 0;
    width: 250px;
  }

}

</style>
