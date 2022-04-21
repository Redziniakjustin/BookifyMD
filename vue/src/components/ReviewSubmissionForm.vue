<template>
  <div>
    <form @submit.prevent="submitReviewSubmissionForm"> <!--Will need to pass through DOctor id, appointment id, clinic name, current user to DB -->
        <h2>Leave a Review For {{doctor.name}}</h2>
        <textarea name="review" type="text" class="placeholder"
        placeholder="Review Description" :value="reviewSubmissionForm.reviewDesc"/> <!-- 'What Did you Think of Your Visit with?' -->
        <star-rating v-model="reviewSubmissionForm.rating"/>
         <!-- <button type="submit">Submit Review</button>   -->
       <v-btn type="submit" color="accent" elevation="7" outlined raised text tile>Submit Review</v-btn>
    </form>
  </div>
</template>


<script>
import StarRating from 'vue-star-rating';
import addReview from '@/services/ReviewService';

export default {
    data(){
        return{
            doctor:{
                name: "Kyle M"
            }, 
            reviewSubmissionForm:{
                patientFirstName: "",
                patientLastName: "", 
                doctorFirstName: "",
                doctorLastName: "",
                officeName: "",
                reviewDate: "", 
                reviewDesc: "",
                rating: "",
             }
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
    components:{
        StarRating
    },
    created(){
        if(this.$route.params != null) {
        this.doctor.name = ("Dr. "+ this.$route.params.firstName + " " +this.$route.params.lastName);
        this.reviewSubmissionForm.patientFirstName = this.$state.profile.firstName;
        this.reviewSubmissionForm.patientLastName = this.$state.profile.lastName;
        this.reviewSubmissionForm.reviewDate = (new Date()).toISOString().split('T')[0];
        this.reviewSubmissionForm.doctorFirstName = this.$route.params.firstName;
        this.reviewSubmissionForm.doctorLastName = this.$route.params.lastName;
        console.log(this.doctor.name);
        } else {
            this.$router.push('home')
        }

    },
    methods:{
         //TODO Import as a function from service 
        submitReviewSubmissionForm(){
            addReview(this.reviewSubmissionForm).then((response)=> {
                if(response.status == 201){
                    this.$router.push('/')
                }
            }).catch((error)=>{
                console.log(error.response.status);
            })
        }

    }
}
</script>

<style scoped>
{
    padding-top: 10%;
  text-align: center;
}
</style>
