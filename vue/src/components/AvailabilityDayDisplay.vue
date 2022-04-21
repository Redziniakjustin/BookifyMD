<template>
  <div class="availability-day-container">

<!-- ONCE INSIDE A DAYS AVAILABILITY - DROPDOWN TO CHANGE DAY SELECTED -->
    <button id="display-availability">Availability</button>
      <table>
           <div class="availability-header">
            <thead> 
            <th  >
                <td style="margin-left:20px">Day of The Week</td>
                <td style="margin-left:20px">Appointment Time</td>
                <td style="margin-left:20px">Select to Reserve</td>
            </th>
            </thead>
         </div>
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

.availability-header{
    display: flex;
    flex-direction: row;
    align-content: center;
    justify-content: end;
  
    padding: 10px;
    margin: 10px, 10px, 10px, 10px;
}

</style>