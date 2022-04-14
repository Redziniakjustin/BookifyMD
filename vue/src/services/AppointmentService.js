import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {
//Doctor call
  listAppointments() {
    return http.get('/appointments'); 
  },
  getAppointment(id) {
      return http.get('/appointments/${id}', id)
  },
  addAppointment(){
      return http.post('/appointments')
  }, 
  updateAppointment(id){
      return http.put('/appointments/${id}', id)
  }, 
  deleteAppointment(id){
      return http.delete('/appointments/${id}', id)
  }

}