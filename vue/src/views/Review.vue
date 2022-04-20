<template>
  <div class="review-container">
      <div class=".review-head">
          <h1>Reviews</h1>
          <h3>We value our customers reviews because they allow our care providers invaluable feedback.</h3>
      </div>
    <div class="review-body elevated-box display-container">
        <div class="review-btns review-col-l left-column"> 
          <img src="../assets/review-l.png" alt="Doctor Photo 1">

          <label for="sort-review-doctor"></label>
          <input type="text" placeholder="Search By Doctor"/>
          <input type="submit">

          <label for="view-all-for-provider"></label><br><br>
          <input type="text" placeholder="Search By Provider"/>
          <input type="submit">
        </div>

     <div class="middle-column">
        <review-display/>  
     </div>    
     <div class="right-column"> 
       <img src="../assets/review_1.png" alt="Doctor Photo 2">
         <review-submission-form/>
     </div>   
    </div>

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
    align-items: center;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
</style>