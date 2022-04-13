<template>
  <div class="review-container">

<h1>Reviews</h1>

<h3>
  We value our customers reviews because they allow our care providers invaluable feedback.
</h3>

<p></p>

<review-submission-form/>

<label for="sort-review-doctor"></label>
<input type="text" placeholder="Search By Doctor"/>
<input type="submit">

<label for="view-all-for-provider"></label><br><br>
<input type="text" placeholder="Search By Provider"/>
<input type="submit">

<review-display/>


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
/* .review-container{
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
} */

</style>