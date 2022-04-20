import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token'); //this returns null
const currentUser = JSON.parse(localStorage.getItem('user')); //this returns null before PARSE
//const currentUserProfile = JSON.parse(localStorage.getItem('profile')); //this returns null before PARSE
//const currentProfileType = JSON.parse(localStorage.getItem('profileType'));//this returns null before PARSE

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Vue.prototype.$currentProfile = currentUser.profile;
// Vue.prototype.$currentProfileType =  currentProfileType;
Vue.prototype.$test = 'BlahBlahBlah';



export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    profile: {},
    authenticated: false, 
    profileType: {}
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    SET_PROFILE(state, profile) {
      if(state.user.id != null){
        state.profile = profile;
      }
    }, 
    SET_PROFILE_TYPE(state, userType){
      if(state.user.id != null){
        state.profileType = userType;
      }
    },
    SET_AUTHENTICATION(state, authenticated){
      if(state.token != null){
        state.authenticated = authenticated;
      }
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      state.profile = {};
      state.profileType = {};
      state.authenticated = false;
      axios.defaults.headers.common = {};
    }
  }
})
