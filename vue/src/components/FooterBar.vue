<template>
    <div class="footer-container">
        <div class="gradient">
            </div> 
      <div class="footer-body">
            <div class="f-row-1">
               <div class="location air">
                <h5>Headquarters</h5> 
                1500 E. Market St.
                Philadelphia, Pa 19199 
                </div>
                <div class="contact air">
                    <span>Contact</span> 
                    <span>1-888-215-5555</span>
                </div>
                <div class="legal air">
                <h5> Legal</h5> 
                <a> Privacy Policy </a>
                <a> Terms of Service </a>
                </div>
            
                <div class="disclosure air">
                <h5>Disclosure</h5>
                <p>
                BookifyMD reviews constitute the
                subjective opinions of individual
                end users based on their own experiences
                and do not represent the views of BookifyMD
                or its affiliates.
                </p>
              
                </div>

                <div class="about-small air">
                    <h5> About</h5>
                    <p>BookifyMD is a healthcare portal that frees
                    providers to focus on patients by connecting
                    Professionals anytime, anywhere and with any device.
                    </p>
                </div>
             </div><!--row-1--> 
             
               <div class="copyright air">
                <span>2022 &copy; BookifyMD. All Rights Reserved.</span>
                    <span>Site Design and Development by TEJAVAGRN</span>
                </div>
     <br> <!--replace w padding b-->
     <br>
     <br>
     <br>    
      </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.footer-container{
background: rgb(81, 56, 104);
color:whitesmoke;
position: relative;
width: 100%;
max-height: 300px;
z-index: -1;
bottom: 0;
}
.footer-body{
display: flex;
flex-direction: column;
align-items: center;
justify-content: center;
margin-top: auto 
}
.f-row-1{
display: flex;
flex-direction: row;
align-items: start;
justify-content: center;
margin: 5px 0 10px 0;
}
.copyright{
    text-align: center;
}
/* .gradient{
    max-height: 10px;
    background-color: linear-gradient(white,rgb(81, 56, 104));
} */
.air{
    margin: 0 10px 0 10px;
}
</style>