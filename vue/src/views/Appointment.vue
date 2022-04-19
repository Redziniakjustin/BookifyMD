<template>
  <div class="appointment-container">
    <div class="appointment-photo-array">
      <img class="ap-p" src="../assets/appointments-1.png" alt="Appointment Photo 1">
      <img class="ap-p" src="../assets/appointments-2.png" alt="Appointment Photo 2">
      <img src="../assets/appointments-3.png" alt="Appointment Photo 3">
    </div>
      
    <h1>Appointments</h1>
  
  <section class="appointment-body elevated-box">  
    
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
.ap-p{
margin-right: 20px;
}
</style>