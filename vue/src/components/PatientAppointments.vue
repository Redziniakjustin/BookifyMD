<template>
  <div>
    <div>
      <table>
        <tbody v-for="appointment in appointments" :key=appointment>
          <tr>
            <td>{{appointment.appointmentDate}}</td>
            <td>{{appointment.time}}</td>
            <td>{{appointment.location}}</td>
            <td>{{appointment.doctor}}</td>
            <td>{{appointment.description}}</td>
          </tr>
        </tbody>
      </table>

    </div>
      <div class="app-btns">
        <v-btn v-if="!isPastAppointment" @click="isPastAppointment = !isPastAppointment">Show Past appointments</v-btn>
        <v-btn v-else @click="isPastAppointment = !isPastAppointment">Hide Past appointments</v-btn>
      </div>
    <div v-if="isPastAppointment = isPastAppointment">
     
      <table>
        <tbody v-for="appointment in pastAppointments" :key=appointment>
          <tr>
            <td>{{appointment.appointmentDate}}</td>
            <td>{{appointment.time}}</td>
            <td>{{appointment.location}}</td>
            <td>{{appointment.doctor}}</td>
            <td>{{appointment.description}}</td>
            <td>
          <v-btn color="accent" elevation="7" outlined raised text tile>
                <router-link class="no-hyper reviewLink" :to="{name:'review', params:{appointmentID: appointment.appointmentID, date: appointment.appointmentDate, doctorName: appointment.doctor}}">Leave A Review</router-link>
          </v-btn>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import appointmentService from '@/services/AppointmentService'
export default {
    data(){
        return{
            isPastAppointment: false,
            appointments:[
        {
          appointmentDate: "04/14/2022",
          time: "8:00am-8:30am",
          doctor: "Dr.Omari",
          location: "W.Philly Hospital",
          description: "General Check-Up",
          delayed: true
        },
        {
          appointmentDate: "04/16/2022",
          time: "3:30pm-4:15pm",
          doctor: "Dr.Kyle",
          location: "CC General",
          description: "Spinal Tap",
          delayed: true
        },
        {
          appointmentDate: "04/15/2022",
          time: "1:30pm-2:00pm",
          doctor: "Dr.Eric",
          location: "S.Philly Clinic",
          description: "Foot Exam",
          delayed: true
        },
        {
          appointmentDate: "04/13/2022",
          time: "10:00am-10:30am",
          doctor: "Dr.Justin",
          location: "Montgomery Hospital",
          description: "General Check-Up",
          delayed: true
        }
      ],
      pastAppointments:[
        { 
          appointmentID: 1,
          doctorID: 2,
          appointmentDate: "03/10/2022",
          time: "10:00am-10:30am",
          doctor: "Dr.Justin",
          location: "Montgomery Hospital",
          description: "Eye Exam",
          delayed: false},
        {
          appointmentID: 2,
          doctorID: 3,
          appointmentDate: "02/25/2022",
          time: "10:00am-11:00am",
          doctor: "Dr.Kyle",
          location: "Chester County Hospital",
          description: "Foot Exam",
          delayed: false},
        {
          appointmentID: 3,
          doctorID: 4,
          appointmentDate: "02/14/2022",
          time: "8:00am-8:30am",
          doctor: "Dr.Eric",
          location: "Montefiore Hospital",
          description: "General Checkup",
          delayed: false},
        {
          appointmentID: 4,
          doctorID: 5,
          appointmentDate: "01/10/2022",
          time: "10:00am-1 0:30am",
          doctor: "Dr.Atul",
          location: "Montgomery Hospital",
          description: "Eye Exam",
          delayed: false}
      ]
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
  mounted(){
    appointmentService.getAppointmentByPatientId(this.$store.profile.id)
    .then(response =>{
      this.appointments = response.data
    }).catch(error => {
             console.log(error)
             this.error = true
         }).finally(() => this.loading = false)
  },
  methods:{
    reviewDisable(){
    }
  }
}
</script>


<style scoped>
.app-btns{
  margin: 30px 0 30px;
}
</style>