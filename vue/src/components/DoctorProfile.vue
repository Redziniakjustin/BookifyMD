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
     
      <button id="updateAvailability">Update Availability and Location</button>
      <button id="createAvailability">Create Availability</button>
      <button id="deleteAvailability">Delete Availability</button>
     
    </div>
  </div>
</template>

<script>
//import getDoctorProfileById from '@/services/ProfileService'
export default {
  data() {
    return {
      doctor:{},
      // doctor: {
      //   lastName: "kyle",
      //   firstName: "martin",
      //   Address: "1001 Spruce St",
      //   phoneNumber: "555-555-5555"
      // },
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
    this.doctor = this.$store.state.profile
    console.log(this.doctor)
    // getDoctorProfileById(this.$store.user.id).then((response)=>{
    //   this.doctor = response.data;
    // }).catch(error => {
    //       console.log(error)
    //       this.error = true
    //   })
  }
}
</script>

<style>

</style>