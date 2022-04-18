<template>
  <div class="profile-container">

    <!-- <h1>Profile</h1> -->

    <div>
      <img src="../assets/profile-1.png" alt="">
       <img src="../assets/profile-2.png" alt="">
        <img src="../assets/profile-3.png" alt="">
    </div>

    <div class="profile-body">
          <div v-if="user.role=='patient'">

            <patient-profile/> 

          </div>
          <div v-if="user.role=='doctor'">

            <doctor-profile/>

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

}
</script>


<style>
.profile-container{
    margin-top: 150px;
    align-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
   }
.profile-body{
     margin: 80px 0 10px 0;
     font-size: 1.2rem;
   }
</style>