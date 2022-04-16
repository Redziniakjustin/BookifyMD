<template>
  <div class="appointment-container">
  
    <h1>Appointment Schedule</h1> <!-- DELETABLE -->
  
  <section class="appointment-body">  
    
    <doctor-schedule v-if="user.role==='doctor'"/>

    <patient-appointments v-if="user.role==='patient'"/>

  </section>

  </div>
</template>

<script>
import DoctorSchedule from '../components/DoctorSchedule.vue';
import PatientAppointments from '../components/PatientAppointments.vue';

export default {
  components: { DoctorSchedule, PatientAppointments },
  data() {
      return {
        user: {
          role: "doctor"
          //role: "patient"
        }
      }
    }
}

</script>

<style>
.appointment-container{
    margin-top: 150px;
    align-content: center;
   }
   .appointment-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }

</style>