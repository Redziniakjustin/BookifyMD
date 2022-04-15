import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {
//Doctor call
  listDoctor() {
    return http.get('/doctors'); 
  },
  getDoctor(id) {
      return http.get('/doctors/${id}', id)
  },
  listOffices(){
      return http.get('/offices')
  }, 
  getOffice(id){
      return http.get('/providers/${id}', id)
  }, 
  addProfile(profile){
    return http.post('/profile', profile)
  }

}