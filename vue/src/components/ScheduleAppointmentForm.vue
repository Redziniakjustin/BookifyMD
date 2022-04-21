<template>
  <div class="schedule-app-form">
      <form class="form-schedule" @submit.prevent="submitAppointmentForm">
          <!--include an h2 or h3 element that has the name of
           the chosen doctor and their office-->
        <h3>Schedule Appointment with: {{doctorName}} </h3> 

          <label for="apdate">appointmentDate</label>
             <br> 
              <!-- Link to home.view doctor selected on @click this.$store.state -->
          <input type="date" id="apdate" name="apdate" 
          v-model="scheduleAppForm.appointmentDate">
          <br> 
          <!-- <label for="aptime">time:</label><br>
          <vue-timepicker 
          id="time" 
          name="time" 
          v-model="scheduleAppForm.appointmentTime"
          format="HH:mm:ss" 
          :minute-interval="0" 
          :second-interval="60"
          hide-disabled-seconds
          :hour-range="[[8,17]]"
          /> -->

          <label for="desc">desciption:</label><br>
          <input type="text" id="desc" name="desc" 
          v-model="scheduleAppForm.description">

          <input type="submit" id="submit" name="submit">
      </form>
      <button @click="dummySubmit">dummy Submit</button>
      <!-- <div>
         <availability-day-display/>
      </div> -->


  </div>
</template>

<script>
//import AvailabilityDayDisplay from './AvailabilityDayDisplay.vue';
import appointmentService from '@/services/AppointmentService'
// import VueTimepicker from 'vue2-timepicker'
// import 'vue2-timepicker/dist/VueTimepicker.css'
export default {
  // components: { 
  //   AvailabilityDayDisplay },
    data(){
        return{
        scheduleAppForm:{
          appointmentDate: "",
          appointmentTime: "",
          patientId: "",
          doctorId: "", 
          officeId: "",
          description: "",
          status: "scheduled"
        },
        doctorAvailability:[]
      }
    },
    components:{
      // VueTimepicker 
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
        doctorName(){
          return "Dr. " + 
          this.$route.params.doctorFirstName + 
          " " + 
          this.$route.params.doctorLastName
        }
    },
    mounted(){
      console.log(this.$route.params.doctorFirstName, this.$route.params.doctorLastName)
      if(this.$route.params != null){
      this.scheduleAppForm.patientId = this.$route.params.patientID; 
      this.scheduleAppForm.officeId =  this.$route.params.officeID;
      this.scheduleAppForm.doctorId = this.$route.params.doctorID;
      console.log(this.patientID, this.officeID, this.doctorID);
      } else {
            this.$router.push('appointments')
        }
      //
      
    },
    methods:{
        dummySubmit(){
          console.log(this.scheduleAppForm)
        },
        submitAppointmentForm(){
          appointmentService.addAppointment(this.scheduleAppForm)
          .then((response)=>{
            if(response.status == 201){
                    console.log("successful submit")
                    this.$router.push('/appointment')
                }
            }).catch((error)=>{
                console.log(error.response.status);
          })
        }
    }
}
</script>

<style scoped>

</style>