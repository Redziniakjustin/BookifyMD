BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




-- 2 DOCTOR TABLE CREATE --



DROP TABLE IF EXISTS doctor CASCADE;

CREATE TABLE doctor (
		doctor_id serial,
		user_id int,
		first_name varchar NOT NULL,
		last_name varchar NOT NULL,
		phone int NOT NULL, 
		email varchar(50) NOT NULL,
		cost_hourly int, 
		CONSTRAINT PK_doctor_id PRIMARY KEY (doctor_id),
		CONSTRAINT FK_doctor_user FOREIGN KEY (user_id) REFERENCES users(user_id)
	
	);




-- 3 PATIENT TABLE CREATE --



DROP TABLE IF EXISTS patient CASCADE; 

CREATE TABLE patient (
		patient_id serial,
		user_id int,
		first_name varchar NOT NULL,
		last_name varchar NOT NULL,
		phone int NOT NULL, 
		street_address varchar(100) NOT NULL, 
		city varchar(100),
		state_name varchar(100),
		zip varchar(15),
		email varchar(50) NOT NULL,
		CONSTRAINT PK_patient_id PRIMARY KEY (patient_id),
		CONSTRAINT FK_patient_user FOREIGN KEY (user_id) REFERENCES users(user_id)
	
	);



-- 4 doctor_office TABLE CREATE --



DROP TABLE IF EXISTS doctor_office CASCADE;

CREATE TABLE doctor_office(
		doctor_office_id serial,
		doctor_id int,	
		office_id int, 
		CONSTRAINT PK_doctor_office_id PRIMARY KEY (doctor_office_id),
		CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
		CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
	
	);



-- 5 OFFICE TABLE CREATE --



DROP TABLE IF EXISTS office CASCADE;

CREATE TABLE office (
		office_id serial,
		doctor_id int NOT NULL,
		avail_id int NOT NULL,
		office_name varchar(50) UNIQUE, 
		street_address varchar(100) NOT NULL, 
		city varchar(100),
		state_name varchar(100),
		zip varchar(15),
		email varchar(50) NOT NULL,
		office_hours time NOT NULL, 
		delay_status boolean,
		CONSTRAINT PK_office PRIMARY KEY (office_id),
		CONSTRAINT FK_doctor_avail FOREIGN KEY (avail_id) REFERENCES doctor_availability(avail_id),
		CONSTRAINT FK_office_doctor_office FOREIGN KEY (doctor_id) REFERENCES doctor_office(doctor_office_id)
	
	);
		



-- 6 appointments TABLE CREATE --



DROP TABLE IF EXISTS appointment cascade; 

CREATE TABLE appointment (
		appointment_id serial,
		doctor_id int NOT NULL,
		patient_id int NOT NULL,
		office_id int NOT NULL, 
		appointment_date varchar(20),
		appointment_status varchar(20),
		description varchar(50) NOT NULL, 
		reason_selected varchar(50), 
		CONSTRAINT PK_appointment PRIMARY KEY (appointment_id),
		CONSTRAINT FK_appointments_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
		CONSTRAINT FK_appointments_patient  FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
		CONSTRAINT FK_appointments_office  FOREIGN KEY (office_id) REFERENCES office(office_id)
		
	);



-- 7 Reviews TABLE CREATE --



DROP TABLE IF EXISTS review CASCADE;

CREATE TABLE review (
		review_id serial,
		patient_id int NOT NULL,
		office_id int NOT NULL,
		doctor_id int NOT NULL,
		review_date date NOT NULL,
		review_desc varchar (100),
		review_rating int, 
		CONSTRAINT PK_review_id PRIMARY KEY (review_id),
		CONSTRAINT FK_review_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
		CONSTRAINT FK_review_patient  FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
		CONSTRAINT FK_review_office  FOREIGN KEY (office_id) REFERENCES office(office_id)
	);




-- 8 patient_app TABLE CREATE --



DROP TABLE IF EXISTS patient_app CASCADE;

CREATE TABLE patient_app(
		patient_app_id serial,
		patient_id int,	
		appointment_id int, 
		CONSTRAINT PK_pa_id PRIMARY KEY (patient_app_id),
		CONSTRAINT FK_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
		CONSTRAINT FK_appointment_id FOREIGN KEY (appointment_id) REFERENCES appointment(appointment_id)
	
	);




-- 9 office_doctor_avail TABLE CREATE --



DROP TABLE IF EXISTS doctor_availability CASCADE;

CREATE TABLE doctor_availability(
		avail_id serial,
		office_id int,	
		day_of_week varchar(10),
		start_time timestamp,
		end_time timestamp,
		is_available boolean,
		reason_of_unavailability varchar(100),
		CONSTRAINT PK_avail_id PRIMARY KEY (avail_id),
		CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
	);

ROLLBACK;

COMMIT TRANSACTION;


