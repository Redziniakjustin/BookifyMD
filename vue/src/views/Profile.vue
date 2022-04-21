<template>
  <div class="profile-container">

    <div class="photo-array">
        <div class="p-a"><img class="photo-prof" src="../assets/profile-1.png" alt=""></div>
        <div class="p-a"><img class="photo-prof" src="../assets/profile-2.png" alt=""></div>
        <div class=""><img class="photo-prof" src="../assets/profile-3.png" alt=""></div>
    </div>

    <div class="profile-body elevated-box">
          <div v-if="this.currentUserType">
            <doctor-profile/>
          </div>
          <div v-else>
            <patient-profile/>
          </div>

    </div>

  </div>
</template>


<script>
import DoctorProfile from '@/components/DoctorProfile.vue'
import PatientProfile from '@/components/PatientProfile.vue'
export default {
  data() {
    return {
      showProfileForm: false,
      user: {
        // role: "doctor"
        role: "patient"
      }
    }
  },
  components: { 
    PatientProfile,
    DoctorProfile
   },
  computed:{
      currentUser(){
          return this.$store.state.user
          },
      currentUserType(){
          return this.$store.profileType.isDoctor;
      },
      currentUserProfile(){
          return this.$store.state.profile;
      }
    }

}
</script>


<style>
.profile-container{
    margin-top: 184px;
    align-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: start space-between;
    min-height: calc(100vh - 148px);
   }
.profile-body{
    margin: 80px 0 10px 0;
    font-size: 1.2rem;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
   }
   .photo-array{
     padding-top: 2%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
   }
   .p-a{
     margin-right: 20px;
   }
</style>