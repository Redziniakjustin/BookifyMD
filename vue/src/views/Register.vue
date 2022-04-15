<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <!--Patient Div -->
      <div v-if="isPatient">
        <h2>Patient Personal Information </h2>

        <label for="patientFirstName">First Name: </label>
        <input type="text" id="patientFirstName" v-model="patient.firstName">
        
        <label for="patientlastName"> Last Name: </label>
        <input type="text" id="patientlastName" v-model="patient.lastName">
        
        <label for="patientPhoneNumber">Phone Number: </label>
        <input type="text" id="patientPhoneNumber" v-model="patient.phoneNumber">
        
        <label for="patientStreetAddress"> Street: </label>
        <input type="text" id="patientStreetAddress" v-model="patient.street">
        
        <label for="patientCity"> City: </label>
        <input type="text" id="patientCity" v-model="patient.city">
        
        <label for="patientState"> State: </label>
        <input type="text" id="patientState" v-model="patient.state">
        
        <label for="patientZipCode"> Zip Code: </label>
        <input type="text" id="patientZipCode" v-model="patient.zipCode">
        
        <label for="patientEmail"> Email: </label>
        <input type="email" id="patientEmail" v-model="patient.email">
      </div>
      <!-- Doctor Div-->
      <div v-else>
        <h2>Doctor Personal Information</h2>

        <label for="doctorFirstName">First Name: </label>
        <input type="text" id="doctorFirstName">
        
        <label for="doctorlastName">Last Name: </label>
        <input type="text" id="doctorlastName">
        
        <label for="doctorPhoneNumber">Phone Number: </label>
        <input type="text" id="doctorPhoneNumber">
        
        <label for="doctorEmail">Email: </label>
        <input type="email" id="doctorEmail">
        
        <label for="doctorCost">Hourly Rate ($): </label>
        <input type="number" id="doctorCost">
      </div>

      <button v-if="isPatient"  @click="registerAsDoctor()">Are you a Doctor or Practioner?</button>
      
      <button v-else @click="registerAsPatient()">Are You A Patient?</button>
      
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      isPatient: true,
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      userType: "patient",
      patient:{
        firstName: "",
        lastName: "",
        phoneNumber: "",
        street: "",
        city: "",
        state: "", 
        zipCode: "", 
        email: "",
      },
      doctor: {
        firstName: "",
        lastName: "",
        phoneNumber: "",
        email: "",
        hourlyCost: ""
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    registerAsDoctor(){
      this.isPatient = !this.isPatient;
      this.userType = "doctor"
    }, 
    registerAsPatient(){
      this.isPatient = !this.isPatient;
      this.userType = "patient"
    }
  },
};
</script>

<style></style>
