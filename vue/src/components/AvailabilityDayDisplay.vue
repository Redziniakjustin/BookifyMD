<template>
  <div class="availability-day-container">

<!-- ONCE INSIDE A DAYS AVAILABILITY - DROPDOWN TO CHANGE DAY SELECTED -->
        <h1>TEST</h1>
       <button id="display-availability">Availability {{doctor.dayOfWeek}}</button>
      <table>
        <thead>
            <th>
                <td>Day of The Week</td>
                <td>Start Time</td>
                <td>End Time</td>
                <td>Select to Reserve</td>
            </th>
        </thead>
        <tbody>
            <tr v-for="availability in availabilities" :key="availability.id">
                <td>availability.dayOfWeek</td>
                <td>availability.startTime</td>
                <td>availability.endTime</td>
                <td>
                    <v-btn>Schedule</v-btn>
                </td>
            </tr>
        </tbody>
    </table>
  </div>
</template>


<script>
import availabilityService from '@/services/AvailabilityService'
export default {
    data(){
        return{
             availabilities:[],
            availabilityByDay:{
                dayOfWeek: "",
                startTime: "",
                endTime: "",
             }
        }
    },
    created(){
        // if(this.$route.params != null) {
        // this.dayOfWeek = this.$route.params.dayOfWeek;
        // this.startTime = this.$route.params.startTime;
        // this.endTime = this.$route.params.endTime;
       
        // console.log(this.dayOfWeek);
        // } else {
        //     this.$router.push('profile')
        // }
    },
    mounted(){
        availabilityService.currentDoctorAvailability(this.$route.params.doctorID)
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