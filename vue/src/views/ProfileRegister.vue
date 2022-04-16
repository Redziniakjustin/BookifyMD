<template>
  <div class="profile-register-container">
      
      <div class="profile-register-body">
          <patient-profile-info-form v-if="isPatient"/>
          <doctor-profile-info-form v-if=" !isPatient" />
          <button v-if="isPatient"  @click="registerAsDoctor()">Are you a Doctor or Practioner?</button>
          <button v-else @click="registerAsPatient()">Are You A Patient?</button>
      </div>
  </div>
</template>

<script>
import DoctorProfileInfoForm from '../components/DoctorProfileInfoForm.vue';
import PatientProfileInfoForm from '../components/PatientProfileInfoForm.vue';
export default {
  components: { 
      PatientProfileInfoForm, 
      DoctorProfileInfoForm 
    },
    name: 'profileRegister',
    data(){
        return{
        isPatient: true
        }
    },
    methods:{
        registerAsDoctor(){
      this.isPatient = !this.isPatient;
      this.userType = "doctor"
    }, 
    registerAsPatient(){
      this.isPatient = !this.isPatient;
      this.userType = "patient"
    }
    }
}
</script>

<style>

.profile-register-container{
    margin-top: 150px;
    align-content: center;
   }
   .profile-register-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }
</style>