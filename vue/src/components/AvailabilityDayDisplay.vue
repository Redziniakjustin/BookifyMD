<template>
  <div class="availability-day-container">

<!-- ONCE INSIDE A DAYS AVAILABILITY - DROPDOWN TO CHANGE DAY SELECTED -->
        <h1>TEST</h1>
       <button id="display-availability">Availability {{doctor.dayOfWeek}}</button>
      
      <table>
      <tbody  v-for="availability in availabilities" :key=availability>
          <tr>
              <td>{{availability.dayOfWeek}}</td>  <!-- doctor-->
              <td>{{availability.startTime}}</td>
              <td>{{availability.endTime}}</td>
              <td>{{availability.location}}</td>
          </tr>
      </tbody>
      </table>

  </div>
</template>


<script>
import currentDoctorAvailability from '@/services/AvailabilityService'
export default {
    data(){
        return{
             availabilities:[
                 {dayOfWeek: "Monday",
                startTime: "09:00:00",
                endTime: "17:00:00",
                },
                {dayOfWeek: "Tuesday",
                startTime: "09:00:00",
                endTime: "17:00:00",
                },
                {dayOfWeek: "Wednesday",
                startTime: "09:00:00",
                endTime: "17:00:00",
                },
             ],
            availabilityByDay:{
                dayOfWeek: "",
                startTime: "",
                endTime: "",
             }
        }
    },
    created(){
        if(this.$route.params != null) {
        this.apdayOfWeek = this.$route.params.dayOfWeek;
        this.startTime = this.$route.params.startTime;
        this.endTime = this.$route.params.endTime;
       
        console.log(this.dayOfWeek);
        } else {
            this.$router.push('profile')
        }
    },
    mounted(){
        currentDoctorAvailability(this.$store.profile.id)
        .then(response=> {
            this.availabilities = response.data;
        });
    },
    methods:{ 
    }
}
</script>


<style>
</style>