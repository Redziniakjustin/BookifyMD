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
      
      <button @click="isActive = !isActive">Update Information</button>
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
      isActive: false,
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
.patient-info{
  display: block;
  text-align: left;
}

</style>