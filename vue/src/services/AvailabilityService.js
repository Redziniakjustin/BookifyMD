import axios from 'axios';

export default {
    currentDoctorAvailability(doctorId){
        return axios.get('/doctors/${doctorId}/availability', doctorId)
      },
    currentDoctorAvailabilityByDay(dayOfWeek){
        return axios.get('/availability/${dayOfWeek}', dayOfWeek)
      },
}