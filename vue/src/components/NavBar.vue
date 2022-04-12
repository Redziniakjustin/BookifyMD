<template>
  <div class="header-container">

    <div class="left-header-container"><!--Left Column {Site Navigation} Dropdown?-->
        <h4>Dropdown Menu</h4>

    <div class="link-group-1" v-if="user.role=='patient'">
    <ul>
        <li>  <router-link class="profile-link" :to="{ name: 'profile' }">Patient Profile</router-link></li>
        <li> <router-link class="appointment-link" :to="{ name: 'appointment' }">Book Appointment</router-link></li>
        <li> <router-link class="review-link" :to="{ name: 'review' }">Write A Review</router-link></li>
    </ul>
    </div>

    <div class="link-group-2" v-if="user.role=='doctor'">
    <ul>
        <li><router-link class="profile-link" :to="{ name: 'profile' }">Doctor Profile</router-link></li>
        <li><router-link class="schedule-link" :to="{ name: 'schedule' }">Set Schedule</router-link></li>
        <li><router-link class="review-link" :to="{ name: 'review' }">View Reviews</router-link></li>
    </ul>
    </div>

    <div class="link-group-3" v-if="user.role=='provider'">
    <ul>
        <li> <router-link class="profile-link" :to="{ name: 'profile' }">Provider Profile</router-link></li>
        <li> <router-link class="review-link" :to="{ name: 'review' }">View Reviews</router-link></li>
    </ul>
    </div>
    
    </div> 


    <div class="center-header-container">
        <a ><!--@click="retHome"    Middle Col click logo to return home-->
            <img href="#" id="logo" alt="BookifyMD Logo Here"/>
            <img href="#" id="logo-slogan" alt="BookifyMD Slogan Here"/>
        </a>
    </div> 


    <div class="right-header-container"> <!-- Right Column --> 
        <li v-if="user.status==='authenticated'"><router-link class="link-log-in" :to="{ name: 'login' }">Log In</router-link></li>
        <li v-else><router-link class="link-log-out" :to="{ name: 'logout' }">Log Out</router-link></li>
        <li v-if="user.status==='authenticated'"><router-link class="link-register" :to="{ name: 'register' }">Register</router-link></li>
        <li v-else><router-link class="link-profile" :to="{ name: 'profile' }">Profile</router-link></li>
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
.link-group-1 {
    display: inline-block;
}
.link-group-2 {
    display: inline-block;
}
.link-group-3 {
    display: inline-block;
}
/* Potential Colors

 purple - #9999FF
 purple light - #E6E6FF 
 deep blue - #2C00CC 

*/

</style>