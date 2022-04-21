<template>
  <div class="schedule-container lift">
    <div class="schedule-head">
       <h1>Schedule</h1>
<!--<h3>Set Schedule</h3> -->
    </div>
    <div class="schedule-body">
        <div><img src="../assets/sched-1.png" alt=""></div>

        <schedule-appointment-form class="sched-app-form"/>

        <div><img src="../assets/ScreenDoctorWoman.png" 
        alt="Doctor with Schedule">
        </div>
    </div>      
  </div>
</template>


<script>
import ScheduleAppointmentForm 
from '../components/ScheduleAppointmentForm.vue'

export default {
  components: { 
    ScheduleAppointmentForm
    },
}
</script>


<style>
  .schedule-container{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    flex-wrap: nowrap;
    margin-top: 180px;
    align-content: center;
   }
   .schedule-body{
    margin: 30px 0 10px 0;
    font-size: 0.75rem;
    display: flex;
    flex-direction: row;
    align-items: center space-between;
   }
   .sched-app-form{
     flex-basis: 60%;
     margin: 0 20px 0 20px;
   }
   .lift{
     box-shadow:
        0 2.8px 2.2px rgba(0, 0, 0, 0.034),
        0 6.7px 5.3px rgba(0, 0, 0, 0.048),
        0 12.5px 10px rgba(0, 0, 0, 0.06),
        0 22.3px 17.9px rgba(0, 0, 0, 0.072),
        0 41.8px 33.4px rgba(0, 0, 0, 0.086),
        0 100px 80px rgba(0, 0, 0, 0.12);
       
        padding: 22px;
        background: white;
        border-radius: 5px;
        width: 100%;
   }
</style>