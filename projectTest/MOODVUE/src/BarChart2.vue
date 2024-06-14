<template>
  <div>
    <canvas ref="myChart2"/>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { Chart, registerables } from 'chart.js';
Chart.register(...registerables);

const type = 'bar';

const data = ref({
  labels: [],
  datasets: [{
    label: '# of Votes',
    data: [],
    borderWidth: 1
  }]
});

const options = {
  scales: {
    y: {
      beginAtZero: true
    }
  }
};

const fetchChartData = async () => {
  try {
    const response = await fetch('http://localhost:8888/graph/year/1');
    const responseData = await response.json();
    data.value.labels = Object.keys(responseData);
    data.value.datasets[0].data = Object.values(responseData);
    createChart();
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

const myChart2 = ref(null);

onMounted(() => {
  fetchChartData();
});

function createChart() {
  new Chart(myChart2.value, {
    type: type,
    data: data.value,
    options: options
  });
}
</script>

<style>
/* Add your styles here */
</style>
