<template>
  <div id="app">
<!-- vuetify material icons -->
 <link href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900|Material+Icons' rel="stylesheet">
    
    <div id="nav">  
      <nav-bar></nav-bar>
    </div>
    
    <router-view/>

    <div class="page-end">
      <!-- <adaptive-photo-layout/> -->
      <footer-bar/>
    </div>
  </div>
</template>


<script>
import NavBar from './components/NavBar.vue'
import 'vuetify/dist/vuetify.min.css'
import FooterBar from './components/FooterBar.vue'
import profileService from '@/services/ProfileService'
// import AdaptivePhotoLayout from './components/AdaptivePhotoLayout.vue'

export default {
  components: { 
    NavBar,
    FooterBar,
    // AdaptivePhotoLayout 
    },
  name: 'app',
  beforeCreate(){
        //Set Store state authenticated
    if (this.$store.state.user.id != null) {
      let authenticated = true;
      this.$store.commit("SET_AUTHENTICATION", authenticated);
    } else {
      console.log("Failed");
    }
    //get userType
    profileService.getUserTypeIdById(this.currentUser.id).then((response) => {
    console.log(4);
    if (response.status == 200) {
    console.log(response.data)
    this.$store.commit("SET_PROFILE_TYPE", response.data);
    } else {
    console.log("UserTypeFailed");
    }
    });
    //Method to set user Profile
    if (this.currentUserType) {
      profileService
        .getDoctorProfileById(this.currentUser.id)
        .then((response) => {
            console.log(5);
          if (response.status == 200) {
            this.$store.commit("SET_PROFILE", response.data);
          } else {
            console.log("Failed");
          }
        });
    } else {
      profileService
        .getPatientProfileById(this.currentUser.id)
        .then((response) => {
            console.log(6);
            console.log(response.data)
          if (response.status == 200) {
            this.$store.commit("SET_PROFILE", response.data);
          }
        });
    }
  }
}

</script>


<style>
</style>
