<template>
   <div>
     <div>
      <!-- <star-rating 
      v-model="avgRating" 
      v-bind:show-rating="false" 
      v-bind:read-only="true"
      v-bind:increment="0.01"/> -->
      <!-- <span>{{avgRating}}</span> -->
      <table>
        <tbody v-for="review in reviews" :key="review.id">
          <div class="ReviewBox">
          <tr>
            <td>
              <tr>
            <h2><b></b> {{review.patientFirstName}}   {{review.reviewDate}}</h2>
          </tr>
            </td>
          </tr>
          <!-- <tr>
            <td><b>Doctor: </b> {{review.doctor}}</td>
          </tr> -->

          <tr>
            <td class = "reviews"><h3><b>Review: </b></h3>{{review.reviewDesc}}</td>
          </tr>
          <tr>
            <td class = "ratings">  <star-rating 
          v-model="review.reviewRating" 
          v-bind:show-rating="false" 
         v-bind:read-only="true"
         v-bind:increment="0.01"/>
        <!-- <span>{{avgRating}}</span> -->
        </td>
          </tr>
          <tr>
            <td class = "button">
              <!--Will need to make this a v-if for state.isDoctor-->
              <v-btn class="respond-fix" color="accent" elevation="7" outlined raised text tile>
              <!-- <button @click="addReviewParamsAndShowForm(review.id)"> -->
                Respond
                </v-btn>
              <!-- </button> -->
                </td>
          </tr>
          </div>
        </tbody>
      </table>
     </div>
    <div v-if="this.currentUserType">
        <form @submit.prevent="submitResponse">
          <h2>Respond to review</h2>
          <input type="text" v-model="reviewResponse">
          <button type="submit">submit</button>
        </form>
    </div>
  </div>
</template>

<script>
import reviewService from '@/services/ReviewService'
import addReviewResponse from '@/services/ReviewService'
import StarRating from 'vue-star-rating';


export default {

 data(){
        return{
            avgRating: {},
            reviewResponse: "",
            reviewResponseId: "",
            //reviews:[],
            reviews:[
            // {
            //   id: 2,
            //   patientFirstName: "Percy", 
            //   office: "presbyterian",
            //   doctor:"smit rehan",
            //   reviewDate:"2022-10-23",
            //   reviewDesc: "I came to Dr. Rehan with a toothache and lost my kidneys",
            //   rating: 5
            // },
            // {
            //   id: 5,
            //   patientFirstName: "john", 
            //   office: "HUP",
            //   doctor:"Duquan Ali",
            //   reviewDate:"2022-04-23",
            //   reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
            //   rating: 3
            // },
            // {
            //   id: 7,
            //   patientFirstName: "Betsie", 
            //   office: "Lutheran",
            //   doctor:"John Jacob",
            //   reviewDate:"2022-04-23",
            //   reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
            //   rating: 1
            // },
            // {
            //   id: 3,
            //   patientFirstName: "Capt'n Crunch", 
            //   office: "presbyterian",
            //   doctor:"smit rehan",
            //   reviewDate:"2022-04-23",
            //   reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
            //   rating: 5
            // },
            // {
            //   id: 10,
            //   patientFirstName: "Julien", 
            //   office: "presbyterian",
            //   doctor:"Julie Metta",
            //   reviewDate:"2022-04-23",
            //   reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
            //   rating: 4
            // },
        ]
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
    mounted(){
      console.log(this.$route.params.doctorID)
      console.log("hello World!! It Works!!!")

      if(this.$route.params != null){
        if(this.currentUserType){
          reviewService.listReviewByDoctorId(this.currentUserProfile.doctorId).then(response => {
            this.reviews = response.data
        }).catch(error => {
            console.log(error)
            this.error = true
        })
          }else{
              reviewService.listReviewByDoctorId(this.$route.params.doctorID).then(response => {
                this.reviews = response.data
            }).catch(error => {
                console.log(error)
                this.error = true
            })
          }
      } else{
        this.$router.push('/')
      }
      //this.avgRating = 9;
      this.avgRating = this.reviews.map(review => review.rating).reduce((acc, amount)=> acc+amount);
      /*Will want to change JSON.parse to take actual JSON String*/
      //var body = JSON.parse(this.reviews);
      this.avgRating = (this.avgRating/5 /*body.value.length*/)
    },
    methods:{
      //must change array object name
      averageRating(){
        let count = 0;
        for (let i = 0; i < this.reviews.rating.length; i++){
          count += this.reviews[i].rating;
        this.avgRating = (count/this.reviews.rating.length);
        }
      },
      addReviewParamsAndShowForm(reviewId){
        this.isResponse = !this.isResponse;
        this.reviewResponseId = reviewId;
        console.log(this.reviewResponseId);
      },
      submitResponse(){
        addReviewResponse(this.reviewResponseId,this.reviewResponse)
        .then((response)=> {
                if(response.status == 201){
                    this.$router.push('review')
                }
            }).catch((error)=>{
                console.log(error.response.status);
            })
      }
    }

}
</script>

<style scoped>
.ReviewBox{
  display:inline-flexbox;
   border: 1.5px solid black;
   border-radius: 5px;
   margin: 1%;

   background-color: #F0F8FF;
	padding: 25px;
	border-radius: 3px;
}
.button{
  text-align: center;
}
.ratings{
  align-content: center;
}
.respond-fix{
  z-index: auto;
}



</style>