<template>
  <div class="middle-column">
        <h1 class="agenda">Notifications</h1>
        <tbody>
            <tr v-for="notification in notifications" :key="notification.id">
                <br><br>
                <td> {{notification.alert}} </td>
                <br><br>
                <br><br>
                <td> {{notification.time}} </td>
                <br><br>
                <td> {{notification.doctor}} </td>
                <br><br>
                <td> {{notification.facility}} </td>
                <br><br>
                <td> {{notification.location}} </td>
                <br><br>
                <!-- <td> {{notification.description}} </td> -->
            </tr>
        </tbody>
    </div>
</template>

<script>
export default {
data() {
    return {
      notifications:[
        {
        alert: "Delay",
        date: "05/01/22",
        time: "1600",
        doctor: "Naval Poindexter",
        facility: "Presbyterian",
        Location: "1001 Spruce St",
        Description: "Spinal Tap"
        }, 
        { alert: "On Time",
        date: "05/01/22",
        time: "1600",
        doctor: "Naval Poindexter",
        facility: "Presbyterian",
        Location: "1001 Spruce St",
        Description: "Spinal Tap"},
        { alert: "On Time",
        date: "05/01/22",
        time: "1600",
        doctor: "Naval Poindexter",
        facility: "Presbyterian",
        Location: "1001 Spruce St",
        Description: "Spinal Tap"},
        { alert: "Delay",
        date: "04/20/22",
        time: "30 Min Delay ",
        doctor: "Dr Jolly",
        facility: "Presbyterian",
        Location: "1001 Spruce St",
        Description: "Spinal Tap"}
      ] 
    }
  },
}
</script>

<style scoped>
.middle-column{
  overflow: auto;
}
</style>