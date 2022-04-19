<template>
  <div class="review-container">

      <div class=".review-head">
            <h1>Reviews</h1>

            <h3>
              We value our customers reviews because they allow our care providers invaluable feedback.
            </h3>
      </div>


    <div class="review-body elevated-box">
        <div class="review-btns review-col-l"> 
          <img src="../assets/review-l.png" alt="">

          <label for="sort-review-doctor"></label>
          <input type="text" placeholder="Search By Doctor"/>
          <input type="submit">

          <label for="view-all-for-provider"></label><br><br>
          <input type="text" placeholder="Search By Provider"/>
          <input type="submit">
        </div>

     <div class="review-col-m">
        <review-display/>  
     </div>    
     <div class="review-col-r"> 
       <img src="../assets/review_1.png" alt="">

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
   .review-col-l{
     margin: 0 0 0 20px;
   }
   .review-col-r{
     margin: 0 20px 0 0;
     
     /* box-shadow:
      0 2.8px 2.2px rgba(0, 0, 0, 0.034),
      0 6.7px 5.3px rgba(0, 0, 0, 0.048),
      0 12.5px 10px rgba(0, 0, 0, 0.06),
      0 22.3px 17.9px rgba(0, 0, 0, 0.072),
      0 41.8px 33.4px rgba(0, 0, 0, 0.086),
      0 100px 80px rgba(0, 0, 0, 0.12);

      min-height: 200px;
      width: 50vw;
      background: white;
      border-radius: 5px; */
   }
</style>