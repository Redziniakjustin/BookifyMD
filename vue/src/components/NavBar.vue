<template>
  <div class="header-container">
    <div class="left-header-container"><!--Left Column {Site Navigation} Dropdown?-->
        <label></label>
        <optgroup> <!-- Patient -->
            <option>
                <a></a> <!--Profile-->
            </option>
            <option>
                <a></a><!--Book Appointment-->
            </option>
            <option>
                <a></a><!--Write a Review-->
            </option>
        </optgroup>
        <optgroup> <!--Doctor -- {Validation for only Doctors}-->
            <option value="">
                <a href=""></a> <!-- Profile -->
            </option>
            <option value="">
                <a href=""></a><!--Set Schedule -->
            </option>
            <option value="">
                <a href=""></a><!--View Reviews -->
            </option>
        </optgroup>
        <optgroup> <!-- Healthcare Office -->
            <option value="">
                <a href=""></a><!-- Profile -->
            </option>
            <option value="">
                <a href=""></a><!-- View Reviews -->
            </option>
        </optgroup>      
    </div> 
    <div class="center-header-container">
        <a><!--Middle Col click logo to return home-->
            <img href="#" id="logo"/>
            <img href="#" id="logo-slogan"/>
        </a>
    </div> 
    <div class="right-header-container"> <!-- Right Column --> 
        <h3></h3><!--Log In / Log Out -->
        <h3></h3><!--Register / Profile -->
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 0 20px 20px 20px;
}

.header-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 20px 0 10px 0;
  font-size: 0.75rem;
}

/* Potential Colors

 purple - #9999FF
 purple light - #E6E6FF 
 deep blue - #2C00CC 

*/

</style>