<template>
  <div class="profile-container">

    <h1>Profile</h1> <!--TEMP-->
    
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
   }
.profile-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }
</style>