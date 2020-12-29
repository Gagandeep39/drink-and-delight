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
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100001,'Union Street','Seattle','498106','Washington');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100002,'Stonepot Road','Newark','307102','New Jersey');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100003,'Adams Drive','Houston','177002','Texas');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100004,'Illinois Avenue','Tigard','397223','Oregon');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100005,'Hog Camp Road','La Grange','605251','Illinois');
INSERT INTO address (address_id, area, city, pincode, state) VALUES (100006,'West Fork Drive','CLEVELAND','441131','Ohio');

-- Dummy data for User detail
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100001, 'Gagandeep', 'Singh', 'Administrator', '1999-05-14', 'singh.gagandeep3911@gmail.com', 'Male', '8419969059', 'Default Question', 'answer', 100001);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100002, 'Stefani', 'Germanotta', 'Sales Manager', '1997-12-12', 'palak@mail.com', 'Female', '9876543210', 'Default Question', 'answer', 100002);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100003, 'Rhoda', 'Report', 'Marketing Lead', '1998-04-04', 'mama@mail.com', 'Female', '8877669059', 'Default Question', 'answer', 100003);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100004, 'Olive', 'Yew', 'Sales Team', '1995-05-11', 'john@mail.com', 'Male', '3443312345', 'Default Question', 'answer', 100004);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100005, 'Aida', 'Bugg', 'Sales Team', '1999-01-19', 'milo@mail.com', 'Female', '7576788679', 'Default Question', 'answer', 100005);
INSERT INTO user_details (user_details_id, first_name, last_name, designation, dob, email_id, gender, phone_no, security_question, security_answer, address_id) VALUES (100006, 'John', 'Doe', 'Sales Team', '1990-03-12', 'jenny@mail.com', 'Male', '9966553322', 'Default Question', 'answer', 100006);

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

-- SQL
-- UPDATE warehouse_id_sequence SET next_val = 100006;
-- H2
ALTER sequence warehouse_id_sequence restart with 1000006;

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


------------------ Supplier data  ------------------

INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000000, 'John Doe', 'Mumbai', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000001, 'Rajesh', 'Pune', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000002, 'Andy Hugh', 'Goa', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000003, 'Debby Aims', 'West Coast', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000004, 'Zara', 'U.S', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000005, 'Zedd', 'Mexico', '4455336677');


-- SQL
-- UPDATE supplier_id_sequence SET next_val = 100006;
-- H2
ALTER sequence supplier_id_sequence restart with 100006;

------------------ Distributor data  ------------------
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (1000000, 'John Doe', 'Mumbai', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (1000001, 'Rajesh', 'Pune', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (1000002, 'Andy Hugh', 'Goa', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (1000003, 'Debby Aims', 'West Coast', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (1000004, 'Zara', 'U.S', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (1000005, 'Zedd', 'Mexico', '4455336677');


-- SQL
-- UPDATE distributor_id_sequence SET next_val = 100006;
-- H2
ALTER sequence distributor_id_sequence restart with 100006;



INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000000, 55, 200, 'Passed', 'Delivered', '2019-05-15', '2025-12-12', '2019-05-11', 1000000, 1000000);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000002, 55, 200, 'Passed', 'Cancelled', '2019-05-15', '2024-11-12', '2019-05-11', 1000000, 1000000);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000003, 55, 200, 'Passed', 'Processing', '2019-05-15', '2025-06-12', '2019-05-11', 1000001, 1000001);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000004, 55, 200, 'Passed', 'Cancelled', '2019-05-15', '2025-03-12', '2019-05-11', 1000001, 1000001);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000005, 55, 200, 'Failed', 'Delivered', '2019-05-15', '2025-07-12', '2019-05-11', 1000002, 1000003);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000006, 55, 200, 'Failed', 'Delivered', '2019-05-15', '2025-02-12', '2019-05-11', 1000002, 1000002);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000007, 55, 200, 'Passed', 'Processing', '2019-05-15', '2025-12-12', '2019-05-11', 1000003, 1000004);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000008, 55, 200, 'Passed', 'Cancelled', '2019-05-15', '2025-12-12', '2019-05-11', 1000003, 1000001);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000009, 55, 200, 'Passed', 'Processing', '2019-05-15', '2025-11-12', '2019-05-11', 1000004, 1000005);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000010, 55, 200, 'Passed', 'Delivered', '2019-05-15', '2025-02-12', '2019-05-11', 1000004, 1000002);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000011, 55, 200, 'Passed', 'Delivered', '2019-05-15', '2025-12-12', '2019-05-11', 1000005, 1000003);
INSERT INTO raw_material_order (raw_material_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, expiry_date, ordered_on, supplier_id, raw_material_id) VALUES (1000012, 55, 200, 'Passed', 'Cancelled', '2019-05-15', '2025-02-12', '2019-05-11', 1000005, 1000004);

