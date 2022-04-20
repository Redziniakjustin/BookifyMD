<template>
  <div class="patient-info-container">
  
   <thead>
    <tr>
      <th>Patient Information</th>
    </tr>
    </thead>
      <tbody>
          <tr>
              <td class="patient-info">{{patient.firstName}} </td>
              <td class="patient-info">{{patient.lastName}} </td>
              <td class="patient-info">{{patient.Address}} </td>
              <td class="patient-info">{{patient.phoneNumber}} </td>
          </tr>
      </tbody>
      
      <button v-if="!isActive" @click="isActive = !isActive">Update Information</button>
      <button v-else @click="isActive=!isActive">Close Update Form</button>
      <div class="patient-profile" v-if="isActive"> 
        <patient-profile-info-form/><!--Add  CSS to make hidden and visible during on-click event with button-->
      </div>
  </div>
</template>

<script>
import PatientProfileInfoForm from './PatientProfileInfoForm'

export default {
  data() {
    return {
      patient:{},
      isActive: false,
//       patient: {
//         lastName: "kyle",
//         firstName: "martin",
//         Address: "1001 Spruce St",
//         phoneNumber: "555-555-5555"
// }
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
  components: { 
    PatientProfileInfoForm },
  mounted(){
    this.patient = this.$store.profile;
    console.log(this.patient)
    // getPatientProfileById(this.$store.user.id).then((response)=>{
    //   this.patient = response.data;
    // }).catch(error => {
    //       console.log(error)
    //       this.error = true
    //   })
  }
}
</script>

<style scoped>
.patient-info{
  display: block;
  text-align: left;
}
</style>