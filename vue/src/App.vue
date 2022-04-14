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
//import currentUser from '@/services/UserService'
//import currentUserProfile from '@/services/UserService'
export default {
  // data(){
  //   return{
  //     user:{},
  //     userProfile:{}
  //   }
  // },
  // //Get API data from method
  // mounted(){
  //   //Make a global Variable that gets the current user 
  //   currentUser().then(response => {
  //         //Set user object to User model from DB
  //         this.user = response.data
  //     }).catch(error => {
  //       console.log(error)
  //       this.error = true
  //     }).finally(() => this.loading = false);
  //   //Make a global Variable that gets the current user Profile
  //   currentUserProfile().then(response => {
  //       //Set userProfile object to User model from DB
  //         this.userProfile = response.data
  //     }).catch(error => {
  //       console.log(error)
  //       this.error = true
  //     }).finally(() => this.loading = false)
  // },
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
  /* margin: 60px; */
  display: flex;
  flex-direction: column;
  /* background:  #E6E6FF; */ 
  background-image: linear-gradient(90deg, white,  #E6E6FF, white);

}

.login-register-child{
  display: inline-block;
}

</style>
