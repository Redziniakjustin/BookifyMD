<template>
  <div>
    <form action="" method="">
      <h2>Patient Personal Information</h2>
      <label for="firstName">First Name:</label>
      <input id="firstName" type="text" v-model="patient.firstName">
      
      <label for="lastName">Last Name:</label>
      <input id="lastName" type="text" v-model="patient.lastName" >
      
      <label for="phoneNumber">Phone Number:</label>
      <input id="phoneNumber" type="text" v-model="patient.phoneNumber">
      
      <label for="patientStreetAddress"> Street: </label>
      <input type="text" id="patientStreetAddress" v-model="patient.street">
      
      <label for="patientCity"> City: </label>
      <input type="text" id="patientCity" v-model="patient.city">
      
      <label for="patientState"> State: </label>
      <input type="text" id="patientState" v-model="patient.state">
      
      <label for="patientZipCode"> Zip Code: </label>
      <input type="text" id="patientZipCode" v-model="patient.zipCode">
      
      <label for="patientEmail"> Email: </label>
      <input type="email" id="patientEmail" v-model="patient.email">
      
      <button class="btn-submit"> Submit
        <!--<input type="submit">-->
      </button>
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
            firstName: "",
            lastName: "",
            phoneNumber: "",
            street: "",
            city: "",
            state: "", 
            zipCode: "", 
            email: "",
        },
        // profile:{
        //   firstName: "bob",
        //   lastName: "bobbyson",
        //   phoneNumber: 5555555555,
        //   address: "1500 Market",            
        // },
      }
  }, 
   methods:{
    registerPatientProfile(){
    if(this.patient.firstName != null){
        profileService.addProfile(this.patient)
        .then((response) => {
          if(response.status == 201){
            this.$router.push({
              path: '/',
            });    
          }
        }).catch((error)=>{
          if(error.response.status === 400){
            return 'Bad Request: Validation Errors';
          }
        });
     } 
    }
   }
   }
  //   submitPatientProfileInfoForm(){
  //     axios.post('/endpoint', )
  //     .then((response)=>{
  //     if(response.status === 201){
  //       this.$router.push('profile')
  //     }
  //     }).catch((error)=>{
  //       console.log(error.response.status);
  //     })
  //   },
  //   // METHOD THAT RESPONDS TO ONCLICK EVENT AND MAKES FORM DATA ENTERABLE
 
</script>

<style >

</style>