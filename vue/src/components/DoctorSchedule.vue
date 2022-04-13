<template>
  <div>
      <table>
        <tbody v-for="appointment in appointments" :key=appointment>
          <tr>
            <td>{{appointment.appointmentDate}}</td>
          </tr>
          <tr>
            <td>{{appointment.time}}</td>
          </tr>
          <tr>
            <td>{{appointment.location}}</td>
          </tr>
          <tr>
            <td>{{appointment.patient}}</td>
          </tr>
          <tr>
            <td>{{appointment.description}}</td>
          </tr>
          <tr>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
</template>

<script>
export default {
    data(){
        return{
            appointments:[
        {
          appointmentDate: "04/14/2022",
          time: "8:00am-8:30am",
          patient: "Omari",
          location: "W.Philly Hospital",
          description: "General Check-Up",
          delayed: true
        },
        {
          appointmentDate: "04/16/2022",
          time: "3:30pm-4:15pm",
          patient: "Kyle",
          location: "CC General",
          description: "Spinal Tap",
          delayed: true
        },
        {
          appointmentDate: "04/15/2022",
          time: "1:30pm-2:00pm",
          patient: "Eric",
          location: "S.Philly Clinic",
          description: "Foot Exam",
          delayed: true
        },
        {
          appointmentDate: "04/13/2022",
          time: "10:00am-10:30am",
          patient: "Justin",
          location: "Montgomery Hospital",
          description: "General Check-Up",
          delayed: true
        },

      ]
    }
  },
  sortByDate() {
      return this.appointments.slice()
             .sort((a, b) => new Date(a.appointmentDate)- new Date(b.appointmentDate));
}
        }

</script>

<style>

</style>