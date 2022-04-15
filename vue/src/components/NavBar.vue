<template>
  <div class="header-container" id="header-container" >

    <div class="left-header-container container" id="lhc">
        <div class="link-group-1" v-if="user.role=='patient'">
        <ul>
          <li class="inline" v-if="isHome===false">
            <router-link id="home-link" :to="{ name: 'home' }">Home</router-link>
          </li>
          <li class="inline" v-if="isProfile===false">  
            <router-link id="profile-link" :to="{ name: 'profile' }">Patient Profile</router-link>
          </li>
          <li class="inline" v-if="isAppointment===false"> 
            <router-link id="appointment-link" :to="{ name: 'appointment' }">Book Appointment</router-link>
          </li>
          <li class="inline" v-if="isReview===false"> 
            <router-link id="review-link" :to="{ name: 'review' }">Write A Review</router-link>
          </li>
        </ul>
        </div>

        <div class="link-group-2" v-if="user.role=='doctor'">
        <ul>
          <li class="inline" v-if="isHome===false"   >
            <router-link  id="home-link" :to="{ name: 'home' }">Home</router-link>
          </li>
          <li class="inline" v-if="isProfile===false"   >
            <router-link class="profile-link" :to="{ name: 'profile' }">Doctor Profile</router-link>
          </li>
          <li class="inline" v-if="isAppointment===false"  > 
            <router-link id="appointment-link" :to="{ name: 'appointment' }">Scheduled Appointments</router-link>
          </li>
          <li class="inline" v-if="isReview===false" >
            <router-link class="review-link" :to="{ name: 'review' }">View Reviews</router-link>
          </li>
        </ul>
        </div>

        <div class="link-group-3" v-if="user.role=='provider'">
        <ul>
          <li class="inline" v-if="isHome===false">
            <router-link  id="home-link" :to="{ name: 'home' }">Home</router-link>
          </li>
          <li class="inline" v-if="isProfile===false"> 
            <router-link class="profile-link" :to="{ name: 'profile' }">Provider Profile</router-link>
          </li>
          <li class="inline" v-if="isReview===false"> 
            <router-link class="review-link" :to="{ name: 'review' }">View Reviews</router-link>
          </li>
        </ul>
        </div>
    
    </div> 


    <div class="center-header-container container" id="chc">
                              <!-- click logo to return home-->
        <a class="logo" href="">
            <img @click=returnHome class="logo" src="..\assets\logo-transparent.png" id="logo" alt="BookifyMD Logo Here" />          
        </a>    
    </div> 


    <div class="right-header-container container" id="rhc">  
        <li class="inline" v-if="user.status==='authenticated'"><router-link class="link-log-out" :to="{ name: 'logout' }">Log Out</router-link></li>
                                       <li v-else><router-link class="link-log-in" :to="{ name: 'login' }">Log In</router-link></li>
        <li class="inline" v-if="user.status==='authenticated'"><router-link class="link-profile" :to="{ name: 'profile' }">Profile</router-link></li>
                                     <li v-else><router-link class="link-register" :to="{ name: 'register' }">Register</router-link></li>
       
    </div>

  </div>
</template>

<script>
export default {
 data() {
    return {
      user: {
        role: "doctor",
        // role: "patient"
        // role: "provider",
        status: "authenticated"
      }
    }
  },
  computed: {
  isHome() {
     return this.$route.name === 'home'
  },
  isProfile() {
     return this.$route.name === 'profile'
  },
  isAppointment() {
     return this.$route.name === 'appointment'
  },
  isReview() {
     return this.$route.name === 'review'
  },
  isSchedule() {
     return this.$route.name === 'schedule'
  }
},
methods:{
  returnHome(){
    return this.$router.push('/')
  }
}
}
</script>


<style>
/* Potential Colors
 purple - #9999FF
 purple light - #E6E6FF 
 deep blue - #2C00CC 
*/

.header-container {           /* the nav bar */
    position: fixed;
    background: rgba(64, 224, 208, 0.2) ;
    top: 0;
    width: 100%;
    text-transform: uppercase;
    
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center stretch space-between;
    font-size: 0.75rem;
    margin: 0;
    padding: 0;
    max-height: 140px;
  
  }
  .container{
    list-style-type: none; 
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: transparent;
  }
  .logo{
    max-height: 130px;
    width: 100%;
  }
  
  .left-header-container{
  flex-basis: 25%;
  }
  
  .center-header-container{
  flex-basis: 25%;
  }
  
  .right-header-container{
  flex-basis: 20%;
  }
  ul {              
    list-style-type: none;
    /* removes bullets from left container but not right */
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: transparent;
  }
  
  li:hover {
    background-color: rgba(29, 105, 98, 0.2);
  }
  .inline{
    display:inline;
  }


@media screen and (max-width: 1024px) {
      #head-container{
          grid-template-areas: "lhc chc rhc";
          grid-template-columns: 33% 33% 33%;
          align-items: center;
          row-gap: 20px;
          column-gap: 35px;
      }
}
</style>

