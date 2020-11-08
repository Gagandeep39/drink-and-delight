
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


------------------ Product data  ------------------
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100001,'Mango Juice','Parle Agro Mango Juice', 100,'Litre',1000001);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100002,'Grape Juice','Parle Agro Grape Juice', 2000,'Litre',1000001);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100003,'Watermelon Juice','Parle Agro Watermelon Juice', 10000,'Litre',1000002);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100004,'Banana Juice','Parle Agro Banana Juice', 3000,'Litre',1000002);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100005,'Papaya Juice','Parle Agro Papaya Juice', 2000,'Litre',1000003);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100006,'Chickoo Juice','Parle Agro Chickoo Juice', 1000,'Litre',1000003);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100007,'Tomatoes','Farm Fresh Tomatoes', 7000,'Litre',1000004);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100008,'Cucumber','Farm Fresh Cucumber', 800,'Kilogram',1000004);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100009,'Raddish','Farm Fresh Raddish', 90,'Kilogram',1000005);
insert into product (product_id, material_name, description, quantity_available, quantity_unit, warehouse_id) values (100010,'BeetRoot','Farm Fresh BeetRoots', 900,'Kilogram',1000005);

-- SQL
-- UPDATE Product_id_sequence SET next_val = 100011;
-- H2
ALTER sequence product_id_sequence restart with 100011;
