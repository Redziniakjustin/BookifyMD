<template>
  <div class="review-container">

      <div class=".review-head">
            <h1>Reviews</h1>

            <h3>
              We value our customers reviews because they allow our care providers invaluable feedback.
            </h3>
      </div>


    <div class="review-body">
          <review-submission-form/>

          <review-display/>

        <div class="review-btns"> 
          <label for="sort-review-doctor"></label>
          <input type="text" placeholder="Search By Doctor"/>
          <input type="submit">

          <label for="view-all-for-provider"></label><br><br>
          <input type="text" placeholder="Search By Provider"/>
          <input type="submit">
        </div>
          
    </div>``

  </div>
</template>

<script>
import ReviewDisplay from '../components/ReviewDisplay.vue'
import ReviewSubmissionForm from '../components/ReviewSubmissionForm.vue'
export default {
   data(){
        return{
            doctor:{
                name: "Kyle M" 
            },
        }
    },
  components: { 
    ReviewSubmissionForm,
    ReviewDisplay },

}
</script>

<style>
  .review-container{
    margin-top: 150px;
    align-content: center;
   }
  .review-head{
  /* text-align: center; */
}

   .review-body{
     display: flex;
     flex-direction: row;
     align-items: center;
     justify-content: space-between;
     margin: 80px 0 10px 0;
     font-size: 0.75rem;
   }
</style>