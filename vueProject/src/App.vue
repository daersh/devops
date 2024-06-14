<template>
  <div class="plus">
    <h1>덧셈 기능 만들기</h1>
    <!-- <label> num1: </label><input type="text" v-model="num1">&nbsp;
    <label> num2: </label><input type="text" v-model="num2">&nbsp; -->
    
    <input type="text" v-model="num1"> &nbsp;&nbsp;+ &nbsp; <input type="text" v-model="num2">&nbsp;  <button @click="plus">더하기</button>
    <hr>
    <p>`{{ num1 }} + {{ num2 }} = {{ result }}` </p>
  </div>
</template>


<script setup>
  import { ref } from 'vue'
  
    const num1 = ref(0)
    const num2 = ref(0)
    const result = ref(0)
  
    const plus = async() => {
      //
      // const response = await fetch(`http://localhost:8055/plus?num1=${num1.value}&num2=${num2.value}`);
      // 백엔드를 도커 컨테이너로 8055 했을 때
      // const response = await fetch(`http://localhost:5173/api/plus?num1=${num1.value}&num2=${num2.value}`);
      // 도커 컨테이너 간 네트워크 연결 후 (5173/api -> 8011/api )
      // const response = await fetch(`http://localhost:8011/api/plus?num1=${num1.value}&num2=${num2.value}`);
      const response = await fetch(`http://localhost:30001/plus?num1=${num1.value}&num2=${num2.value}`);
      const data =  await response.json();
      result.value = data.sum;
    }

</script>

<style scoped>
  .plus{
    text-align: center;
  }

</style>
