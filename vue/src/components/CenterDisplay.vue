<template>
  <div class="display-container dc-plus">
    <div class="left-column column">
      <div>
        <img
          src="../assets/landing-1.png"
          alt="Doctor's Reviewing Patient Chart"
        />
        <h1 class="">Available Doctors</h1>
        <input
          class=""
          type="text"
          placeholder="Search By Doctor"
          v-model="search"
        />
        <!--When schedule appointment link is clicked next to doctor's name in home view. The doctors ID is passed to the schedule appointment view -->
        <input class="btn-search" type="submit" />
      </div>
      <table>
        <tbody v-for="doctor in doctors" :key="doctor.doctorId">
          <tr>
            <td>Dr. {{ doctor.firstName }} {{ doctor.lastName }}</td>
          </tr>
          <tr>
            <td>{{ doctor.location }}</td>
          </tr>
          <tr>
            <td>{{ doctor.phone }}</td>
          </tr>
          <tr>
            <td>{{ doctor.email }}</td>
          </tr>
          <tr>
            <td>
              Hourly Cost: <strong>${{ doctor.costHourly }}</strong>
            </td>
          </tr>
          <!-- <tr>
                <td v-on:click="clicked" v-if="user.role=='patient'">
            </tr> -->
          <tr>
            <td>
              <button class="table-btn">
                <router-link
                  id="reviews"
                  :to="{
                    name: 'review',
                    params: {
                      doctorID: doctor.doctorID,
                      firstName: doctor.firstName,
                      lastName: doctor.lastName,
                    },
                  }"
                  >Reviews</router-link
                >
              </button>
            </td>
            <!--Must Pass through all of the default params params Will need a query that shows where the doctor is on a certain day will need to be accomplished on backend-->
            <td>
              <button class="table-btn">
                <router-link
                  id="schedule"
                  :to="{
                    name: 'schedule',
                    params: {
                      doctorID: doctor.id,
                      patientID: currentUser.id,
                      officeID: doctor.officeID,
                    },
                  }"
                  >Schedule</router-link
                >
                <!-- capture id-->
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <!--must change v-if to take global auth variable -->
    <div v-if="this.$store.state.authenticated" class="middle-column column">
      <!--Change V-if {This will be to show notification for Auth Users only!!}-->
      <h2 v-if="this.$store.state.profile.firstName === null">
        Please Update Profile Here:
        <router-link :to="{ name: 'profileRegister' }"
          >Register Profile</router-link
        >
      </h2>
      <notification-column />
    </div>
    <!-- OR -->
    <div v-else class="middle-column column">
      <!--Change V-if {This will be to show Landing Page}-->
      <landing-center-column />
    </div>

    <div class="right-column column">
      <div>
        <h1 class="">Available Healthcare Providers</h1>

        <input
          class="btn-search"
          type="text"
          placeholder="Search By Provider"
        />

        <input class="btn-search" type="submit" />
      </div>
      <table>
        <tbody v-for="office in offices" :key="office.id">
          <tr>
            <td>{{ office.officeName }}</td>
          </tr>
          <tr>
            <td>{{ office.streetAddress }}</td>
          </tr>
          <tr>
            <td>{{ office.city }}</td>
          </tr>
          <tr>
            <td>{{ office.phone }}</td>
          </tr>
          <tr>
            <td>{{ office.email }}</td>
          </tr>
        </tbody>
      </table>

      <img src="../assets/landing-2.png" alt="" />
    </div>
  </div>
</template>

<script>
import LandingCenterColumn from "@/components/LandingCenterColumn.vue";
import NotificationColumn from "@/components/NotificationColumn.vue";
//Will Use once API endpoints are available
import profileService from "@/services/ProfileService";
export default {
  data() {
    return {
      search: "",
      /* user:{
                role: 'patient',
                id: 9876
            }, */
      //authenticated: "True",
      authenticated: "False",
      active: "True",
      doctors: [{}],
      offices: [{}],
    };
  },
  components: {
    LandingCenterColumn,
    NotificationColumn,
  },
  computed: {
    currentUser() {
      return this.$store.state.user;
    },
    filteredDoctors() {
      if (!this.search) {
        return this.doctors;
      } else {
        return this.doctors.filter((doctor) => {
          return (
            doctor.name.toLowerCase().includes(this.search.toLowerCase()) ||
            doctor.location.toLowerCase().includes(this.search.toLowerCase())
          );
        });
      }
    },
    isAuthenticated() {
      return this.$store.state.authenticated;
    },
  }, //Will be used to populate the doctors list.
  mounted() {
      console.log(1);
    console.log("Recognized user: " + this.currentUser.id);

    console.log("Calling Doctor List");
    //Will be used to populate the doctors list.
    profileService
      .listDoctor()
      .then((response) => {
          console.log(2);
        this.doctors = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.error = true;
      })
      .finally(() => (this.loading = false));
    console.log(this.doctors);

    console.log("Calling Office List");
    //Will be used to populate providers list.
    profileService.listOffices()
      .then((response) => {
          console.log(3);
        this.offices = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.error = true;
      })
      .finally(() => (this.loading = false));
    console.log(this.offices);

        console.log('Set Authentication, why?')
    //Set Store state authenticated
    if (this.$store.state.user.id != null) {
      let authenticated = true;
      this.$store.commit("SET_AUTHENTICATION", authenticated);
    } else {
      console.log("Failed");
    }

        console.log("Calling Profile");
    //Method to set user Profile
    if (this.$store.profileType.isDoctor) {
      profileService
        .getDoctorProfileById(this.$store.state.user.id)
        .then((response) => {
            console.log(5);
          if (response.status == 200) {
            this.$store.commit("SET_PROFILE", response.data);
          } else {
            console.log("Failed");
          }
        });
    } else {
      profileService
        .getPatientProfileById(this.$store.state.user.id)
        .then((response) => {
            console.log(6);
          if (response.status == 200) {
            this.$store.commit("SET_PROFILE", response.data);
          }
        });
    }

    //TODO: BAD NAMING MAY CAUSE FUNCTIONAL CONFUSION -> getUserTypeByID !-> Profile
    console.log("Calling UserType");

    profileService.getUserTypeIdById(this.currentUser.id).then((response) => {
        console.log(4);
      if (response.status == 200) {
        //this.$store.commit("SET_PROFILE_TYPE", response.data)
        this.$store.commit("SET_PROFILE", response.data);

        
      } else {
        console.log("UserTypeFailed");
      }
    });


  },
};
</script>


<style>
@import "../assets/styles/styles.css";

.dc-plus {
  margin: 150px 0 10px 0;
}
</style>