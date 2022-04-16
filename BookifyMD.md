///////////////////////////////////////////////////////////////////////////////////
****************************BOOKIFYMD_MED_SCHEDULING_APP*****************************

MVP's 12 (Login and Register excluded)

**As A USER.DOCTOR
        CRUD           DATA                                   TRELLO ID

    - (PUT)        Office Profile Info                  -    Update Office Info
    - (PUT)        Schedule/Availabilty                 -    Update Availability
    - (GET)        Patient Appointment Set              -    Appointment Notification
    - (GET)        UpcomingAppointments w. PatientInfo  -    Agenda
    - (PUT)        updateReview/Respond                 -    Respond to Reviews
    - (GET)        viewReviews - for my Doctor's Office -    Respond to Reviews

**As A USER.PATIENT
    - (GET)        Office Profile Info for Doctor       -    View Office Info
    - (GET)        Doctor's Availability/SetSchedule    -    View Availability
    - (POST)       SetAppointment                       -    Book an Appointment          
    - (GET)        Read Reviews - All Offices           -    Read Reviews
    - (POST)       CreateReview - for my Doctor's Office-    Submit Review


*************Additional**Functionality:*************
Doctor - Office info - delay indicator
Doctor - reschedule or cancel appointments 
Patient - select reason for visit when setAppointment
Patient - appointment notification for cancellation or reschedule

****************************DEFINE**TERMS*****************************

Schedule - Set Schedule - For when patients will schedule the doctor

Availability - Handled in the profile, Displays Doctor's available slots and can be updated

Agenda - displayed in Appointment.view; comprised of DoctorSchedule.component and patient Appointments.components
                                                        //now Doctor Appointments
    

****************************LIST**OF**VIEWS *****************************
Appointment
    - doctor-schedule
    - patient-appointments
Home
    -center-display
        -nav-bar
Login
Logout
Profile
    - doctor-profile
    - patient-profile

ProfileRegister
    - doctor-profile-info-form
    - patient-profile-info-form
Register
Review
    -review-display
    -review-submission-form
Schedule
    -schedule-appointment-form


****************************LIST**OF**COMPONENTS*****************************
AvailabilityDayDisplay
CenterDisplay

DoctorProfile
DoctorProfileInfoForm
DoctorSchedule

LandingCenterColumn
NavBar
NotificationCenter

PatientAppointments
PatientProfile
PatientProfileInfoForm

ReviewDisplay
ReviewSubmissionForm

ScheduleAppointmentForm




DoctorSchedule - component

Schedule - view will have the 
    SetSchedule.component encompassing a form for a doctor set their schedule. 





///////////////////////////////////////////////////////////////////////////////////