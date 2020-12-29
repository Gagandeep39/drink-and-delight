-- Dummy data for User Table
-- Default password: 123456
INSERT INTO user (user_id, password, username, role) VALUES (100001,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'gagan', 'Admin');
INSERT INTO user (user_id, password, username, role) VALUES (100002,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'stefani', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100003,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'rhoda', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100004,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'olive', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100005,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'aida', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100006,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'john', 'User');

-- Dummy data for Address
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100001,'Union Street','Seattle','198106','Washington');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100002,'Stonepot Road','Newark','307102','New Jersey');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100003,'Adams Drive','Houston','477002','Texas');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100004,'Illinois Avenue','Tigard','597223','Oregon');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100005,'Hog Camp Road','La Grange','660525','Illinois');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100006,'West Fork Drive','CLEVELAND','744113','Ohio');

-- Dummy data for User detail
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100001, 'Gagandeep', 'Singh', 'Administrator', '1999-05-14', 'singh.gagandeep3911@gmail.com', 'Male', '8419969059', 'Default Question', 'answer', 100001);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100002, 'Stefani', 'Germanotta', 'Sales Manager', '1997-12-12', 'palak@mail.com', 'Female', '9876543210', 'Default Question', 'answer', 100002);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100003, 'Rhoda', 'Report', 'Marketing Lead', '1998-04-04', 'pragya@mail.com', 'Female', '8877669059', 'Default Question', 'answer', 100003);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100004, 'Olive', 'Yew', 'Sales Team', '1995-05-11', 'rushikesh@mail.com', 'Male', '3443312345', 'Default Question', 'answer', 100004);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100005, 'Aida', 'Bugg', 'Sales Team', '1999-01-19', 'sulekha@mail.com', 'Female', '7576788679', 'Default Question', 'answer', 100005);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100006, 'John', 'Doe', 'Sales Team', '1990-03-12', 'raghav@mail.com', 'Male', '9966553322', 'Default Question', 'answer', 100006);

-- MYSQL sequence
-- UPDATE user_id_sequence SET next_val = 100007;
-- UPDATE address_id_sequence SET next_val = 100007;
-- H2 sequence 
ALTER sequence user_id_sequence restart with 100007;
ALTER sequence address_id_sequence restart with 100007;
