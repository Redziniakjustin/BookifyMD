<template>
  <div class="availability-day-container">

<!-- ONCE INSIDE A DAYS AVAILABILITY - DROPDOWN TO CHANGE DAY SELECTED -->
    <button id="display-availability">Availability</button>
      <table>
        <thead>
            <th>
                <td>Day of The Week</td>
                <td>Appointment Time</td>
                <td>Select to Reserve</td>
            </th>
        </thead>
        <tbody>
            <tr v-for="availability in availabilities" :key="availability.id">
                <td>{{availability.dayOfWeek}}</td>
                <td>{{availability.startTime}}-{{availability.endTime}}</td>
                <!-- <td></td> -->
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
        console.log(this.$route.params.doctorID)
        availabilityService.currentDoctorAvailability(this.$route.params.doctorID)
        .then(response=> {
            this.availabilities = response.data;
        });
        console.log(this.availabilities)
    },
    methods:{ 
    }
}
</script>


<style>
</style>