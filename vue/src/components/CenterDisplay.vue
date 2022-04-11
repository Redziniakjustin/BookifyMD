<template>
<div class=""> 
    <div class="left-column">
        <div>
            <h1 class="">Available Doctors</h1>
            <input type="text" value="Search By Doctor"/>
        </div> 
        <table>
        <tbody>
            <tr>
                <td v-on:click="clicked">
                   <input type="checkbox"> 
                </td>
                <td>{{name}}</td>
                <td>{{location}}</td>
                <td>{{phone-number}</td>
                <td>{{rating}</td>
                <td>{{reviews}</td>
            </tr>
        </tbody>
        </table>
    </div>

    <div class="middle-column">
        <h1 class="welcome"></h1>
        <img src="" alt="">
        <p></p> 

        <h1 class="about-us"></h1>
        <img src="" alt="">
        <p></p>

        <h1 class="testimonials"></h1>
        <img src="" alt="">
        <p></p>
    </div>

    <div class="right-column">
         <div>
            <h1 class="">Available Doctors</h1>
            <input type="text" value="Search By Doctor"/>
        </div> 

        <table>
        <tbody>
            <tr>
                <td v-on:click="clicked">
                   <input type="checkbox"> 
                </td>
                <td>{{name}}</td>
                <td>{{location}}</td>
                <td>{{phone-number}</td>
                <td>{{rating}</td>
                <td>{{reviews}</td>
            </tr>
        </tbody>
        </table>
    </div>


</div>
</template>

<script>
export default {

}
</script>

<style>

</style>