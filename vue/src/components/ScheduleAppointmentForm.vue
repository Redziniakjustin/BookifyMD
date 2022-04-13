<template>
  <div class="schedule-app-form">
      <form class="form-schedule" action="">
          <label for="apdate">appointmentDate:</label><br>  <!-- Link to home.view doctor selected on @click this.$store.state -->
          <input type="date" id="apdate" name="apdate"><br> 

          <label for="aptime">time:</label><br>
          <input type="time" id="time" name="time">
          

          <label for="fname">first name:</label><br>
          <input type="text" id="lname" name="lname">

          <label for="lname">last name:</label><br>
          <input type="text" id="lname" name="lname">

          <label for="aploc">location:</label><br>
          <input type="text" id="aploc" name="aploc">

          <label for="desc">desciption:</label><br>
          <input type="text" id="desc" name="desc">

          <label for="status">status:</label><br>
          <input type="text" id="status" name="status">

          <input type="submit" id="submit" name="submit">
      </form>


  </div>
</template>

<script>
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
        ]
      }
    }
}
</script>

<style>

</style>