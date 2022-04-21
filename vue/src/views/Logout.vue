<template>

<div class="log-out-container">
  <h1>Logout</h1>
</div>

</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>

<style>
  .log-out-container{
    margin-top: 184px;
    align-content: center;
   }
   .log-out-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }
</style>
