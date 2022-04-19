import axios from 'axios';

export default {

  listReviewByDoctorId(id) {
    return axios.get('/reviews/doctors/${id}', id); 
    // addreview
  },

//   get(id) {
//     return http.get('/reviews/${id}', review);
//   },

  addReview(review) {
    return axios.post('/reviews/', review);
  },

  addReviewResponse(id, reviewResponse){
    return axios.put('/reviews/${id}', {id, reviewResponse});
}

}
