<template>
  <div>
    <form action="" method="" class="patientProfileForm">
      <label for="firstName">First Name:</label>
      <input id="firstName" type="text" v-model="patientProfileInfoForm.firstName" :placeholder="[[patientProfileInfoForm.firstName]]">
      
      <label for="lastName">Last Name:</label>
      <input id="lastName" type="text" v-model="patientProfileInfoForm.lastName" :placeholder="[[patientProfileInfoForm.lastName]]">
      
      <label for="phoneNumber">Phone Number:</label>
      <input id="phoneNumber" type="text" v-model="patientProfileInfoForm.phoneNumber" :placeholder="[[patientProfileInfoForm.phoneNumber]]">
      
      <label for="address">Address:</label>
      <input id="address" type="text" v-model="patientProfileInfoForm.address" :placeholder="[[patientProfileInfoForm.address]]">

      <button class="btn-submit" @click=submitPatientProfileInfoForm> Submit
        <!--<input type="submit">-->
      </button>
      
      <button class="btn-edit" @click=editForm> 
        Edit Information 
      </button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data(){
      return{
          patientProfileInfoForm:{
            firstName: "",
            lastName: "",
            phoneNumber: "",
            address: "",            
          },
          profile:{
            firstName: "bob",
            lastName: "bobbyson",
            phoneNumber: 5555555555,
            address: "1500 Market",            
          },
      }
  }, 
  methods:{
    submitPatientProfileInfoForm(){
      axios.post('/endpoint', this.patientProfileInfoForm)
      .then((response)=>{
      if(response.status === 201){
        this.$router.push('profile')
      }
      }).catch((error)=>{
        console.log(error.response.status);
      })
    },
    // METHOD THAT RESPONDS TO ONCLICK EVENT AND MAKES FORM DATA ENTERABLE
  }

}
</script>

<style >

</style>