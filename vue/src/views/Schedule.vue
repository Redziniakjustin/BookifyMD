<template>
  <div class="schedule-container">
   
    <div class="schedule-head">
       <h1>Schedule</h1>

       <h3>Set Schedule</h3>
    </div>

    <div class="schedule-body">
        <schedule-appointment-form/>
        <display-calender/>
    </div>      
  </div>
</template>

<script>
import DisplayCalender from '../components/DisplayCalender.vue'
import ScheduleAppointmentForm from '../components/ScheduleAppointmentForm.vue'

export default {
  components: { 
    ScheduleAppointmentForm,
    DisplayCalender 
    },
}
</script>

<style>
  .schedule-container{
    margin-top: 150px;
    align-content: center;
   }
   .schedule-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }
</style>