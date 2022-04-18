import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {

  listReviewByDoctorId(id) {
    return http.get('/reviews/doctors/${id}', id); 
    // addreview
  },

//   get(id) {
//     return http.get('/reviews/${id}', review);
//   },

  addReview(review) {
    return http.post('/reviews/', review);
  },

//   update(){
//     return http.update('/reviews', review);
// }

}
