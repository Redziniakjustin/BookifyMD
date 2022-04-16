<template>
  <div class="availability-day-container">

<!-- ONCE INSIDE A DAYS AVAILABILITY - DROPDOWN TO CHANGE DAY SELECTED -->

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
import axios from 'axios';

export default {
    data(){
        return{
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
    methods:{ 
        displayAvailabilityByDay(){
            axios.get('/endpoint/{this.day}', this.availabilityByDay)
            .then((response)=> {
                if(response.status == 201){
                    this.$router.push('profile')
                }
            }).catch((error)=>{
                console.log(error.response.status);
            })
        }

    }


}
</script>

<style>

</style>