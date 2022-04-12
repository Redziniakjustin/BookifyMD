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
  components: { PatientProfileInfoForm },

}
</script>

<style>

</style>