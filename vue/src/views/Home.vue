<template>
  <div class="home">
    <center-display/>
  </div>
</template>

<script>
import CenterDisplay from '@/components/CenterDisplay.vue';

export default {
  components: { 
    CenterDisplay},
  
  name: "home",
   beforeCreate: function() {
    console.log(this.$test)
  }
};
</script>

