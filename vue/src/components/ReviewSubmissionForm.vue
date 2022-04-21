<template>
  <div>
    <form @submit.prevent="submitReviewSubmissionForm"> <!--Will need to pass through DOctor id, appointment id, clinic name, current user to DB -->
        <h2 class="margin">Write a review for: {{doctor.name}}</h2>
        <textarea name="review" type="text" class="review-desc"
        placeholder="Tell us about your experience." v-model="reviewSubmissionForm.reviewDesc"/> <!-- 'What Did you Think of Your Visit with?' -->
        <star-rating @rating-selected ="setRating"/>
         <!-- <button type="submit">Submit Review</button>   -->
        <v-btn type="submit" color="accent" elevation="7" outlined raised text tile>Submit Review</v-btn>
        <td class = "button">
       </td>
    </form>
    <!-- <button @click="dummySubmit">dummy</button> -->
  </div>
</template>


<script>
import StarRating from 'vue-star-rating';
import reviewService from '@/services/ReviewService';

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
                reviewRating: 0,
             }
        }
    },
    computed:{
        currentUser(){
            return this.$store.state.user
            },
        currentUserType(){
            return this.$store.state.profileType.isDoctor;
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
        this.reviewSubmissionForm.patientFirstName = this.currentUserProfile.firstName;
        this.reviewSubmissionForm.patientLastName = this.currentUserProfile.lastName;
        this.reviewSubmissionForm.reviewDate = (new Date()).toISOString().split('T')[0];
        this.reviewSubmissionForm.doctorFirstName = this.$route.params.firstName;
        this.reviewSubmissionForm.doctorLastName = this.$route.params.lastName;
        this.reviewSubmissionForm.officeId = this.$route.params.officeID;
        console.log(this.doctor.name);
        } else {
            this.$router.push('/')
        }

    },
    methods:{
        setRating: function(rating){
            
            this.reviewSubmissionForm.reviewRating = parseInt(rating);
        },
        dummySubmit(){
            console.log(this.reviewSubmissionForm)
        },

         //TODO Import as a function from service 
        submitReviewSubmissionForm(){
            reviewService.addReview(this.reviewSubmissionForm).then((response)=> {
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
p {
    padding-top: 2%;
    padding-bottom: 2%;
}
form{ overflow-wrap: break-word;
     display: inline-block;
}
.review-desc{
    padding: 5%;
    border-style: solid;
    height: 200px;
}
.button{
    padding-top: 3%;
    align-content: center;
}
::-webkit-input-placeholder { /* Chrome/Opera/Safari */
  white-space:pre-line;  
  position:relative;
  top:-7px;
  
}
::-moz-placeholder { /* Firefox 19+ */
     white-space:pre-line;  
  position:relative;
  top:-7px;
}
:-ms-input-placeholder { /* IE 10+ */
    white-space:pre-line;  
  position:relative;
  top:-7px;
}
:-moz-placeholder { /* Firefox 18- */
     white-space:pre-line;  
  position:relative;
  top:-7px;
}
.margin{
    margin-top: 10px;
}
</style>
