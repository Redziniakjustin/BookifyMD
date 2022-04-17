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



DROP TABLE IF EXISTS user_type CASCADE;

CREATE TABLE user_type(
		
		user_type_id serial, 
		user_id int UNIQUE,
		is_doctor boolean NOT NULL,
		CONSTRAINT PK_user_type_id PRIMARY KEY (user_type_id),
		CONSTRAINT FK_user_type_user FOREIGN KEY (user_id) REFERENCES users(user_id)
			
	);

DROP TABLE IF EXISTS doctor CASCADE;

CREATE TABLE doctor (
		doctor_id serial,
		user_type_id int NOT NULL,
		first_name varchar NOT NULL,
		last_name varchar NOT NULL,
		phone varchar(20) NOT NULL, 
		email varchar(50) NOT NULL,
		cost_hourly int, 
		CONSTRAINT PK_doctor_id PRIMARY KEY (doctor_id),
		CONSTRAINT FK_doctor_user_type FOREIGN KEY (user_type_id) REFERENCES user_type(user_type_id)
	);


DROP TABLE IF EXISTS office CASCADE;

CREATE TABLE office (
		office_id serial,
		office_name varchar(100) UNIQUE, 
		street_address varchar(100) NOT NULL, 
		city varchar(100),
		state_name varchar(100),
		zip varchar(15),
		phone varchar(20) NOT NULL,
		email varchar(50) NOT NULL,
		office_hours_start time NOT NULL DEFAULT '09:00:00',
		office_hours_end time NOT NULL DEFAULT '17:00:00',
		delay_status boolean,
		CONSTRAINT PK_office PRIMARY KEY (office_id)
	
	);
	

DROP TABLE IF EXISTS patient CASCADE; 

CREATE TABLE patient (
		patient_id serial,
		user_type_id int NOT NULL,
		first_name varchar NOT NULL,
		last_name varchar NOT NULL,
		phone varchar(20) NOT NULL, 
		street_address varchar(100) NOT NULL, 
		city varchar(100),
		state_name varchar(100),
		zip varchar(15),
		email varchar(50) NOT NULL,
		CONSTRAINT PK_patient_id PRIMARY KEY (patient_id),
		CONSTRAINT FK_user_type_id FOREIGN KEY (user_type_id) REFERENCES user_type(user_type_id)
	);



DROP TABLE IF EXISTS appointment cascade; 

CREATE TABLE appointment (
		appointment_id serial,
		doctor_id int NOT NULL,
		patient_id int NOT NULL,
		office_id int NOT NULL,
		avail_id int NOT NULL,
		appointment_date date NOT NULL,
		--start_time time NOT NULL,
		--end_end time NOT NULL,
		appointment_status varchar(20),
		description varchar(150) NOT NULL,
		--CONSTRAINT PK_appointment PRIMARY KEY (appointment_id),
		PRIMARY KEY (doctor_id, office_id, avail_id, appointment_date),
		
		CONSTRAINT FK_appointments_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
		CONSTRAINT FK_appointments_patient  FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
		CONSTRAINT FK_appointments_office  FOREIGN KEY (office_id) REFERENCES office(office_id)
		
	);


DROP TABLE IF EXISTS doctor_office CASCADE;

CREATE TABLE doctor_office(
		doctor_office_id serial,
		doctor_id int,	
		office_id int, 
		CONSTRAINT PK_doctor_office_id PRIMARY KEY (doctor_office_id),
		CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
		CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
	
	);

DROP TABLE IF EXISTS review CASCADE;

CREATE TABLE review (
		review_id serial,
		--appointment_id int,
		doctor_id int NOT NULL,
		patient_id int NOT NULL,
		office_id int NOT NULL,
		avail_id int NOT NULL,
		appointment_date date NOT NULL,
		review_date date NOT NULL,
		review_desc varchar (280),
		review_rating int,
		CONSTRAINT PK_review_id PRIMARY KEY (review_id),
		CONSTRAINT FK_appointment_id FOREIGN KEY (doctor_id, office_id, avail_id, appointment_date) REFERENCES appointment(doctor_id, office_id, avail_id, appointment_date)
	);



DROP TABLE IF EXISTS doctor_office_availability CASCADE;


CREATE TABLE doctor_office_availability(
	avail_id serial,
	office_id int,
	doctor_id int,
	day_of_week varchar(10),
	start_time time,
	end_time time,
	is_available boolean,
	reason_of_unavailability varchar(100),
	CONSTRAINT PK_avail_id PRIMARY KEY (avail_id),
	CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
	);



-- ALTER TABLE office ADD 	CONSTRAINT FK_doctor_avail FOREIGN KEY (avail_id) REFERENCES doctor_office_availability(avail_id);
-- ALTER TABLE office ADD	CONSTRAINT FK_office_doctor_office FOREIGN KEY (doctor_id) REFERENCES doctor_office(doctor_office_id);

--ROLLBACK;

COMMIT TRANSACTION;



