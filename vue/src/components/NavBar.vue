<template>
  <div class="header-container" id="header-container" >

    <div class="left-header-container container" id="lhc">

        <div class="link-group-1" v-if="user.role=='patient'">
        <ul>
          <li class="inline" v-if="isHome===false">
              <v-btn color="accent" elevation="7" outlined raised text tile> 
                  <router-link id="home-link no-hyper" :to="{ name: 'home' }">Home</router-link>
              </v-btn>         
          </li>

          <li class="inline" v-if="isProfile===false">
            <v-btn color="accent" elevation="7" outlined raised text tile>
              <router-link id="profile-link no-hyper" :to="{ name: 'profile' }">Patient Profile</router-link>
            </v-btn>
          </li>

          <li class="inline" v-if="isAppointment===false"> 
            <v-btn color="accent" elevation="7" outlined raised text tile>
              <router-link id="appointment-link no-hyper" :to="{ name: 'appointment' }">Book Appointment</router-link>
            </v-btn>
          </li>

          <li class="inline" v-if="isReview===false">
            <v-btn color="accent" elevation="7" outlined raised text tile>
                <router-link id="review-link no-hyper" :to="{ name: 'review' }">Write A Review</router-link>
            </v-btn>
          </li>
        </ul>
        </div>

        <div class="link-group-2" v-if="user.role=='doctor'">
        <ul>
          <li class="inline" v-if="isHome===false">
            <v-btn color="accent" elevation="7" outlined raised text tile>
                <router-link  id="home-link no-hyper" style="text-decoration:none" :to="{ name: 'home' }">Home</router-link>
            </v-btn>
          </li>

          <li class="inline" v-if="isProfile===false">
           <v-btn  color="accent"  elevation="7"   outlined  raised  text  tile> 
             <router-link class="profile-link no-hyper" :to="{ name: 'profile' }">Doctor Profile</router-link>
           </v-btn>
          </li>

          <li class="inline" v-if="isAppointment===false"  >  <!-- troubleshoot why class no text dec failed -->
          <v-btn color="accent" elevation="7" outlined raised text tile>
              <router-link id="appointment-link no-hyper" style="text-decoration:none" :to="{ name: 'appointment' }">Scheduled Appointments</router-link>
          </v-btn>
          </li>

          <li class="inline" v-if="isReview===false" >
            <v-btn color="accent" elevation="7" outlined raised text tile>
               <router-link class="review-link no-hyper" :to="{ name: 'review' }">View Reviews</router-link>
            </v-btn>
          </li>

        </ul>
        </div>

        <div class="link-group-3" v-if="user.role=='provider'">
        <ul>
          <li class="inline" v-if="isHome===false">
            <v-btn color="accent" elevation="7" outlined raised text tile>
                <router-link  id="home-link no-hyper" :to="{ name: 'home' }">Home</router-link>
            </v-btn>
          </li>

          <li class="inline" v-if="isProfile===false"> 
            <v-btn color="accent" elevation="7" outlined raised text tile>
                <router-link class="profile-link no-hyper" :to="{ name: 'profile' }">Provider Profile</router-link>
            </v-btn>
          </li>
          
          <li class="inline" v-if="isReview===false"> 
            <v-btn color="accent" elevation="7" outlined raised text tile>
                <router-link class="review-link no-hyper" :to="{ name: 'review' }">View Reviews</router-link>
            </v-btn>
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
        <li class="inline" v-if="user.status==='authenticated'">
          <v-btn color="accent" elevation="7" outlined raised text tile>
            <router-link class="link-log-out no-hyper" :to="{ name: 'logout' }">Log Out</router-link>
          </v-btn>
        </li>
        
        <li v-else>
          <v-btn color="accent" elevation="7" outlined raised text tile>
            <router-link class="link-log-in no-hyper" :to="{ name: 'login' }">Log In</router-link>
          </v-btn>
        </li>
        
        <li class="inline" v-if="user.status==='authenticated'">
          <v-btn color="accent" elevation="7" outlined raised text tile>
             <router-link class="link-profile no-hyper" :to="{ name: 'profile' }">Profile</router-link>
          </v-btn>
        </li>
                                    
        <li v-else>
          <v-btn color="accent" elevation="7" outlined raised text tile>                   
                <router-link class="link-register no-hyper" :to="{ name: 'register' }">Register</router-link>                  
          </v-btn>                 
        </li>

   <!-- DELETABLE??  -->
    <!-- <div class="login-register">   
        <li class="inline">    
          <router-link class="login-register-child no-hyper" :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </li>
    </div> -->

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
    background: rgb(212, 240, 237) ;
    top: 0;
    width: 100%;
    text-transform: uppercase;
    
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center space-between;
    /* font-size: .5rem; */
    margin: 0;
    padding: 0;
    max-height: 140px;
    /* z-index: 1; */
  }
  .container{
    list-style-type: none; 
    margin: 0;
    padding: 0;
    background-color: transparent;
  }
  .logo{
    margin: 30% 0 0 0;
    padding: 10% 10% 10% 10%;
    max-height: auto;
    width: 100%;
  }
  .left-header-container{
  flex-basis: 20%;
  /* margin-left: 1%; */
  }
  .center-header-container{
  flex-basis: 20%;
  /* margin-left: 10vw; */
  }
  .right-header-container{
  flex-basis: 20%;
  /* margin-left: 10vw; */
  }
  ul {              
    margin: 0;
    padding: 0;
    background-color: transparent;
  }
  .inline{
    display:inline-block;
  }
  .inline a {
    padding: 2px;
    /* border-right: 1px solid #bbb; */
  }
  .inline a:last-child {
    border-right: none;
  }
  .no-hyper{
    text-decoration: none;
  }
   
</style>

