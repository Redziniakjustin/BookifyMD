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

</style>