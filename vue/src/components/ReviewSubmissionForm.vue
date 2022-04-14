<template>
  <div>
      <form method="POST"> <!--Will need to pass through DOctor id, appointment id, clinic name, current user to DB -->
          <h2></h2>
          <textarea name="review" type="text" class="placeholder"
            :placeholder="[[doctor.name]]"/> <!-- 'What Did you Think of Your Visit with?' -->
          <star-rating />
          
          <input type="submit" @click="router.push({ path: 'appointment' })">
        </form>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating';
import axios from 'axios';

export default {
    data(){
        return{
            doctor:{
                name: "Kyle M"
            }, 
            reviewSubmissionForm:{
                appointmentID: "",
                date: "",
                description: "",
                rating: "",
             }
        }
    },
    components:{
        StarRating
    },
    created(){
        if(this.$route.params != null) {
        this.appointmentID = this.$route.params.appointmentID;
        this.date = this.$route.params.date;
        this.description = this.$route.params.description;
        this.rating = this.$route.params.rating;
        console.log(this.name);
        } else {
            this.$router.push('appointments')
        }

    },
    methods:{
         //TODO Import as a function from service 
        submitReviewSubmissionForm(){
            axios.post('/endpoint', this.reviewSubmissionForm)
            .then((response)=> {
                if(response.status == 201){
                    this.$router.push('home')
                }
            }).catch((error)=>{
                console.log(error.response.status);
            })
        }

    }
}
</script>

<style>

</style>
