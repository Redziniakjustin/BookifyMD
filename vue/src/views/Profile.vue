<template>
  <div>
    <h1>Profile</h1> <!--TEMP-->
    <div v-if="user.role=='patient'">
      <patient-profile/>  
    </div>
    <div v-if="user.role=='doctor'">
      <doctor-profile/>
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

</style>