<template>
<div class="display-container"> 
    <div class="left-column">
        <div>
            <h1 class="">Available Doctors</h1>
            <input type="text" placeholder="Search By Doctor"/> <!--When schedule appointment link is clicked next to doctor's name in home view. The doctors ID is passed to the schedule appointment view -->
            <input type="submit">
        </div> 
        <table>
        <tbody>
            <tr>
                <td v-on:click="clicked">
                <router-link  id="schedule" :to="{ name: 'schedule' }">Schedule</router-link> <!-- capture id-->
                  <!-- <input type="checkbox">  -->
                </td>
                <td>{{doctor.name}}</td>
                <td>{{doctor.location}}</td>
                <td>{{doctor.phone-number}}</td>
                <td>{{doctor.rating}}</td>
                <td>{{doctor.reviews}}</td>
            </tr>
        </tbody>
        </table>
    </div>

  
    <div v-if="authenticated==='True'" class="middle-column"><!--Change V-if {This will be to show notification for Auth Users only!!}-->
        <notification-column/>
     </div>    
    <!-- OR -->
    <div v-if="authenticated==='False'" class="middle-column"><!--Change V-if {This will be to show Landing Page}-->
            <landing-center-column/>
    </div>


    <div class="right-column">
         <div>
            <h1 class="">Available Healthcare Providers</h1>
            <input type="text" placeholder="Search By Provider"/>
            <input type="submit">
            
        </div> 
        <table>
        <tbody>
            <tr>
                <td v-on:click="clicked">
                   <input type="checkbox"> 
                </td>
                <td>{{provider.name}}</td>
                <td>{{provider.location}}</td>
                <td>{{provider.phone-number}}</td>
                <td>{{provider.rating}}</td>
                <td>{{provider.reviews}}</td>
            </tr>
        </tbody>
        </table>
    </div>

</div>

</template>

<script>
    import LandingCenterColumn from '@/components/LandingCenterColumn.vue'
    import NotificationColumn from '@/components/NotificationColumn.vue'
    export default {
        data(){
            return {
                // authenticated: "True",
                authenticated: "False",
                active: "True",
            doctor: {
                name:"Omari RI",
                location: "3400 Springarden",
                phoneNumber: "5552222525",
                rating: "3",
                reviews:"Ok"
            },
            provider: {
                name:"Malcy Gee",
                location: "1212 Cedar",
                phoneNumber: "8880003434",
                rating: "4",
                reviews: "Eh"
            },
            } 
        },
        components:{
            LandingCenterColumn,
            NotificationColumn
        }

}
</script>

<style>
.display-container {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  margin: 20px 0 10px 0;
  font-size: 0.75rem;
}

.left-column{
  display: flex;
  flex-direction: column;
  justify-content: center;
}


.middle-column{
  display: flex;
  flex-direction: column;
  justify-content: center;
}


.right-column{
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>