<template>
<div class=""> 
    <div class="left-column">
        <div>
            <h1 class="">Available Doctors</h1>
            <input type="text" placeholder="Search By Doctor"/>
        </div> 
        <table>
        <tbody>
            <tr>
                <td v-on:click="clicked">
                   <input type="checkbox"> 
                </td>
                <td>{{name}}</td>
                <td>{{location}}</td>
                <td>{{phone-number}}</td>
                <td>{{rating}}</td>
                <td>{{reviews}}</td>
            </tr>
        </tbody>
        </table>
    </div>



    <div v-if="active" class="middle-column"><!--Change V-if {This will be to show Landing Page}-->
        <landing-center-column/>
    </div>
    <div v-if="authenticated" class="middle-column"><!--Change V-if {This will be to show notification for Auth Users only!!}-->
        <notification-column/>
        
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
                <td>{{phone-number}}</td>
                <td>{{rating}}</td>
                <td>{{reviews}}</td>
            </tr>
        </tbody>
        </table>
    </div>

</div>

</template>

<script>
    import LandingCenterColumn from '@/components/LandingCenterColumn.vue'
    import NotificationColumn from '@/components/NotificationColumn.vue'
    export default {
        data(){
            return {
                authenticated: "True",
                active: "True"
            }
             
        },
        components:{
            LandingCenterColumn,
            NotificationColumn
        }

}
</script>

<style>

</style>