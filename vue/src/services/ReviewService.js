import axios from 'axios';

export default {

  listReviewByDoctorId(id) {
    return axios.get('/reviews/doctors/${id}', id); 
  },
  addReview(review) {
    return axios.post('/reviews/', review);
  },

  addReviewResponse(id, reviewResponse){
    return axios.put('/reviews/${id}', {id, reviewResponse});
}

}
