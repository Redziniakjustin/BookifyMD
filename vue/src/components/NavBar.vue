<template>
  <div class="header-container">

    <div class="left-header-container">
        <div class="link-group-1" v-if="user.role=='patient'">
        <ul>
          <li v-if="isHome===false">
            <router-link id="home-link" :to="{ name: 'home' }">Home</router-link>
          </li>
          <li v-if="isProfile===false">  
            <router-link id="profile-link" :to="{ name: 'profile' }">Patient Profile</router-link>
          </li>
          <li v-if="isAppointment===false"> 
            <router-link id="appointment-link" :to="{ name: 'appointment' }">Book Appointment</router-link>
          </li>
          <li v-if="isReview===false"> 
            <router-link id="review-link" :to="{ name: 'review' }">Write A Review</router-link>
          </li>
        </ul>
        </div>

        <div class="link-group-2" v-if="user.role=='doctor'">
        <ul>
          <li v-if="isHome===false">
            <router-link  id="home-link" :to="{ name: 'home' }">Home</router-link>
          </li>
          <li v-if="isProfile===false">
            <router-link class="profile-link" :to="{ name: 'profile' }">Doctor Profile</router-link>
          </li>
          <li v-if="isAppointment===false"> 
            <router-link id="appointment-link" :to="{ name: 'appointment' }">Scheduled Appointments</router-link>
          </li>
          <li v-if="isReview===false">
            <router-link class="review-link" :to="{ name: 'review' }">View Reviews</router-link>
          </li>
        </ul>
        </div>

        <div class="link-group-3" v-if="user.role=='provider'">
        <ul>
          <li v-if="isHome===false">
            <router-link  id="home-link" :to="{ name: 'home' }">Home</router-link>
          </li>
          <li v-if="isProfile===false"> 
            <router-link class="profile-link" :to="{ name: 'profile' }">Provider Profile</router-link>
          </li>
          <li v-if="isReview===false"> 
            <router-link class="review-link" :to="{ name: 'review' }">View Reviews</router-link>
          </li>
        </ul>
        </div>
    
    </div> 


    <div class="center-header-container">
        <a ><!--@click="retHome"    Middle Col click logo to return home-->

            <img class="logo" src="..\assets\logo.png" id="logo" alt="BookifyMD Logo Here"/>
        
        </a>
    </div> 


    <div class="right-header-container">  
        <li v-if="user.status==='authenticated'"><router-link class="link-log-out" :to="{ name: 'logout' }">Log Out</router-link></li>
                                       <li v-else><router-link class="link-log-in" :to="{ name: 'login' }">Log In</router-link></li>
        <li v-if="user.status==='authenticated'"><router-link class="link-profile" :to="{ name: 'profile' }">Profile</router-link></li>
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
}
}
</script>


<style>
.header-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 20px 0 10px 0;
  font-size: 0.75rem;
}
.logo{
  max-width: 50%;
  height: auto;
}
 #home-link {
    display: inline;
}
#profile-link {
    display: inline;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: transparent;
}
.right-header-container{
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: transparent;
}
li {
  display: block;
  text-align: center;
  text-decoration: none;
}
li:hover {
  background-color: lightpink;
}
/* Potential Colors
 purple - #9999FF
 purple light - #E6E6FF 
 deep blue - #2C00CC 
*/
</style>