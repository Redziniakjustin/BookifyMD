<template>
  <div class="pat-prof-form-container">
    <div class = "column1">
    <form @submit.prevent="registerPatientProfile">
      <h2><u>Patient Personal Information:</u> </h2>

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
      
         <td class = "button">
      <v-btn type="submit" color="accent" elevation="7" outlined raised text tile>Submit</v-btn>
      </td>
    </form>
    </div>
    
<div class = "column2">
      </div>
  </div>
  
</template>

<script>
import profileService from '@/services/ProfileService';
export default {
  data(){
      return{
        //userType: "patient",
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
  computed:{
        currentUser(){
            return this.$store.state.user
            },
        currentUserType(){
            return this.$store.profileType.isDoctor;
        },
        currentUserProfile(){
            return this.$store.state.profile;
        },
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
     console.log("Mounted")
     profileService
      .getProfileTypeIdByUsername(this.$store.state.user.username)
      .then(response => {
        this.patient.userTypeId = response.data;
      }).catch(error => {
              console.log(error)
              this.error = true
          })
   }
}
</script>

<style scoped>


.pat-prof-form-container{
  padding-top: 5%;
  margin: 0 auto; 
  width:350px;
  box-shadow:
        0 2.8px 2.2px rgba(0, 0, 0, 0.034),
        0 6.7px 5.3px rgba(0, 0, 0, 0.048),
        0 12.5px 10px rgba(0, 0, 0, 0.06),
        0 22.3px 17.9px rgba(0, 0, 0, 0.072),
        0 41.8px 33.4px rgba(0, 0, 0, 0.086),
        0 100px 80px rgba(0, 0, 0, 0.12);
        padding: 22px;
        background: white;
        border-radius: 5px;
}
.button{
    padding-top: 3%;
}
h2{
  padding: 3%;
}
</style>