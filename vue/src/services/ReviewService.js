import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {

  list() {
    return http.get('/reviews'); 
    // addreview
  },

//   get(id) {
//     return http.get('/reviews/${id}', review);
//   },

//   create(id) {
//     return http.post('/reviews/${id}', review);
//   },

//   update(){
//     return http.update('/reviews', review);
// }

}
