

<script setup lang="ts">

</script>

<template>
    <el-row>
        <el-col
                v-for="(o, index) in 2"
                :key="o"
                :span="8"
                :offset="index > 0 ? 2:0">
            <el-card class="item-card mt-5 p-0">
                <img src="https://dnvefa72aowie.cloudfront.net/origin/article/202304/efea489b8353ed41bd4ea94bab289abbf2469cee312f64ebe687b9d3b4bd7a27.jpg?q=95&s=1440x1440&t=inside" alt="prada" class="image"/>
            </el-card>
            <div class="footer">
                <span>title</span>
                <div class="bottom">
                    <div>가격</div>
                    <div>location</div>
                    <div>
                        <span>관심 70 ∙</span>
                        <span>채팅 10</span>
                    </div>
                    <div>2023-04-16 09:45:45</div>
                    <el-button text class="button">채팅하기</el-button>
                </div>
            </div>
        </el-col>
    </el-row>
</template>

<style scoped lang="scss">
.item-card {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;

  width: 200px;
  height: 200px;
  overflow: hidden;

  .image {
    position: absolute;
    width: 100%;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

  }
}
.footer {
  padding: 14px;
}

</style>
