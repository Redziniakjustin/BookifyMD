<template>
  <div id="app">
    <div id="nav">
      
    <nav-bar>

      <div class="login-register">  
        <router-link class="login-register-child" :to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link class="login-register-child" :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>

    </nav-bar>
    </div>
    
    <router-view/>
 

  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'
export default {
  components: { 
    NavBar },
  name: 'app'
}
</script>




<style>
#app {
  font-family: 'Lora', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
  display: flex;
  flex-direction: column;
  justify-content: center;
  
  background-image: linear-gradient(90deg, white,  #E6E6FF, white);

}

.login-register-child{
  display: inline-block;
}

</style>
