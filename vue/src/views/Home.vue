<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  
  <center-display/>
  <nav-bar/>
  
  </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue';
import CenterDisplay from '@/components/CenterDisplay.vue';


export default {
  components: { 
    NavBar,
    CenterDisplay},
  
  name: "home"
};

</script>
