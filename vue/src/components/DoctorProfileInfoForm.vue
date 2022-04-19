<template>
        <div>
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

</style>