<template>
  <div>
    <h1>Appointment Schedule</h1> <!-- DELETABLE -->
    <doctor-schedule v-if="user.role==='doctor'"/>
    <patient-appointments v-if="user.role==='patient'"/>
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

</style>