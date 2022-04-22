<template>
  <div>
      <button id="updateInfo">Update Profile Information</button>
      <tbody>
          <tr>
              <td>{{doctor.firstName}}</td><!--first name -->
              <td>{{doctor.lastName}}</td><!--last name -->
              <td>{{doctor.Address}}</td><!-- Address -->
              <td>{{doctor.phoneNumber}}</td><!--Phone # -->
          </tr>
      </tbody>
      
    <div id="buttonContainer">
     
      <v-btn id="updateAvailability">Update Availability and Location</v-btn>
      <v-btn id="createAvailability">Create Availability</v-btn>
      <v-btn id="deleteAvailability">Delete Availability</v-btn>
     
    </div>
  </div>
</template>

<script>
//import getDoctorProfileById from '@/services/ProfileService'
export default {
  data() {
    return {
      doctor:{},
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
=======
    
>>>>>>> Stashed changes
      office:{
        officeName: "",
        officeAddress: "",
        officeCity: "",
        officeState: "",
        officeZipCode: "",
        officePhoneNumber: "", 
        officeEmail: "", 
        officeStartHour: "", 
        officeCloseHour: ""
      },
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
  mounted(){
    this.doctor = this.currentUserProfile;
  }
}
</script>

<style>

</style>
