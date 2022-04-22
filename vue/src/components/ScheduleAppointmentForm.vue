<template>
  <div class="schedule-app-form">
      <form class="form-schedule" @submit.prevent="submitAppointmentForm">
          <!--include an h2 or h3 element that has the name of
           the chosen doctor and their office-->
        <h3>Schedule Appointment with: {{doctorName}} </h3> 

          <label for="apdate">Appointment Date</label>
          <input type='date'
            name="apdate"
            @input='scheduleAppForm.appointmentDate = new Date($event.target.value)'
          >
             <br> 
              <!-- Link to home.view doctor selected on @click this.$store.state -->
          <br> 
          <div class="availability-day-container">
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
                          <v-btn @click="passAvailId(availability.availId)">Schedule</v-btn>
                      </td>
                  </tr>
              </tbody>
          </table>
        </div>
          <label for="desc">description:</label><br>
          <input type="text" id="desc" name="desc" 
          v-model="scheduleAppForm.description">

          <input type="submit" id="submit" name="submit">
      </form>
  </div>
</template>

<script>
import appointmentService from '@/services/AppointmentService'
import availabilityService from '@/services/AvailabilityService'


//import AvailabilityDayDisplay from './AvailabilityDayDisplay.vue';
export default {
  // components: { 
  //   AvailabilityDayDisplay },
    data(){
        return{
        availabilities:[],
        scheduleAppForm:{
          appointmentDate: "",
          availId: "",
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
      console.log(this.$route.params.doctorID)
        availabilityService.currentDoctorAvailability(this.$route.params.doctorID)
        .then(response=> {
            this.availabilities = response.data;
        });
        console.log(this.availabilities)
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
        submitAppointmentForm(){
          appointmentService.addAppointment(this.scheduleAppForm)
          .then((response)=>{
            if(response.status == 201){
                    console.log("successful submit")
                    this.$router.push('/')
                }
            }).catch((error)=>{
                console.log(error.response.status);
          })
        },
        passAvailId: function(availableID) {
          this.scheduleAppForm.availId = availableID;
}
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