<template>
  <div id="app">
<!-- vuetify material icons -->
 <link href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900|Material+Icons' rel="stylesheet">
    
    <div id="nav">  
      <nav-bar></nav-bar>
    </div>
    
    <router-view/>

  </div>
</template>


<script>
import NavBar from './components/NavBar.vue'
import 'vuetify/dist/vuetify.min.css'

export default {
  components: { 
    NavBar },
  name: 'app'
}
</script>


<style>
</style>
