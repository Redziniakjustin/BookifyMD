<template>
<div class="display-container"> 
    <div class="left-column">
        <div>
            <h1 class="">Available Doctors</h1>
            <input type="text" placeholder="Search By Doctor" v-model="search"/> <!--When schedule appointment link is clicked next to doctor's name in home view. The doctors ID is passed to the schedule appointment view -->
            <input type="submit">
        </div> 
        <table>
        <tbody>
            <tr v-for="doctor in filteredDoctors" :key="doctor">
                <td>{{doctor.name}}</td>
                <td>{{doctor.location}}</td>
                <td>{{doctor.phone-number}}</td>
                <td>{{doctor.rating}}</td>
                <td>{{doctor.reviews}}</td>
                <td v-on:click="clicked" v-if="user.role=='patient'">
                <!--Must Pass through all of the default params params Will need a query that shows where the doctor is on a certain day will need to be accomplished on backend-->
                <router-link  id="schedule" :to="{ name: 'schedule', params: {doctorID: doctor.id, patientID: user.id, officeID: doctor.officeID} }">Schedule</router-link> <!-- capture id-->
                  <!-- <input type="checkbox">  -->
                </td>
            </tr>
        </tbody>
        </table>
    </div>

    <!--must change v-if to take global auth variable -->
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
            <input type="text" placeholder="Search By Provider" />
            <input type="submit">
            
        </div> 
        <table>
        <tbody>
            <tr v-for="provider in providers" :key="provider">
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
    /*//Will Use once API endpoints are available 
    import listDoctor from '@/services/ProfileService'
    import listProvider from '@/services/ProfileService' */
    export default {
        data(){
            return {
            search: '',
            user:{
                role: 'patient',
                id: 9876
            },
            // authenticated: "True",
            authenticated: "False",
            active: "True",
            doctors: [
                {
                id: 12345,
                name:"Omari RI",
                location: "3400 Springarden",
                officeID: 21,
                phoneNumber: "5552222525",
                rating: 3,
                reviews:"Ok"
                }, 
                {
                id: 8910,
                name:"Hugo B",
                location: "3400 Market",
                officeID: 45,
                phoneNumber: "8888888888",
                rating: 5,
                reviews:"Ok"
                },
                {
                id: 60606,
                name:"Mark S",
                location: "225 s19th St ",
                officeID: 98,
                phoneNumber: "7777777777",
                rating: 1,
                reviews:"Ok"
                }
            ],
            providers: {
                name:"Malcy Gee",
                location: "1212 Cedar",
                officeID: 66,
                phoneNumber: "8880003434",
                rating: "4",
                reviews: "Eh"
            },
            } 
        },
        components:{
            LandingCenterColumn,
            NotificationColumn
        }, 
        computed : {
            filteredDoctors() {
            if (!this.search) return this.doctors
            return this.doctors.filter(doctor => {
                return (doctor.name.toLowerCase().includes(this.search.toLowerCase()) || doctor.location.toLowerCase().includes(this.search.toLowerCase()));
                })
            },
            isAuthenticated(){
                return this.$store.state.authenticated
            }
        }, //Will be used to populate the doctors list.
        /*mounted(){
        //Will be used to populate the doctors list.
        listDoctor().then(response => {
            this.doctors = response.data
        }).catch(error => {
            console.log(error)
            this.error = true
        }).finally(() => this.loading = false)
        //Will be used to populate providers list.
        listProvider().then(response => {
            this.providers = response.data
        }).catch(error => {
            console.log(error)
            this.error = true
        }).finally(() => this.loading = false)
    }*/
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