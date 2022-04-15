<template>
        <div>
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
        
        <label for="doctorCost">Hourly Rate ($): </label>
        <input type="number" id="doctorCost"
        v-model="doctor.hourlyCost"
        required>
        
        <button>Submit</button>
      </div>
</template>

<script>
export default {
    data(){
        return{
             doctor: {
            firstName: "",
            lastName: "",
            phoneNumber: "",
            email: "",
            hourlyCost: ""
        }
        }
    }
}
</script>

<style>
div{
    margin-top: 300px;
}
</style>