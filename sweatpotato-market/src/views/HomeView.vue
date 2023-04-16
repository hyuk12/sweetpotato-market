

<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import router from "@/router";

const username = ref('');
const password = ref('');
const name = ref('');
const email = ref('');
const phone = ref('');
const address = ref('');

const regist = () => {
    axios.post('/api/member', {
        username: username.value,
        password: password.value,
        name: name.value,
        email: email.value,
        phone: phone.value,
        address: address.value
    }).then(() => {
        router.replace({name: 'secondhand'})
    })
}
</script>

<template>
  <div class="input-container d-flex flex-column justify-content-center align-items-center">

      <div class="inputs w-50 h-25">
          <el-input  class="h-75" v-model="username" type="text" placeholder="아이디를 입력해주세요."/>
      </div>
      <div class="inputs w-50 h-25">
          <el-input class="h-75" v-model="password" type="text" placeholder="비밀번호를 입력해주세요."/>
      </div>
      <div class="inputs w-50 h-25">
          <el-input  class="h-75" v-model="name" type="text" placeholder="이름을 입력해주세요."/>
      </div>
      <div class="inputs w-50 h-25">
          <el-input  class="h-75" v-model="email" type="text" placeholder="이메일을 입력해주세요."/>
      </div>
      <div class="inputs w-50 h-25">
          <el-input  class="h-75" v-model="phone" type="text" placeholder="번호를 입력해주세요."/>
      </div>
      <div class="inputs w-50 h-25">
          <el-input  class="h-75" v-model="address" type="text" placeholder="주소를 입력해주세요."/>
      </div>

      <div class="register-button">
          <el-button @click="regist()">회원가입</el-button>
      </div>
  </div>
</template>

<style scoped lang="scss">

.input-container {
  margin: 200px auto 0;

  width: 600px;
  height: 400px;

    .inputs {
        display: flex;
        align-items: center;
        height: 40px;

        input {
            height: 100%;
        }
    }

  .register-button {
    display: flex;
    justify-content: flex-end;
    width: 50%;

    button {
      width: 100px;
      height: 35px;
    }
  }
}
</style>


