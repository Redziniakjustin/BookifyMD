<template>
  <div class="schedule-app-form">
      <form class="form-schedule" action="">
          <!--include an h2 or h3 element that has the name of the chosen doctor and their office-->
        <h3>Schedule Appointment with: {{scheduleAppForm.doctorID}} </h3> 

          <label for="apdate">appointmentDate:</label><br>  <!-- Link to home.view doctor selected on @click this.$store.state -->
          <input type="date" id="apdate" name="apdate" v-model="scheduleAppForm.appointmentDate"><br> 

          <label for="aptime">time:</label><br>
          <input type="time" id="time" name="time" v-model="scheduleAppForm.appointmentTime">

          <label for="aploc">location:</label><br>
          <input type="text" id="aploc" name="aploc" v-model="scheduleAppForm.officeID">

          <label for="desc">desciption:</label><br>
          <input type="text" id="desc" name="desc" v-model="scheduleAppForm.description">

          <input type="submit" id="submit" name="submit">
      </form>


  </div>
</template>

<script>
import axios from 'axios';

export default {
    data(){
        return{
            schedule:[
        {
          appointmentDate: "04/14/2022",
          time: "8:00am-8:30am",
          patient: "Omari",
          location: "W.Philly Hospital",
          description: "General Check-Up",
          delayed: true
        },     
        ],
        scheduleAppForm:{
          appointmentDate: "",
          appointmentTime: "",
          patientID: "",
          doctorID: "", 
          officeID: "",
          description: "",
          status: "scheduled"
        }
      }
    },
    created(){
      if(this.$route.params){
      this.patientID = this.$route.params.patientID; 
      this.officeID =  this.$route.params.officeID;
      this.doctorID = this.$route.params.doctorID;
      console.log(this.patientID, this.officeID, this.doctorID);
      } else {
            this.$router.push('appointments')
        }
    },
    methods:{
        //Import as a function from service 
        //Omari Will complete
        submitScheduleAppForm(){
          axios.post('/endpoint', this.scheduleAppForm).then((response)=>{
            if (response.status === 201){
              this.$router.push('home')
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