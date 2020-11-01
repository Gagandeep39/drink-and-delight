------------------ Warehouse data  ------------------
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
