------------------ USER Data ------------------

-- Dummy data for User Table
-- Default password: 123456
INSERT INTO user (user_id, password, username, role) VALUES (100001,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'gagan', 'Admin');
INSERT INTO user (user_id, password, username, role) VALUES (100002,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'stefani', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100003,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'rhoda', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100004,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'olive', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100005,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'aida', 'User');
INSERT INTO user (user_id, password, username, role) VALUES (100006,'$2a$10$B4FvjVc2oXqDTFdGGZjT5urzHS6TSdzrQ7p/vFi1rUuZgjXR4.m5K', 'john', 'User');

-- Dummy data for Address
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100001,'Union Street','Seattle','98106','Washington');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100002,'Stonepot Road','Newark','07102','New Jersey');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100003,'Adams Drive','Houston','77002','Texas');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100004,'Illinois Avenue','Tigard','97223','Oregon');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100005,'Hog Camp Road','La Grange','60525','Illinois');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100006,'West Fork Drive','CLEVELAND','44113','Ohio');

-- Dummy data for User detail
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100001, 'Gagandeep', 'Singh', 'Administrator', '1999-05-14', 'singh.gagandeep3911@gmail.com', 'Male', '8419969059', 'Default Question', 'answer', 100001);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100002, 'Stefani', 'Germanotta', 'Sales Manager', '1997-12-12', 'palak@mail.com', 'Female', '9876543210', 'Default Question', 'answer', 100002);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100003, 'Rhoda', 'Report', 'Marketing Lead', '1998-04-04', 'pragya@mail.com', 'Female', '8877669059', 'Default Question', 'answer', 100003);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100004, 'Olive', 'Yew', 'Sales Team', '1995-05-11', 'rushikesh@mail.com', 'Male', '3443312345', 'Default Question', 'answer', 100004);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100005, 'Aida', 'Bugg', 'Sales Team', '1999-01-19', 'sulekha@mail.com', 'Female', '7576788679', 'Default Question', 'answer', 100005);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100006, 'John', 'Doe', 'Sales Team', '1990-03-12', 'raghav@mail.com', 'Male', '9966553322', 'Default Question', 'answer', 100006);

-- MYSQL sequence
-- UPDATE user_id_sequence SET next_val = 100021;
-- H2 sequence
ALTER sequence user_id_sequence restart with 100007;
ALTER sequence address_id_sequence restart with 100007;

INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000000, 'Mumbai', 'Near Harbor');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000001, 'Daman and Diu', 'Island');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000002, 'Goa', 'Near Harbor');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000003, 'Delhi', 'Airport');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000004, 'Frankfurt', 'East Coast');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000005, 'Mexico', 'Mexico');

------------------ Raw Material Data ------------------

-- SQL
-- UPDATE warehouse_id_sequence SET next_val = 100006;
-- H2
ALTER sequence warehouse_id_sequence restart with 100006;

INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000000, 'Sugar', 'Sweet and Solid product', 60, 'Kilogram', 1000000);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000001, 'Cream', 'Milk based product', 70, 'Litre', 1000000);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000002, 'Milk', 'A health item', 100, 'Litre', 1000001);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000003, 'Choco Chips', 'Made from Coffee', 80, 'Kilogram', 1000001);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000004, 'Salt', 'Sour in taste', 22, 'Kilogram', 1000002);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000005, 'Vanilla Extract', 'Adds Essence', 55, 'Litre', 1000002);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000006, 'Syrub', 'Sweet and tasty', 70, 'Litre', 1000003);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000007, 'Chocolate', 'Made from Coffee beans', 80, 'Kilogram', 1000003);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000008, 'Lemons', 'Fruit', 90, 'Kilogram', 1000004);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000009, 'Orange', 'Fruit', 88, 'Kilogram', 1000004);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000010, 'Strawberry', 'Fruit', 76, 'Kilogram', 1000005);
INSERT INTO raw_material (raw_material_id, material_name, description, quantity_available, quantity_unit, warehouse_id) VALUES (1000011, 'Kiwi', 'Fruit', 20, 'Kilogram', 1000005);

-- SQL
-- UPDATE rawmaterial_id_sequence SET next_val = 100012;
-- H2
-- ALTER sequence rawmaterial_id_sequence restart with 100012;



INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000000, 'john Doe', 'Germany', '4455336677');

-- SQL
-- UPDATE supplier_id_sequence SET next_val = 100005;
-- H2
-- ALTER sequence supplier_id_sequence restart with 100005;


INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, measurement_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000000, 55, 200, 'Kilogram', 'Passed', 'Delivered', '2019-05-15', '2025-12-12', '2019-05-11', 1000000, 1000000);

