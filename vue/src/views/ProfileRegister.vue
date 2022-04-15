<template>
  <div>
      <button v-if="isPatient"  @click="registerAsDoctor()">Are you a Doctor or Practioner?</button>
      <button v-else @click="registerAsPatient()">Are You A Patient?</button>
      <patient-profile-info-form v-if="isPatient"/>
      <doctor-profile-info-form v-if=" !isPatient" />

      
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

</style>