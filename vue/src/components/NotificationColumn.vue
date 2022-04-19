<template>
  <div class="middle-column">
        <h1 class="agenda">Notifications</h1>
        <tbody>
            <tr>
                <td> {{notifications.notification}} </td>
                <td> {{notifications.date}} </td>
                <td> {{notifications.time}} </td>
                <td> {{notifications.doctor}} </td>
                <td> {{notifications.facility}} </td>
                <td> {{notifications.location}} </td>
                <td> {{notifications.description}} </td>
            </tr>
        </tbody>
    </div>
</template>

<script>
export default {
data() {
    return {
      notifications: {
        notification: "Delay",
        date: "05/01/22",
        time: "1600",
        doctor: "Naval Poindexter",
        facility: "Presbyterian",
        Location: "1001 Spruce St",
        Description: "Spinal Tap"
        } 
    }
  },
}
</script>

<style scoped>
.middle-column{
  overflow: auto;
}
</style>