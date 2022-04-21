<template>
  <div class="prof-reg-container">

     <div class="prof-reg-bod"> 
          <patient-profile-info-form v-if="isPatient"/>
          <doctor-profile-info-form v-if=" !isPatient" />
        <div class="btn">  
          <v-btn v-if="isPatient"  @click="registerAsDoctor()">Are you a Doctor or Practioner?</v-btn>
          <v-btn v-else @click="registerAsPatient()">Are You A Patient?</v-btn>
        </div>
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
 .prof-reg-container{
    align-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: calc(100vh - 148px);
    margin-top: 184px;
 }
   .prof-reg-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }
   .btn{
     margin: 10px 0 10px 0;
   }
</style>