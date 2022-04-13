<template>
  <div>
      <form method="POST"> <!--Will need to pass through DOctor id, appointment id, clinic name, current user to DB -->
          <h2></h2>
          <textarea name="review" id="reviewDescription" placeholder="What Did you Think of Your Visit with {{doctor.name}}?"/>
          <star-rating />
          <input type="submit" @click="router.push({ path: 'appointment' })">
        </form>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating'
export default {
    data(){
        return{
            doctor:{
                name: "Kyle M" 
            }
        }
    },
    components:{
        StarRating
    }
}
</script>

<style>

</style>
