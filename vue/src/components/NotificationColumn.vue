<template>
  <div class="middle-column">
        <h1 class="agenda">Notifications</h1>
         <div class="notif-gen">         
          <img src="../assets/Icon-1.png" alt="Office Icon">
          <img src="../assets/Icon-2.png" alt="Patient Icon">
          <img src="../assets/Icon-3.png" alt="Doctor Icon">
         </div>
         <!--end-generic-->
          <patient-appointments/>
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
.notif-gen{
  display: flex;
  flex-direction: row;
  align-items: start space-between;
  justify-content: center;
}
</style>