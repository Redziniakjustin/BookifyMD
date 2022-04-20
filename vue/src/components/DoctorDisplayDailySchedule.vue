<template>
  <div>
        <ul>
            <li class="list-sched" v-for="bookingPeriod in bookingPeriods" :key=bookingPeriod></li>
        </ul>

  </div>
</template>

<script>
import axios from 'axios';
// thought array of objects:bookingperiod with start and end times nested but got stuck
export default {
    data(){
        return{
             bookingPeriod:[{ 
                 period: 1    
                        // {
                        //     appointmentBegin:"09:00:00",
                        //     appointmentEnd:"09:00:00"}
                        //         }
             }],
            dailySchedule:{
             }
        }
    },
     computed:{
        currentUser(){
            return this.$store.state.user
            },
        currentUserType(){
            return this.$store.profileType.isDoctor;
        },
        currentUserProfile(){
            return this.$store.state.profile;
        },
    },
    created(){
        if(this.$route.params != null) {
        this.dailySchedule = this.$route.params.dailySchedule;     
        console.log(this.dailySchedule);
        } else {
            this.$router.push('schedule')
        }
    },
    methods:{ 
        displayDailySchedule(){
            axios.get('/endpoint', this.dailySchedule)
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