<template>
  <div class="profile-container">

    <div class="photo-array">
        <div class="p-a"><img class="photo-prof" src="../assets/profile-1.png" alt=""></div>
        <div class="p-a"><img class="photo-prof" src="../assets/profile-2.png" alt=""></div>
        <div class=""><img class="photo-prof" src="../assets/profile-3.png" alt=""></div>
    </div>

    <div class="profile-body elevated-box">
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
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
   }
   .photo-array{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
   }
   .p-a{
     margin-right: 20px;
   }
</style>