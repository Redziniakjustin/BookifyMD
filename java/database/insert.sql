
BEGIN TRANSACTION;

-- Users (admin)
INSERT INTO users ( username, password_hash, role)
VALUES ('mcdc', 'password1', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('patriciaM', 'password2', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('caldwellJ', 'password3', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('gymshorts', 'password4', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('holmesB', 'password5', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('drbball', 'password25', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('furkan', 'password26', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('Drjordan', 'password27', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('tharris', 'password28', 'admin');
INSERT INTO users ( username, password_hash, role)
VALUES ('drembiid', 'password29', 'admin');
 
-- Users(user)
 
INSERT INTO users ( username, password_hash, role)
VALUES ('staffordM', 'password6', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('cj81', 'password7', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('sandersB', 'password8', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('goffG', 'password9', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('swiftD', 'password10', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('amonRa', 'password11', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('bighock', 'password12', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('raglater', 'password13', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('deckerT', 'password14', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('harrisC', 'password15', 'user');
 
INSERT INTO users ( username, password_hash, role)
VALUES ('Tbradley', 'password20', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('shakem', 'password21', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('jharden', 'password22', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('tmaxey', 'password23', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('gniang', 'password24', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('ijoe', 'password25', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('cbarkley', 'password33', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('cbassey', 'password32', 'user');
INSERT INTO users ( username, password_hash, role)
VALUES ('pcoffey', 'password35', 'user');


-- make sure to update user_ids below with what user table generates
 
-- Patients(19 patients)
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (13,'Matthew', 'Stafford', '(313)965-3584', '2868 Essex Ct','South Burlington','VT','05403','matthewS@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (14,'Calvin', 'Johnson', '(313)745-9071', '2672 Tennessee Avenue','Plymouth','MI','48107','calvinJ@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (15,'Barry', 'Sanders', '(313)784-5219', '4520 Bates Brothers Road','Columbus','OH','43213','barryS@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (16,'Jared', 'Goff', '(313)964-5010', '2417 Harter Street','Bellefontaine','OH','43311','jaredG@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (17,'Deandre', 'Swift', '(313)849-9667', '1903 Friendship Lane','Santa Clara','CA','95050','deandreS@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (18,'Amon-Ra', 'St. Brown', '(313)238-2256', '3225 Pooz Street','Piscataway','NJ','08854','amonra@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (19,'T.J.', 'Hockenson', '(909)883-5873', '4706 Romrog Way','Kearney','NE','68847','tjhock@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (20,'Frank', 'Ragnow', '(313)378-9030', '2818 Bartlett Avenue','Southfield','MI','48076','frankR@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (21,'Taylor', 'Decker', '(231)334-7649', '739 Whitetail Lane','Royse City','TX','75189','taylorD@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (22,'Charles', 'Harris', '(214)224-8191', '1409 Haven Lane','Grand Rapids','MI','49503','charlesH@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (23,'Tony', 'Bradley', '215-233-5000', '3400 Maple Ct','Philadelphia','PA','05403','tbradley@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (24,'Shake', 'Milton', '(267)725-9050', '2050 Shake Avenue','Trenton','NJ','48107','smilton@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (25,'James', 'Harden', '(303)700-5209', '4545 Hollywood Drive','Los Lamos','CA','42343','jharden@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (26,'Resse', 'Maxey', '(202)905-5050', '305 Hortter  Street','Philadelphia','PA','19311','rmaxey@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (27,'George', 'Niang', '(267)833-1267', '1800 Championship Lane','Santa Clara','CA','95050','gniang@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (28,'James', 'Harden', '(303)700-5209', '4545 Hollywood Drive','Los Lamos','CA','42343','jharden@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (29,'Charles', 'Barkley', '(213)235-2222', '3225 MLK Drive','Atlanta','GA','28854','cbarkley@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (30,'Charles', 'Bassley', '(225)815-5800', '4705 Cannon Way','Newtown','NE','68847','cbassley@gmail.com');
INSERT INTO patient (user_id, first_name, last_name, phone, street_address, city, state_name, zip, email)
VALUES (31,'Paul', 'Coffey', '(215)375-8030', '2518 Hall of Fame  Avenue','Southfield','MI','48076','paulcoffey@gmail.com');

-- Doctors(10)
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (3, 'Dan','Campbell', '(708)948-8661','danC@gmail.com', 100);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (4, 'Matt','Patricia', '(914)276-8149','mattP@gmail.com', 200);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (5, 'Jim','Caldwell', '(415)527-6914','jimC@gmail.com', 150);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (6, 'Jim','Schwartz', '(323)624-5868','jimS@gmail.com', 300);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (7, 'Brad','Holmes', '(505)538-4028','bradH@gmail.com', 250);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (8, 'Paul','Reed', '(215)948-8661','DrBball@gmail.com', 300);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (9, 'Furkan','Korkmaz', '(267)276-8149','furkKork@gmail.com', 200);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (10, 'DeAndre','Jordan', '(415)527-6914','DJordan@gmail.com', 250);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (11, 'Tobias','Harris', '(267)624-5100','tharris@gmail.com', 250);
INSERT INTO doctor (user_id, first_name, last_name, phone, email, cost_hourly)
VALUES (12, 'Joel','Embiid', '(747)535-9000','theprocess@gmail.com', 200);


--Offices
INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status)
VALUES ('Ford Field', '2000 Brush St', 'Detroit', 'MI', '48226', '3132622000', 'fordfield@gmail.com', '8:00','17:00', false);
 
INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status)
VALUES ('Practice Facility', '222 Republic Dr', 'Allen Park', 'MI', '48101', '3132164000', 'practicefacility@gmail.com', '09:00','22:00', false);
 
INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status)
VALUES ('South Health Center', '3400 Walnut St', 'Detroit', 'MI', '48226', '3132629000', 'southhealthcenter@gmail.com', '8:00','16:00', false);
 
INSERT INTO office ( office_name, street_address, city, state_name, zip, phone, email, office_hours_start, office_hours_end, delay_status)
VALUES ('Northside Pratice', '215 MLK Drive', 'Allen Park', 'MI', '48101', '3132163000', 'northsidepractice@gmail.com', '11:00','22:00', false);





-- doctor_office bridge table inserts

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (1, 1);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (2, 1);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (3, 1);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (4, 1);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (5, 2);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (6, 2);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (7, 2);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (8, 2);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (9, 3);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (10, 3);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (1, 3);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (2, 3);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (3, 4);

INSERT INTO doctor_office (doctor_id, office_id)
VALUES (4, 4);


-- Doctor_Office_Availability
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (1, 2, 1,'7:00','12:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (1, 3, 1,'8:00','12:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (1, 4, 2,'7:00','10:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (1, 3, 3,'8:00','11:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (2, 5, 3,'7:00','11:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (2, 6, 4,'7:00','11:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (2, 7, 4,'8:00','15:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (2, 8, 5,'11:00','15:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (3, 9, 6,'8:00','16:00',true, '' );
INSERT INTO doctor_office_availability (office_id, doctor_id,day_of_week, start_time, end_time, is_available, reason_of_unavailability)
VALUES (4, 4, 3,'9:00','12:00',true, '' );


-- appointment 
 
INSERT INTO appointment (doctor_id, patient_id, office_id, appointment_date, appointment_status, description)
VALUES (3, 14, 2, '1/1/22', 'Scheduled', 'Check-up' );

-- review
 
INSERT INTO review (appointment_id, review_date, review_desc, review_rating)
VALUES (1,'1/1/21','Dr. Justin did not do good', 1);

-- patient_app


INSERT INTO patient_app (appointment_id, patient_id)
VALUES (1, 14);



COMMIT;


--rollback;
-- SELECT * FROM users;

-- SELECT * FROM office;

-- SELECT * FROM doctor_office_availability;

-- SELECT * FROM doctor;
-- SELECT * FROM patient;


-- SELECT * FROM appointment;


-- SELECT * FROM review;



-- SELECT * from doctor_office;



-- SELECT * from patient_app;



-- SELECT office.office_name 
-- FROM doctor_office_availability
-- JOIN office ON office.office_id = doctor_office_availability.office_id;




