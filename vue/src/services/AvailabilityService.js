import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {
    currentDoctorAvailability(doctorId){
        return http.get('/doctors/${doctorId}/availability', doctorId)
      },
    currentDoctorAvailabilityByDay(dayOfWeek){
        return http.get('/availability/${dayOfWeek}', dayOfWeek)
      },
}