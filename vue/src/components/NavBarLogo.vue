<template>
  <div class="center-header-container container" id="chc">    
                <a class="logo" href="">
                    <img @click=returnHome 
                    class="logo" 
                    src="..\assets\logo-transparent.png" 
                    id="logo" alt="BookifyMD Logo Here" 
                    />   <!-- ..\assets\Final-Logo-Transparent.png -->        
                </a>    
            </div> 
</template>

<script>
export default {
methods:{
  returnHome(){
    return this.$router.push('/')
  }
}
}
</script>

<style>

</style>