import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {

  currentUser() {
    return http.get('/user'); 
  },
  currentUserProfile(){
    return http.get('/userprofile')
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
