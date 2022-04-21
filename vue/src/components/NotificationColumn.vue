<template>
  <div class="middle-column">
        <h1 class="agenda">Notifications</h1>
          <patient-appointments/>
       <div class="notif-gen">   

         <div class="notif-gen-office">
          <h3>Sign in as a Office and use BookifyMD to see when:</h3>
          <img src="../assets/Icon-1.png" alt="Office Icon">

          <v-alert
                  border="right"
                  color="green"
                  dense
                  dismissible
                  icon="$mdiAccount"
                  outlined
                  text
                  type="success"
                >Your appointment has been accepted</v-alert>
           <v-alert
                  border="right"
                  color="yellow"
                  dense
                  dismissible
                  icon="$mdiAccount"
                  outlined
                  text
                  type="success"
                >Your appointment has been delayed</v-alert>

          <v-alert
                  border="right"
                  color="red"
                  dense
                  dismissible
                  icon="$mdiAccount"
                  outlined
                  text
                  type="success"
                >Your appointment has been canceled</v-alert>


         </div
         > 
        <div class="notif-gen-office">  
          <h3>Sign in as a Doctor and use BookifyMD to see when:</h3>
          <img src="../assets/Icon-2.png" alt="Patient Icon">
        </div
        >
        <div class="notif-gen-office">
          <h3>Sign in as a Doctor and use BookifyMD to see when:</h3>
          <img src="../assets/Icon-3.png" alt="Doctor Icon">
        </div
        >
      </div><!--end-generic-->

        <!-- <tbody>
            <tr v-for="appointment in Appointments" :key="appointmentID.id">
                
                <td> {{notification.appointmentDate}} </td>
                <td> {{notification.startTime}} </td>
              
                <td> {{notification.officeName}} </td>
                
                <td> {{notification.doctorLastName}} </td>
                
                <td> {{notification.description}} </td>
              
                <td> {{notification.appointmentStatus}} </td>
                
                 <td> {{notification.description}} </td>
            </tr>
        </tbody>  -->
    </div>
</template>

<script>
import appointmentService from '@/services/AppointmentService'
import PatientAppointments from '@/components/PatientAppointments'

export default {
data() {
    return {
      //notifications:[],
      appointments:[]
        // {
        // alert: "Delay",
        // date: "05/01/22",
        // time: "1600",
        // doctor: "Naval Poindexter",
        // facility: "Presbyterian",
        // Location: "1001 Spruce St",
        // Description: "Spinal Tap"
        // }, 
        // { alert: "On Time",
        // date: "05/01/22",
        // time: "1600",
        // doctor: "Naval Poindexter",
        // facility: "Presbyterian",
        // Location: "1001 Spruce St",
        // Description: "Spinal Tap"},
        // { alert: "On Time",
        // date: "05/01/22",
        // time: "1600",
        // doctor: "Naval Poindexter",
        // facility: "Presbyterian",
        // Location: "1001 Spruce St",
        // Description: "Spinal Tap"},
        // { alert: "Delay",
        // date: "04/20/22",
        // time: "30 Min Delay ",
        // doctor: "Dr Jolly",
        // facility: "Presbyterian",
        // Location: "1001 Spruce St",
        // Description: "Spinal Tap"}
    }
  },
  components:{
    PatientAppointments
  },
  computed:{
    currentUser(){
      return this.$store.state.user;
    },
    currentUserType(){
        return this.$store.state.profileType.isDoctor;
    },
    currentUserProfile(){
        return this.$store.state.profile;
    }
  }, 
  mounted(){
    if(this.currentUserType){
      appointmentService.getAppointmentByDoctorId(this.currentUser.id)
      .then((response)=>{
        if(response.status==200){
          this.appointments = response.data
        }else{
          console.log("Unable to get Notifications")
        }
      })
    }else{
      appointmentService.getAppointmentByPatientId(this.currentUser.id)
      .then((response)=>{
        if(response.status==200){
          this.appointments = response.data
        }else{
          console.log("Unable to get Notifications")
        }
      })
    }
  },
}
</script>


<style>
.middle-column{
  overflow: auto;
}
</style>