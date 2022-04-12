SELECT * FROM users;

INSERT INTO users ( username, password_hash, role)
VALUES ('justinR', 'password', 'admin');

INSERT INTO users ( username, password_hash, role)
VALUES ('Eric', 'password', 'user');

INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (3, 'Justin','Redziniak', 6,'redziniakjustin@gmail.com', 1);

SELECT * FROM office;

INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status)
VALUES ('Philadelphia', '307 W Park Ave', 'Philadelphia', 'PA', '19047', 6097816734, 'phillyoffice@gmail.com', '5:00','6:00', true);

SELECT * FROM doctor_office_availability;

INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (1,5,'Monday','5:00','7:00',true, '' );

SELECT * FROM patient;

INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (4,'Eric', 'Hilkowitz', 99999, '111 Parkway','Philadelphia','PA','19055','ehilk@gmail.com');

SELECT * FROM appointment;

INSERT INTO appointment (doctor_id, patient_id, office_id, appointment_date, appointment_status, description, reason_selected)
VALUES (1,1,1, '1/1/22', 'Scheduled', 'Check-up', '' );

SELECT * FROM review;

INSERT INTO review (patient_id, office_id, doctor_id, review_date, review_desc, review_rating)
VALUES (1,1,1,'1/1/21','Dr. Justin did not do good', 1)

SELECT * from doctor_office;

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (3,3);

SELECT * from patient_app;

INSERT INTO patient_app ( patient_id, appointment_id)
VALUES (1,1);

SELECT office.office_name 
FROM doctor_office_availability
JOIN office ON office.office_id = doctor_office_availability.office_id;




