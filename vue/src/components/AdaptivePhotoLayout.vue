<template>

<div class ="adaptivePhotoLayout">
    <ul>
  <li>
    <img src ="..\assets\ScreenDNA-1.png">
  </li>
 <li>
    <img src ="..\assets\Screen1.png">
  </li>
  <li>
    <img src = "..\assets\ScreenDoctorWoman.png">
  </li>
  <li>
    <img src = "..\assets\keyboardbill1.png">
  </li>
  <li>
    <img src = "..\assets\DoctorByWindow.png">
  </li>
  <li>
    <img src = "..\assets\doctorholdingbehindback.png">
  </li>
  </ul>
</div>
  
</template>

<script>
export default {
}
</script>

<style scoped> ul {
  display: flex;
  flex-wrap: wrap;
}
li {
  height: 40vh;
  flex-grow: 1;
}
img {
  max-height: 100%;
  min-width: 100%;
  object-fit: cover;
  vertical-align: bottom;
}</style>