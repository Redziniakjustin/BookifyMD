<template>
   <div>
     <div>
      <star-rating 
      v-model="avgRating" 
      v-bind:show-rating="false" 
      v-bind:read-only="true"
      v-bind:increment="0.01"/>
      <span>{{avgRating}}</span>
      <table>
        <tbody v-for="review in reviews" :key=review>
          <tr>
            <td>
              <h3>
                {{review.reviewDate}}
              </h3>
            </td>
          </tr>
          <tr>
            <td>{{review.doctor}}</td>
          </tr>
          <tr>
            <td>{{review.office}}</td>
          </tr>
          <tr>
            <td>Reviewer: {{review.patientFirstName}}</td>
          </tr>
          <tr>
            <td>{{review.reviewDesc}}</td>
          </tr>
          <tr>
            <td>{{review.rating}}</td>
          </tr>
          <tr>
            <td>
              <!--Will need to make this a v-if for state.isDoctor-->
              <button @click="addReviewParamsAndShowForm(review.id)">
                Respond
              </button>
                </td>
          </tr>
        </tbody>
      </table>
     </div>
    <div v-if="isResponse">
        <form @submit.prevent="submitResponse">
          <h2>Respond to review</h2>
          <input type="text" v-model="reviewResponse">
          <button type="submit">submit</button>
        </form>
    </div>
  </div>
</template>

<script>
//import listReviewByDoctorId from '@/services/ReviewService'
import addReviewResponse from '@/services/ReviewService'
import StarRating from 'vue-star-rating';


export default {

 data(){
        return{
            isResponse: false,
            avgRating: {},
            reviewResponse: "",
            reviewResponseId: "",
            //reviews:[],
            reviews:[
            {
              id: 2,
              patientFirstName: "Percy", 
              office: "presbyterian",
              doctor:"smit rehan",
              reviewDate:"2022-10-23",
              reviewDesc: "I came to Dr. Rehan with a toothache and lost my kidneys",
              rating: 5
            },
            {
              id: 5,
              patientFirstName: "john", 
              office: "HUP",
              doctor:"Duquan Ali",
              reviewDate:"2022-04-23",
              reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
              rating: 3
            },
            {
              id: 7,
              patientFirstName: "Betsie", 
              office: "Lutheran",
              doctor:"John Jacob",
              reviewDate:"2022-04-23",
              reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
              rating: 1
            },
            {
              id: 3,
              patientFirstName: "Capt'n Crunch", 
              office: "presbyterian",
              doctor:"smit rehan",
              reviewDate:"2022-04-23",
              reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
              rating: 5
            },
            {
              id: 10,
              patientFirstName: "Julien", 
              office: "presbyterian",
              doctor:"Julie Metta",
              reviewDate:"2022-04-23",
              reviewDesc: "I came to Dr. Ali with a toothache and lost my kidneys",
              rating: 4
            },
        ]
      }
    },
    components:{
        StarRating
    },
    mounted(){
      console.log("hello World!! It Works!!!")
      // if(this.$store.profileType.isDoctor){
      //     listReviewByDoctorId(this.$state.profile.doctorId).then(response => {
      //       this.reviews = response.data
      //   }).catch(error => {
      //       console.log(error)
      //       this.error = true
      //   })
      // }else{
      //     listReviewByDoctorId(this.$route.params.doctorID).then(response => {
      //       this.reviews = response.data
      //   }).catch(error => {
      //       console.log(error)
      //       this.error = true
      //   })
      // }
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

<style>

</style>