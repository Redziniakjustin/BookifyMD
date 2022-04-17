SELECT o.office_id
FROM office as o
JOIN review as r ON r.office_id = o.office_id
WHERE o.office_name = ?;


SELECT d.doctor_id
FROM doctor as d
JOIN review as r ON r.doctor_id = d.doctor_id
WHERE d.first_name = ? AND d.last_name = ?;


SELECT p.patient_id
FROM patient as p
JOIN review as r ON r.patient_id = p.patient_id
WHERE p.first_name = ? AND p.last_name = ?;


SELECT d.doctor_id FROM doctor as d WHERE d.first_name = ? AND d.last_name = ?;