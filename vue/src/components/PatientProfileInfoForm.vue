<template>
  <div class="pat-prof-form-container">
    <form @submit.prevent="registerPatientProfile">
      <h2>Patient Personal Information</h2>

      <label for="firstName">First Name:</label>
      <input id="firstName" type="text" v-model="patient.firstName"
      required>
      
      <label for="lastName">Last Name:</label>
      <input id="lastName" type="text" v-model="patient.lastName"
      required>
      
      <label for="phoneNumber">Phone Number:</label>
      <input id="phoneNumber" type="text" v-model="patient.phoneNumber" 
      required> <!-- change to number ?  -->
      
      <label for="patientStreetAddress"> Street: </label>
      <input type="text" id="patientStreetAddress" v-model="patient.street"
      required>
      
      <label for="patientCity"> City: </label>
      <input type="text" id="patientCity" v-model="patient.city"
      required>
      
      <label for="patientState"> State: </label>
      <input type="text" id="patientState" v-model="patient.state">
      
      <label for="patientZipCode"> Zip Code: </label>
      <input type="text" id="patientZipCode" v-model="patient.zipCode">
      
      <label for="patientEmail"> Email: </label>
      <input type="email" id="patientEmail" v-model="patient.email">
      
      <button type="submit"> Submit </button>
    </form>
  </div>
</template>

<script>
//import axios from 'axios';
import profileService from '@/services/ProfileService';
export default {
  data(){
      return{
        userType: "patient",
        patient:{
            userTypeId: "",
            firstName: "",
            lastName: "",
            phoneNumber: "",
            street: "",
            city: "",
            state: "", 
            zipCode: "", 
            email: "",
        }
      }
  }, 
   methods:{
    registerPatientProfile(){
    if(this.patient.firstName != null){
        profileService.addPatient(this.patient)
        .then((response) => {
          if(response.status == 201){
            this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
          }
        }).catch((error)=>{
          if(error.response.status === 400){
            return 'Bad Request: Validation Errors';
          }
        });
     } 
    }
   },
   mounted(){
     profileService
      .getProfileTypeIdByUsername(this.$route.query.username)
      .then(response => {
        this.patient.userTypeId = response.data;
      }).catch(error => {
              console.log(error)
              this.error = true
          })
   }
}
</script>

<style >
input{
  width: 100%;
  display: block;
  margin: 8px 0;
  padding: 12px 20px;
  box-sizing: border-box;
  border:1px solid;
  }
input:hover{
border:2px solid blue;
}

</style>