<template>
  <div id="app">
    <div id="nav">
      
    <nav-bar>

      <div class="login-register">  
        <router-link class="login-register-child" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link class="login-register-child" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>

    </nav-bar>
    </div>
    
    <router-view />
 

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
  text-align: center;
  color: #2c3e50;
  margin: 60px;
  display: flex;
  flex-direction: column;
  /* background:  #E6E6FF; */
}
/* .login-register router-link {
  display: inline-block;
} */

.login-register-child{
  display: inline-block;
}

</style>
