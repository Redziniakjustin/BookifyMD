import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
  });

export default {
    currentDoctorAvailability(){
        return http.get('/availability')
      },
    currentDoctorAvailabilityByDay(dayOfWeek){
        return http.get('/availability/${dayOfWeek}', dayOfWeek)
      },
}