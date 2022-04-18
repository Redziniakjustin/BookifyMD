<template>
   <div>
      <h2 v-if="avgRating != ''">{{avgRating}} </h2>
      <table>
        <tbody v-for="review in reviews" :key=review>
          <tr>
            <td>{{review.patient}}</td>
          </tr>
          <tr>
            <td>{{review.office}}</td>
          </tr>
          <tr>
            <td>{{review.doctor}}</td>
          </tr>
          <tr>
            <td>{{review.review}}</td>
          </tr>
          <tr>
            <td>{{review.description}}</td>
          </tr>
          <tr>
            <td>{{review.rating}}</td>
          </tr>
        </tbody>
      </table>
  </div>
</template>

<script>
import listReviewByDoctorId from '@/services/ReviewService'
export default {

 data(){
        return{
            avgRating: "",
            //reviews:[],
            reviews:[
            {
              patient: "Percy Neville", 
              office: "presbyterian",
              doctor:"smit rehan",
              review:"I came to Dr. Rehan with a toothache and lost my kidneys",
              description: "N/A",
              rating: 5
            },
            {
              patient: "john jacob", 
              office: "HUP",
              doctor:"Duquan Ali",
              review:"I came to Dr. Ali with a toothache and lost my kidneys",
              description: "N/A",
              rating: 3
            },
            {
              patient: "Betsie Smith", 
              office: "Lutheran",
              doctor:"John Jacob",
              review:"I came to Dr. Jacob with a toothache and lost my kidneys",
              description: "N/A",
              rating: 1
            },
            {
              patient: "Capt'n Crunch", 
              office: "presbyterian",
              doctor:"smit rehan",
              review:"I came to Dr. Rehan with a toothache and lost my kidneys",
              description: "N/A",
              rating: 5
            },
            {
              patient: "Julien Assange", 
              office: "presbyterian",
              doctor:"Julie Metta",
              review:"I came to Dr. Metta with a toothache and lost my kidneys",
              description: "i lost my waller",
              rating: 4
            },
        ]
      }
    },
    mounted(){
      listReviewByDoctorId(this.$route.params.doctorID).then(response => {
            this.reviews = response.data
        }).catch(error => {
            console.log(error)
            this.error = true
        }).finally(() => this.loading = false)
    },
    methods:{
      //must change array object name
      averageRating(){
        let count = 0;
        for (let i = 0; i < this.reviews.rating.length; i++){
          count += this.reviews[i].rating;
        this.avgRating = (count/this.reviews.rating.length)
        }
      }
    }

}
</script>

<style>

</style>