<template>
  <div class="header-container" id="header-container" >
      <div class="logo-container">
          <nav-bar-logo/>
      </div>   

      <div class="btn-container" id="btn-container">      
          <div class="btn-container-right"
              id="lhc" 
              v-if="this.$store.state.authenticated"
              >
                  <!--Patient-->
                  <div class="link-grouping link-group-1" v-if="!currentUserType">
                  <ul>
                    <li class="inline" v-if="isHome===false">
                        <v-btn color="accent" elevation="7" outlined raised text tile> 
                            <router-link id="home-link no-hyper" 
                            :to="{ name: 'home' }">Home
                            </router-link>
                        </v-btn>         
                    </li>
                    <li class="inline" v-if="isProfile===false">
                      <v-btn color="accent" elevation="7" outlined raised text tile>
                        <router-link id="profile-link no-hyper" 
                        :to="{ name: 'profile' }">Profile</router-link><!-- Patient -->
                      </v-btn>
                    </li>

                    <li class="inline" v-if="isAppointment===false"> 
                      <v-btn color="accent" elevation="7" outlined raised text tile>
                        <router-link id="appointment-link no-hyper" 
                        :to="{ name: 'appointment' }">Appointments</router-link>
                      </v-btn>
                    </li>

                    <li class="inline" v-if="isReview===false">
                      <v-btn color="accent" elevation="7" outlined raised text tile>
                          <router-link id="review-link no-hyper" 
                          :to="{ name: 'review' }">Review
                          </router-link>
                      </v-btn>
                    </li>
                  </ul>
                  </div>
                  <!--Doctor -->
              <div class="link-grouping link-group-2" v-if="currentUserType">
                  <ul>
                    <li class="inline" v-if="isHome===false">
                      <v-btn color="accent" elevation="7" outlined raised text tile>
                          <router-link class="no-hyper" id="home-link" 
                          :to="{ name: 'home' }">Home</router-link>
                      </v-btn>
                    </li>

                    <li class="inline" v-if="isProfile===false">
                    <v-btn  color="accent"  elevation="7"   outlined  raised  text  tile> 
                      <router-link class="profile-link no-hyper" 
                      :to="{ name: 'profile' }">Doctor Profile</router-link>
                    </v-btn>
                    </li>

                    <li class="inline" v-if="isAppointment===false">
                    <v-btn color="accent" elevation="7" outlined raised text tile>
                        <router-link class="no-hyper" id="appointment-link" 
                        :to="{ name: 'appointment' }">Appointments</router-link>
                    </v-btn>
                    </li>

                    <li class="inline" v-if="isReview===false" >
                      <v-btn color="accent" elevation="7" outlined raised text tile>
                        <router-link class="review-link no-hyper" 
                        :to="{ name: 'review' }">Reviews</router-link>
                      </v-btn>
                    </li>
                  </ul>
              </div>      
          </div> <!--endleft-->

          <div class="btn-container-left" id="rhc">  
              <li class="inline" v-if="this.$store.state.authenticated">
                <v-btn color="accent" elevation="7" outlined raised text tile>
                  <router-link class="link-log-out no-hyper" 
                  :to="{ name: 'logout' }">Log Out</router-link>
                </v-btn>
              </li>         
              <li class="inline" v-else>
                <v-btn color="accent" elevation="7" outlined raised text tile>
                  <router-link class="link-log-in no-hyper" 
                  :to="{ name: 'login' }">Log In
                  </router-link>
                </v-btn>
              </li>                            
              <li class="inline" v-if="!this.$store.state.authenticated">
                <v-btn color="accent" elevation="7" outlined raised text tile>                   
                  <router-link class="link-register no-hyper" 
                  :to="{ name: 'register' }">Register</router-link>                  
                </v-btn>                 
              </li>
            </div> <!--endright-->
      </div>  <!--endbtn-->
  </div>   <!--endhead-->
</template>

<script>
import NavBarLogo from './NavBarLogo.vue'
export default {
  components: { NavBarLogo },
 data() {
    return {
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
  },
  currentUser(){
     return this.$store.state.user
            },
  currentUserType(){
     return this.$store.state.profileType.isDoctor;
        },
  currentUserProfile(){
      return this.$store.state.profile;
        },
    },
}
</script>


<style>
.header-container {      
    position: fixed;
    background: rgb(212, 240, 237);
    top: 0;
    width: 100%;
    text-transform: uppercase;
    
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center space-between;
    margin: 0;
    padding: 0;
    max-height: 184px;
    z-index: 6;
  }
.logo-container{
  display: flex;
  flex-direction: row;
  align-items: start;
  justify-content: center
  }
.btn-container{
  display: flex;
  flex-direction: row;
  align-self: end;
}
.logo{
  margin: 0 0 0 0;
  /* padding: 10% 10% 10% 10%; */
  max-height: 110px;
  width: 100%;
  }
 .inline{
  display:inline-block;
  }
</style>

