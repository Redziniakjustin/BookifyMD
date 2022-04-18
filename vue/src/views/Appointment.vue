<template>
  <div class="appointment-container">

  <img src="../assets/appointments-1.png" alt="">  
    <h1>Appointments</h1>
  
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
          //role: "doctor"
          role: "patient"
        }
      }
    }
}

</script>

<style>
.appointment-container{
    margin-top: 150px;
    align-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
   }
    .appointment-body{
     
     margin: 20px 0 0px 20px;
     font-size: 1.1rem;
   }

</style>