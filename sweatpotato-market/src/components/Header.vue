<template>
    <el-menu class="container" mode="horizontal" router>
        <div class="menu-bar d-flex justify-content-center align-items-center">
            <el-menu-item class="img-container" index="/login"><img class="logo-img" src="../assets/img/cherrymarket.jpg" alt=""></el-menu-item>
            <el-menu-item index="/signup">회원가입</el-menu-item>
            <el-menu-item index="/secondhand">중고거래</el-menu-item>
            <el-menu-item index="3">동네가게</el-menu-item>
            <el-menu-item index="4">알바</el-menu-item>
            <el-menu-item index="5">부동산 직거래</el-menu-item>
            <el-menu-item index="6">중고차 직거래</el-menu-item>
        </div>
        <div class="search d-flex ">
            <el-input class="chat-input" v-model="input" placeholder="물품이나 동네를 검색해보세요."/>

            <el-button class="chat-button" type="info">채팅하기</el-button>
        </div>
    </el-menu>
</template>
<script setup lang="ts">
import {ref} from "vue";
import cherrymarket from "@/assets/img/cherrymarket.jpg"

const input = ref();
const menu = ref({
});
</script>

<style scoped lang="scss">
.container {
  display: flex;
  justify-content: space-between;
  border: none;
  background-color: #fdfdfd;

  .menu-bar {
      li {

          &:hover {
              color: #212124;
              background-color: #f4f3f3;
          }
      }
      .img-container {
          width: 150px;
          height: 50px;
          overflow: hidden;
          .logo-img {
              border-radius: 5px;
              border: none;
              width: 100%;
              height: 50px;

          }
      }

  }

  .search {
    align-items: center;

    .chat-input  {
      border: none;
      width: 350px;
      height: 35px;

    }

    .chat-button {
      margin-left: 10px;
      height: 35px;
      background-color: #fff;
      color: #212124;

      &:hover {
        background-color: #EFEFEF7A;
      }
    }
  }


}

</style>