<template>
        <div class="doc-prof-form-container">
          <form @submit.prevent="registerDoctorProfile">
            <h2>Doctor Personal Information</h2>

            <label for="doctorFirstName">First Name: </label>
            <input type="text" id="doctorFirstName"
            v-model="doctor.firstName"
            required>
            
            <label for="doctorlastName">Last Name: </label>
            <input type="text" id="doctorlastName"
            v-model="doctor.lastName"
            required
            >
            
            <label for="doctorPhoneNumber">Phone Number: </label>
            <input type="text" id="doctorPhoneNumber"
            v-model="doctor.phoneNumber"
            required>
            
            <label for="doctorEmail">Email: </label>
            <input type="email" id="doctorEmail"
            v-model="doctor.email"
            required>
            <div>
              <!-- @click="displayOffice() -->
              <label for="office">Choose Primary Office:</label>
              <!--Change the the options to offices change :reduce-->
              <v-select id="office" single v-model="doctor.officeId" :options="offices" :reduce="name => name.id" label="name"/>
            </div>
          
            <label for="doctorCost">Hourly Rate ($): </label>
            <input type="number" id="doctorCost"
            v-model="doctor.hourlyCost"
            required
            min="0">
            <button type="submit">Submit</button>
          </form>
      </div>
</template>

<script>
import profileService from '@/services/ProfileService';
import vSelect from 'vue-select'
import Vue from 'vue'
import 'vue-select/dist/vue-select.css';

Vue.component('v-select', vSelect)
export default {
    data(){
        return{
          doctor: {
            userTypeId: "",
            firstName: "",
            lastName: "",
            phoneNumber: "",
            email: "",
            costHourly: "",
            officeId: ""
          },
          offices: [],
          //Will remove later 
          options:[
            {id: 1,
            name: "spruce"
            },
            {id: 2,
            name: "locust"
            },
            {id: 3,
            name: "diamond"
            },
            {id: 4,
            name: "girard"
            },

          ]
        }
    },
     computed:{
        currentUser(){
            return this.$store.state.user
            },
        currentUserType(){
            return this.$store.profileType.isDoctor;
        },
        currentUserProfile(){
            return this.$store.state.profile;
        },
    },
      methods:{
        registerDoctorProfile(){
          if(this.doctor.firstName != null){
              profileService.addDoctor(this.doctor)
              .then((response) => {
                if(response.status == 201){
                  this.$router.push({
                      path: '/login',
                      query: { registration: 'success' },
                    });
                }
              }).catch((error)=>{
                if(error.response.status === 400){
                  return 'Bad Request: Validation Errors';
                }
              });
            } 
          }
    },
     mounted(){
     profileService
     .getUserTypeIdByUsername(this.$route.query.username)
     .then(response => {
       this.doctor.userTypeId = response.data;
     }).catch(error => {
            console.log(error)
            this.error = true
        })
      profileService.listOffices()
        .then(response => {
          this.office = response.data;
          console.log(this.office);
        }).catch(error => {
                console.log(error)
                this.error = true
            })

   }
}
</script>

<style>
.doc-prof-form-container{
  padding-top: 5%;
  margin: 0 auto; 
  width:350px;
  box-shadow:
        0 2.8px 2.2px rgba(0, 0, 0, 0.034),
        0 6.7px 5.3px rgba(0, 0, 0, 0.048),
        0 12.5px 10px rgba(0, 0, 0, 0.06),
        0 22.3px 17.9px rgba(0, 0, 0, 0.072),
        0 41.8px 33.4px rgba(0, 0, 0, 0.086),
        0 100px 80px rgba(0, 0, 0, 0.12);
        padding: 22px;
        background: white;
        border-radius: 5px;
}

</style>