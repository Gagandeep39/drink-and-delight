
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



INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000000, 'John Doe', 'Mumbai', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000001, 'Rajesh', 'Pune', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000002, 'Andy Hugh', 'Goa', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000003, 'Debby Aims', 'West Coast', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000004, 'Zara', 'U.S', '4455336677');
INSERT INTO supplier (supplier_id, name, location, phone_no) VALUES (1000005, 'Zedd', 'Mexico', '4455336677');


-- SQL
-- UPDATE supplier_id_sequence SET next_val = 100005;
-- H2
-- ALTER sequence supplier_id_sequence restart with 100005;


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
