<template>
  <div class="middle-column">
        <h1 class="agenda">Notifications</h1>
        <tbody>
            <tr v-for="notification in notifications" :key="notification.id">
                <td> {{notification.alert}} </td>
                <td> {{notification.date}} </td>
                <td> {{notification.time}} </td>
                <td> {{notification.doctor}} </td>
                <td> {{notification.facility}} </td>
                <td> {{notification.location}} </td>
                <td> {{notification.description}} </td>
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
        {},
        {},
        {}
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