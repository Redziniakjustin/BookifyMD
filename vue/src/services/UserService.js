import axios from 'axios';

export default {

  currentUser() {
    return axios.get('/user'); 
  },
  currentUserProfile(){
    return axios.get('/userprofile')
  },
//   get(id) {
//     return http.get('/users/${id}', user);
//   },

//   create(id) {
//     return http.post('/users/${id}', user);
//   },

//   update(){
//     return http.update('/users', user);
// }

}
