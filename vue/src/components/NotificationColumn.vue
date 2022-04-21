<template>
  <div class="middle-column">
        <h1 class="agenda">Notifications</h1>
        <tbody>
            <tr v-for="notification in notifications" :key="notification.id">
                
                <td> {{notification.appointmentDate}} </td>
                <td> {{notification.startTime}} </td>
              
                <td> {{notification.officeName}} </td>
                
                <td> {{notification.doctorLastName}} </td>
                
                <td> {{notification.description}} </td>
              
                <td> {{notification.appointmentStatus}} </td>
                
                <!-- <td> {{notification.description}} </td> -->
            </tr>
        </tbody>
    </div>
</template>

<script>
import appointmentService from '@/services/AppointmentService'
export default {
data() {
    return {
      //notifications:[],
      notifications:[]
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
  computed:{
    currentUser() { 
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
          this.notifications = response.data
        }else{
          console.log("Unable to get Notifications")
        }
      })
    }else{
      appointmentService.getAppointmentByPatientId(this.currentUser.id)
      .then((response)=>{
        if(response.status==200){
          this.notifications = response.data
        
        }else{
          console.log("Unable to get Notifications")
        }
      })
    }
  }
}
</script>

<style>
.middle-column{
  overflow: auto;
}
</style>