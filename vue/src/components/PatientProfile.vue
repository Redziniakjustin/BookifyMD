<template>
  <div>
      <tbody>
          <tr>
              <td>{{patient.firstName}}</td><!--first name -->
              <td>{{patient.lastName}}</td><!--last name -->
              <td>{{patient.Address}}</td><!-- Address -->
              <td>{{patient.phoneNumber}}</td><!--Phone # -->
          </tr>
      </tbody>
      
      <button>Update Information</button>
      <patient-profile-info-form/><!--Add  CSS to make hidden and visible during on-click event with button-->
  </div>
</template>

<script>
import PatientProfileInfoForm from './PatientProfileInfoForm'

export default {
  data() {
    return {
      patient: {
        lastName: "kyle",
        firstName: "martin",
        Address: "1001 Spruce St",
        phoneNumber: "555-555-5555"
}
    }
  },
  components: { 
    PatientProfileInfoForm },

}
</script>

<style>

</style>