-- SQL
-- UPDATE raw_material_order_id_sequence SET next_val = 1000013;
-- H2
ALTER sequence raw_material_order_id_sequence restart with 1000013;


------------------ Distributor data  ------------------
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (100000, 'John Doe', 'Mumbai', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (100001, 'Rajesh', 'Pune', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (100002, 'Andy Hugh', 'Goa', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (100003, 'Debby Aims', 'West Coast', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (100004, 'Zara', 'U.S', '4455336677');
INSERT INTO distributor (distributor_id, name, location, phone_no) VALUES (100005, 'Zedd', 'Mexico', '4455336677');


-- SQL
-- UPDATE distributor_id_sequence SET next_val = 100006;
-- H2
ALTER sequence distributor_id_sequence restart with 100006;


------------------ Product data  ------------------
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100001,'Mango Juice','Parle Agro Mango Juice', 100,'Litre',1000001);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100002,'Grape Juice','Parle Agro Grape Juice', 2000,'Litre',1000001);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100003,'Watermelon Juice','Parle Agro Watermelon Juice', 10000,'Litre',1000002);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100004,'Banana Juice','Parle Agro Banana Juice', 3000,'Litre',1000002);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100005,'Papaya Juice','Parle Agro Papaya Juice', 2000,'Litre',1000003);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100006,'Chickoo Juice','Parle Agro Chickoo Juice', 1000,'Litre',1000003);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100007,'Tomatoes','Farm Fresh Tomatoes', 7000,'Kilogram',1000004);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100008,'Cucumber','Farm Fresh Cucumber', 800,'Kilogram',1000004);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100009,'Raddish','Farm Fresh Raddish', 90,'Kilogram',1000005);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100010,'BeetRoot','Farm Fresh BeetRoots', 900,'Kilogram',1000005);

-- SQL
-- UPDATE Product_id_sequence SET next_val = 100011;
-- H2
ALTER sequence product_id_sequence restart with 100011;

------------------ Product Order data  ------------------
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100001,80, 100,'Passed', 'Processing', '2020-12-12', '2019-05-13', '2025-09-09', '2020-09-09', 100001, 100001);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100002, 99, 2000,'Passed', 'Delivered', '2020-09-12', '2019-05-13', '2025-09-09', '2020-09-09', 100001, 100001);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100003, 87, 10000,'Passed', 'Delivered', '2020-09-15', '2019-05-13', '2025-09-09', '2020-09-09', 100002, 100002);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100004, 55, 3000,'Passed', 'Delivered', '2020-09-12', '2020-01-01', '2023-10-10', '2020-10-22', 100002, 100002);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100005, 30, 2000,'Failed', 'Delivered', '2020-09-19', '2020-01-01', '2025-09-09', '2020-10-22', 100003, 100003);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100006, 200, 88, 'Failed', 'Processing', '2020-12-12', '2020-01-01', '2023-10-10', '2020-09-12', 100003, 100003);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100007, 977, 90, 'Passed', 'Processing', '2020-12-12', '2019-12-12', '2025-09-09', '2020-10-22', 100004, 100004);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100008, 555, 800, 'Passed', 'Processing', '2020-12-16', '2020-02-02', '2023-10-10', '2020-10-22', 100004, 100004);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100009, 444, 90, 'Passed', 'Cancelled', '2020-05-12', '2020-02-02', '2023-10-10', '2020-09-12', 100005, 100005);
insert into product_order (product_order_id, quantity, price_per_unit, quality_check, order_status, delivery_date, manufacture_date, expiry_date, ordered_on, distributor_id,  product_id) values (100010, 333, 900,'Passed', 'Cancelled', '2020-05-12', '2020-02-02', '2023-10-10', '2020-09-12', 100005, 100005);

-- SQL
-- UPDATE Product_id_sequence SET next_val = 100011;
-- H2
ALTER sequence product_order_id_sequence restart with 100011;



