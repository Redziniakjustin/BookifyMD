<template>
   <div>
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
export default {

 data(){
        return{
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

}
</script>

<style>

</style>