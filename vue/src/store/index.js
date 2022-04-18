import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import getUserTypeIdById from '@/services/ProfileService'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token');
const currentUser = JSON.parse(localStorage.getItem('user'));
const currentUserProfile = JSON.parse(localStorage.getItem('profile'))
const currentProfileType = JSON.parse(localStorage.getItem('profileType'))

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}



export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    profile: currentUserProfile || {},
    authenticated: false, 
    profileType: currentProfileType || {}
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
        if(state.profileType.isDoctor === false){
          //Code to to populate patient profile
        }else{
          //code to populate doctor profile
        }
        state.profile = profile;
        localStorage.setItem('profile',JSON.stringify(profile));
      }
    },
    SET_PROFILE_TYPE(state, profileType){
      if(getUserTypeIdById(state.user.id) != null){
        state.profileType = profileType;
        localStorage.setItem('profileType', getUserTypeIdById(state.user.id))
      }
    },
    SET_AUTHENTICATION(state, authenticated){
      if(state.token != null){
        state.authenticated = authenticated;
        localStorage.setItem('authenticated', true)
      }
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      state.profile = {};
      state.authenticated = false;
      axios.defaults.headers.common = {};
    }
  }
})
