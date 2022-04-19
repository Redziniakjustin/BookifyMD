<template>
<div class="display-container"> 
    <div class="left-column column">
        <div>
             <img src="../assets/landing-1.png" alt="">
            <h1 class="">Available Doctors</h1>
            <input class="" type="text" placeholder="Search By Doctor" v-model="search"/> <!--When schedule appointment link is clicked next to doctor's name in home view. The doctors ID is passed to the schedule appointment view -->
            <input class="btn-search" type="submit">
        </div> 
        <table>
        <tbody>
            <tr v-for="doctor in filteredDoctors" :key="doctor">
                <td>Dr. {{doctor.firstName}} {{doctor.lastName}}</td>
                <td>{{doctor.location}}</td>
                <td>{{doctor.phoneNumber}}</td>
                <td>{{doctor.rating}}</td>
                <td v-on:click="clicked" v-if="user.role=='patient'">
                <td>
                    <button class="table-btn">
                        <router-link class="no-hyper" id="reviews" :to="{name: 'review', params: {doctorID: doctor.doctorID, firstName: doctor.firstName, lastName: doctor.lastName}}">Reviews</router-link>
                    </button>
                </td>
                <!--Must Pass through all of the default params params Will need a query that shows where the doctor is on a certain day will need to be accomplished on backend-->
                <td>
                    <button class="table-btn">
                        <router-link class="no-hyper" id="schedule" :to="{ name: 'schedule', params: {doctorID: doctor.id, patientID: user.id, officeID: doctor.officeID} }">Schedule</router-link> <!-- capture id-->
                    </button> 
                </td> 
            </tr>
        </tbody>
        </table>
    </div>

    <!--must change v-if to take global auth variable -->
    <div v-if="this.$store.authenticated" class="middle-column column "><!--Change V-if {This will be to show notification for Auth Users only!!}-->
        <h2 v-if="this.$store.profile.firstName === null"> 
            Please Update Profile Here: <router-link :to="{name: 'profile'}">Profile</router-link>
        </h2>
        <notification-column/>
     </div>    
    <!-- OR -->
    <div v-else class="middle-column column "><!--Change V-if {This will be to show Landing Page}-->
            <landing-center-column/>
    </div>


    <div class="right-column column ">
         <div>
            <h1 class="">Available Healthcare Providers</h1>
    
            <input class="btn-search" type="text" placeholder="Search By Provider" />
           
            <input class="btn-search" type="submit">       

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

         <img src="../assets/landing-2.png" alt="">
    </div>

</div>

</template>

<script>
    import LandingCenterColumn from '@/components/LandingCenterColumn.vue'
    import NotificationColumn from '@/components/NotificationColumn.vue'
    //Will Use once API endpoints are available 
    //import listDoctor from '@/services/ProfileService'
    //import listOffices from '@/services/ProfileService'
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
                firstName:"Omari",
                lastName: "RI",
                location: "3400 Springarden",
                officeID: 21,
                phoneNumber: "5552222525",
                rating: 3,
                reviews:"Ok"
                }, 
                {
                id: 8910,
                firstName:"Hugo",
                lastName: "B",
                location: "3400 Market",
                officeID: 45,
                phoneNumber: "8888888888",
                rating: 5,
                reviews:"Ok"
                },
                {
                id: 60606,
                firstName:"Mark",
                lastName: "S",
                location: "225 s19th St ",
                officeID: 98,
                phoneNumber: "7777777777",
                rating: 1,
                reviews:"Ok"
                }
            ],
            offices: []
            /*{
                name:"Malcy Gee",
                location: "1212 Cedar",
                officeID: 66,
                phoneNumber: "8880003434",
                rating: 4,
                reviews: "Eh"
            }, */
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
    //     mounted(){
    //     //Will be used to populate the doctors list.
    //     /*listDoctor().then(response => {
    //         this.doctors = response.data
    //     }).catch(error => {
    //         console.log(error)
    //         this.error = true
    //     }).finally(() => this.loading = false)
    //     //Will be used to populate providers list. */
    //     listOffices().then(response => {
    //         this.offices = response.data
    //     }).catch(error => {
    //         console.log(error)
    //         this.error = true
    //     }).finally(() => this.loading = false)
    // }
}
</script>


<style>
@import '../assets/styles/styles.css';
.display-container {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    margin: 150px 0 10px 0;
    font-size: 0.75rem;
  }
  .column{
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .left-column{
    flex-basis: 30%;
    margin-left: 10px;
    padding: 2%;
  }
  .middle-column{
    flex-basis: 30%;
  }
  .right-column{
   flex-basis: 30%;
   margin-right: 10px;
   padding: 2%;
  }
.no-hyper{
    text-decoration: none;
}
</style>