<template>
    <div>
      <canvas ref="myChart"/>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { Chart, registerables } from 'chart.js';
  Chart.register(...registerables);
  
  const type = 'bar';
  const loaded = ref(false);
  
  const setData = ref({
    labels: [],
    datasets: [{
      label: '# of Votes',
      data: [12, 19, 3, 5, 2, 3],
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
  
  const fetchChartData2 = async () => {
    try {
      const response = await fetch('http://localhost:8888/graph/year/1');
      const responseData = await response.json();
      setData.value.labels = Object.keys(responseData);
      setData.value.datasets[0].data = Object.values(responseData);
      loaded.value = true;
      console.log(setData.value);
      createChart();
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };
  
  const myChart = ref(null);
  
  onMounted(() => {
    fetchChartData2();
  });
  
  function createChart() {
    new Chart(myChart.value, {
      type: type,
      data: setData.value,
      options: options
    });
  }
  </script>
  
  <style>
  /* Add your styles here */
  </style>
  