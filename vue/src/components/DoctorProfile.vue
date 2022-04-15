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
      <button id="AddLocation" v-onclick="addOffice = !addOffice">Add Hospital or Clinic</button>
      <button id="updateAvailability">Update Availability and Location</button>
      <button id="createAvailability">Create Availability</button>
      <button id="deleteAvailability">Delete Availability</button>
    </div>
    <div v-if="addOffice">
      <form action="" @submit="Addlater">

        <label for="officeName"></label>
        <input type="text" id="officeName" v-model="office.officeName">
       
        <label for="officeAddress"></label>
        <input type="text" id="officeAddress" v-model="office.officeAddress">
       
        <label for="officeCity"></label>
        <input type="text" id="officeCity" v-model="office.officeCity">
       
        <label for="officeState"></label>
        <input type="text" id="officeState" v-model="office.officeState">
       
        <label for="officeZipCode"></label>
        <input type="text" id="officeZipCode" v-model="office.officeZipCode">
       
        <label for="officePhone">Phone: </label>
        <input type="text" id="officePhone" v-model="office.officePhone">
       
       <label for="officeEmail">Email: </label>
        <input type="email" id="officeEmail" v-model="office.officeEmail">
       
        <label for="officeOpenHours">Opening Time: </label>
        <input type="time" id="officeOpenHours" v-model="office.officeOpenHours">
       
        <label for="officeCloseHours">Closing Time: </label>
        <input type="time" id="officeCloseHours" v-model="office.officeCloseHour">
       
        
        </form>
       
        <button></button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      doctor: {
        lastName: "kyle",
        firstName: "martin",
        Address: "1001 Spruce St",
        phoneNumber: "555-555-5555"
},
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
addOffice: false,

    }
  },
}
</script>

<style>

</style>