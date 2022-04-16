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

    <div class="avail-body">
        <availability-day-display/>
    </div>

  </div>
</template>


<script>
import AvailabilityDayDisplay from './AvailabilityDayDisplay.vue'
export default {
  components: { AvailabilityDayDisplay },
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
    }
  },
}
</script>

<style>
</style>