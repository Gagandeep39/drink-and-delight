------------------ Warehouse Data ------------------
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000000, 'Mumbai', 'Near Harbor');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000001, 'Daman and Diu', 'Island');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000002, 'Goa', 'Near Harbor');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000003, 'Delhi', 'Airport');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000004, 'Frankfurt', 'East Coast');
INSERT INTO warehouse (warehouse_id, name, description) VALUES (1000005, 'Mexico', 'Mexico');



-- SQL
-- UPDATE warehouse_id_sequence SET next_val = 100006;
-- H2
ALTER sequence warehouse_id_sequence restart with 100006;

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
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100007,'Tomatoes','Farm Fresh Tomatoes', 7000,'Passed',1000004);
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


