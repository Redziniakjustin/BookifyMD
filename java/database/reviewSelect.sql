SELECT (p.first_name || ' ' || p.last_name) as patient_name, o.office_name, ('Dr. ' || d.first_name || ' ' || d.last_name) as doctor_name, r.appointment_date, r.review_date, r.review_desc, r.review_rating 
FROM review as r
JOIN patient as p ON p.patient_id = r.patient_id
JOIN doctor as d ON d.doctor_id = r.doctor_id
JOIN office as o ON o.office_id = r.office_id;