BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
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


COMMIT TRANSACTION;

-- profile TABLE CREATE --

BEGIN TRANSACTION;

DROP TABLE IF EXISTS profile;

CREATE TABLE profile (
		contact_id serial,
		office_id int, 
		user_id int NOT NULL,
		first_name varchar NOT NULL,
		last_name varchar NOT NULL,
		phone int NOT NULL, 
		street_address varchar(100) NOT NULL, 
		city varchar(100),
		state_name varchar(100),
		zip varchar(15),
		email varchar(50) NOT NULL,
		is_doctor boolean,
		is_patient boolean, 
		cost_hourly int, 
		CONSTRAINT PK_profile PRIMARY KEY (contact_id),
		CONSTRAINT FK_profile_user FOREIGN KEY (user_id) REFERENCES users(user_id),
		CONSTRAINT FK_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
	);

ROLLBACK;

COMMIT TRANSACTION;


-- OFFICE TABLE CREATE --

BEGIN TRANSACTION;

DROP TABLE IF EXISTS office;

CREATE TABLE office (
		office_id serial,
		doctor_id int NOT NULL,
		office_name varchar(50) UNIQUE, 
		street_address varchar(100) NOT NULL, 
		city varchar(100),
		state_name varchar(100),
		zip varchar(15),
		email varchar(50) NOT NULL,
		office_hours time NOT NULL, 
		delay_status boolean,
		CONSTRAINT PK_office PRIMARY KEY (office_id)
	
	);
		


ROLLBACK;

COMMIT TRANSACTION;


-- appointments TABLE CREATE --

BEGIN TRANSACTION;

DROP TABLE IF EXISTS appointments;

CREATE TABLE appointments (
		appointment_id serial,
		doctor_id int NOT NULL,
		patient_id int NOT NULL,
		office_id int NOT NULL, 
		appointment_date varchar(20),
		appointment_status varchar(20),
		description varchar(50) NOT NULL, 
		reason_selected varchar(50), 
		CONSTRAINT PK_appointments PRIMARY KEY (appointment_id),
		CONSTRAINT FK_doctor_profile FOREIGN KEY (doctor_id) REFERENCES profile(contact_id),
		CONSTRAINT FK_patient_profile  FOREIGN KEY (patient_id) REFERENCES profile(contact_id),
		CONSTRAINT FK_office_profile  FOREIGN KEY (office_id) REFERENCES profile(contact_id)
		
	);

ROLLBACK;

COMMIT TRANSACTION;

-- Reviews TABLE CREATE --

BEGIN TRANSACTION;

DROP TABLE IF EXISTS review;

CREATE TABLE review (
		review_id serial,
		user_id int NOT NULL,
		office_id int NOT NULL,
		doctor_id int NOT NULL,
		review_date date NOT NULL,
		review_desc varchar (100),
		review_rating int, 
		CONSTRAINT PK_review_id PRIMARY KEY (review_id),
		CONSTRAINT FK_doctor_id FOREIGN KEY (doctor_id) REFERENCES profile(contact_id),
		CONSTRAINT FK_office FOREIGN KEY (office_id) REFERENCES office(office_id)
	);

ROLLBACK;

COMMIT TRANSACTION;







-- office_doctor_avail TABLE CREATE --

BEGIN TRANSACTION;

DROP TABLE IF EXISTS doctor_availability;

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

