insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('person', 1);
insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('address', 1);
insert into hibernate_sequences (sequence_name, sequence_next_hi_value) values ('payment', 1);

insert into item (id, category, description, name) values (1, '1', 'Chole', 'Chole');
insert into item (id, category, description, name) values (2, '1', 'Wange/Brinjle', 'Wange/Brinjle');
insert into item (id, category, description, name) values (3, '1', 'Plain daal', 'Plain daal');
insert into item (id, category, description, name) values (4, '1', 'Daal fry', 'Daal fry');
insert into item (id, category, description, name) values (5, '1', 'Dum Aloo', 'Dum Aloo');
insert into item (id, category, description, name) values (6, '1', 'Paneer kalimirch', 'Paneer kalimirch');
insert into item (id, category, description, name) values (7, '1', 'Tindli Masala', 'Tindli Masala');
insert into item (id, category, description, name) values (8, '2', 'Plain Rice', 'Plain Rice');
insert into item (id, category, description, name) values (9, '2', 'Jeera Rice', 'Jeera Rice');
insert into item (id, category, description, name) values (10, '2', 'Brown Rice', 'Brown Rice');
insert into item (id, category, description, name) values (11, '3', 'Phulka', 'Phulka');
insert into item (id, category, description, name) values (12, '3', 'Phulka with ghee', 'Phulka with ghee');
insert into item (id, category, description, name) values (13, '3', 'Multigrain roti', 'Multigrain roti');
insert into item (id, category, description, name) values (14, '3', 'Bajri', 'Bajri');
insert into item (id, category, description, name) values (15, '3', 'Pav', 'Pav');
insert into item (id, category, description, name) values (16, '4', 'Salad', 'Salad');
insert into item (id, category, description, name) values (17, '4', 'Roasted Papad', 'Roasted Papad');
insert into item (id, category, description, name) values (18, '4', 'Mango pickle', 'Mango pickle');
insert into item (id, category, description, name) values (19, '4', 'Mixed pickle', 'Mixed pickle');
insert into item (id, category, description, name) values (20, '4', 'Green Chutney', 'Green Chutney');
insert into item (id, category, description, name) values (21, '4', 'Tomato Ketchup', 'Tomato Ketchup');

insert into address (id, lattitude, longitude, area,  address_line2) values (1, '23.02486', '113.74373', '1',  'Samarth Complex');
insert into address (id, lattitude, longitude, area,  address_line2) values (2, '23.02486', '113.74373', '1',  'JD Complex');
insert into address (id, lattitude, longitude, area,  address_line2) values (3, '23.02486', '113.74373', '0',  'F.No 101, Siddhi Apt');
insert into address (id, lattitude, longitude, area,  address_line2) values (4, '23.02486', '113.74373', '0',  'F.No 102, Siddhi Apt');
insert into address (id, lattitude, longitude, area,  address_line2) values (5, '23.02486', '113.74373', '0',  'F.No 103, Siddhi Apt');
insert into address (id, lattitude, longitude, area,  address_line2) values (6, '23.02486', '113.74373', '0',  'F.No 104, Siddhi Apt');
insert into address (id, lattitude, longitude, area,  address_line2) values (7, '23.02486', '113.74373', '0',  'F.No 105, Siddhi Apt');


insert into owner (id, first_name, last_name, email_id, mobile_no, owner_address) values (1, 'Parag', 'Upadhay', 'parag@gmail.com', '9898989898', '1');
insert into owner (id, first_name, last_name, email_id, mobile_no, owner_address) values (2, 'Pawan', 'Upadhay', 'pawan@gmail.com', '7878787878', '2');

insert into vendor_account (id, is_provide_custom_service, manager_mob_no, penalty_percentage, registration_date, subscribe_threshold, un_subscribe_threshold) values (1, 1, '9898989898', '25', '2015-08-05', '360000', '360000');
insert into vendor_account (id, is_provide_custom_service, manager_mob_no, penalty_percentage, registration_date, subscribe_threshold, un_subscribe_threshold) values (2, 1, '9898989898', '25', '2015-08-05', '360000', '360000');


insert into vendor (id, mess_name, reception_no, email_id, owner, vendor_address,vendor_account) values (1, 'Parag Mess', '4545454545', 'paragmess@gmail.com', '1', '1','1');
insert into vendor (id, mess_name, reception_no, email_id, owner, vendor_address,vendor_account) values (2, 'Pawan Mess', '4545454546', 'pawanmess@gmail.com', '2', '2','2');


insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (1, '20', '3', '0', 1, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (2, '20', '3', '0', 2, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (3, '20', '3', '0', 3, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (4, '20', '3', '0', 4, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (5, '20', '3', '0', 5, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (6, '20', '3', '0', 6, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (7, '20', '3', '0', 7, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (8, '20', '3', '0', 8, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (9, '20', '3', '0', 9, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (10, '20', '3', '0', 10, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (11, '20', '3', '0', 11, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (12, '20', '3', '0', 12, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (13, '20', '3', '0', 13, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (14, '20', '3', '0', 14, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (15, '20', '3', '0', 15, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (16, '20', '3', '0', 16, '1');
insert into vendor_item (id, cost, rating, unit, item, vendor_account) values (17, '20', '3', '0', 17, '1');


insert into meal_item (id, count, vendor_item) values (1, '1', '1');
insert into meal_item (id, count, vendor_item) values (2, '1', '2');
insert into meal_item (id, count, vendor_item) values (3, '1', '3');
insert into meal_item (id, count, vendor_item) values (4, '1', '4');
insert into meal_item (id, count, vendor_item) values (5, '1', '5');
insert into meal_item (id, count, vendor_item) values (6, '1', '6');
insert into meal_item (id, count, vendor_item) values (7, '1', '7');
insert into meal_item (id, count, vendor_item) values (8, '1', '8');
insert into meal_item (id, count, vendor_item) values (9, '1', '9');
insert into meal_item (id, count, vendor_item) values (10, '1', '10');
insert into meal_item (id, count, vendor_item) values (11, '3', '11');
insert into meal_item (id, count, vendor_item) values (12, '3', '12');
insert into meal_item (id, count, vendor_item) values (13, '3', '13');
insert into meal_item (id, count, vendor_item) values (14, '3', '14');
insert into meal_item (id, count, vendor_item) values (15, '3', '15');
insert into meal_item (id, count, vendor_item) values (16, '1', '16');

insert into meal (id, name, description, is_vegeterian, vendor_account) values (1, 'RicePlate1', 'RicePlate1', 0, '1');
insert into meal (id, name, description, is_vegeterian, vendor_account) values (2, 'RicePlate2', 'RicePlate1', 0, '1');
insert into meal (id, name, description, is_vegeterian, vendor_account) values (3, 'RicePlate3', 'RicePlate1', 0, '1');

insert into meal_meal_items (meal, meal_items) values ('1', '1');
insert into meal_meal_items (meal, meal_items) values ('1', '9');
insert into meal_meal_items (meal, meal_items) values ('1', '11');
insert into meal_meal_items (meal, meal_items) values ('1', '16');

insert into meal_meal_items (meal, meal_items) values ('2', '2');
insert into meal_meal_items (meal, meal_items) values ('2', '10');
insert into meal_meal_items (meal, meal_items) values ('2', '12');
insert into meal_meal_items (meal, meal_items) values ('2', '16');

insert into meal_meal_items (meal, meal_items) values ('3', '3');
insert into meal_meal_items (meal, meal_items) values ('3', '11');
insert into meal_meal_items (meal, meal_items) values ('3', '13');
insert into meal_meal_items (meal, meal_items) values ('3', '16');


insert into mess_deck_offering (id, capacity_of_members, cost, effective_from, effective_till, start_time, end_time, is_customizable, is_unlimited, is_vegeterian, penalty_percentage, service_type, subscribe_threshold, un_subscribe_threshold, vendor_account) values (1, '50', '60', '2015-08-05', '2099-08-05', '12:00:00', '14:00:00', 0, 0, 0, '25', '0', '120000', '120000', '1');
insert into mess_deck_offering (id, capacity_of_members, cost, effective_from, effective_till, start_time, end_time, is_customizable, is_unlimited, is_vegeterian, penalty_percentage, service_type, subscribe_threshold, un_subscribe_threshold, vendor_account) values (2, '50', '60', '2015-08-05', '2099-08-05', '12:00:00', '14:00:00', 0, 0, 0, '25', '1', '120000', '120000', '1');
insert into mess_deck_offering (id, capacity_of_members, cost, effective_from, effective_till, start_time, end_time, is_customizable, is_unlimited, is_vegeterian, penalty_percentage, service_type, subscribe_threshold, un_subscribe_threshold, vendor_account) values (3, '50', '60', '2015-08-05', '2099-08-05', '20:00:00', '22:00:00', 0, 0, 0, '25', '2', '120000', '120000', '1');
insert into mess_deck_offering (id, capacity_of_members, cost, effective_from, effective_till, start_time, end_time, is_customizable, is_unlimited, is_vegeterian, penalty_percentage, service_type, subscribe_threshold, un_subscribe_threshold, vendor_account) values (4, '50', '60', '2015-08-05', '2099-08-05', '12:00:00', '14:00:00', 0, 0, 0, '25', '0', '120000', '120000', '2');
insert into mess_deck_offering (id, capacity_of_members, cost, effective_from, effective_till, start_time, end_time, is_customizable, is_unlimited, is_vegeterian, penalty_percentage, service_type, subscribe_threshold, un_subscribe_threshold, vendor_account) values (5, '50', '60', '2015-08-05', '2099-08-05', '12:00:00', '14:00:00', 0, 0, 0, '25', '1', '120000', '120000', '2');
insert into mess_deck_offering (id, capacity_of_members, cost, effective_from, effective_till, start_time, end_time, is_customizable, is_unlimited, is_vegeterian, penalty_percentage, service_type, subscribe_threshold, un_subscribe_threshold, vendor_account) values (6, '50', '60', '2015-08-05', '2099-08-05', '20:00:00', '22:00:00', 0, 0, 0, '25', '2', '120000', '120000', '2');

insert into mess_deck_offering_instance (id, capacity_of_members, service_date, meal, mess_deck_service) values (1, '50', '2015-08-05', 1, 1);
insert into mess_deck_offering_instance (id, capacity_of_members, service_date, meal, mess_deck_service) values (2, '50', '2015-08-06', 2, 1);
insert into mess_deck_offering_instance (id, capacity_of_members, service_date, meal, mess_deck_service) values (3, '50', '2015-08-07', 3, 1);
insert into mess_deck_offering_instance (id, capacity_of_members, service_date, meal, mess_deck_service) values (4, '50', '2015-08-08', 1, 1);
insert into mess_deck_offering_instance (id, capacity_of_members, service_date, meal, mess_deck_service) values (5, '50', '2015-08-09', 2, 1);



insert into customer_account (id, balance, customer_account_status) values (1001, '450', 0);
insert into customer_account (id, balance, customer_account_status) values (1002, '230', 0);
insert into customer_account (id, balance, customer_account_status) values (1003, '177', 0);
insert into customer_account (id, balance, customer_account_status) values (1004, '177', 0);
insert into customer_account (id, balance, customer_account_status) values (1005, '450', 0);



insert into customer (id, first_name, last_name, email_id, gender, customer_account, mobile_no) values (1001, 'Judy', 'Chavez', 'jchavez0@marriott.com', 1, 1001, '9296248187');
insert into customer (id, first_name, last_name, email_id, gender, customer_account, mobile_no) values (1002, 'Nicole', 'Ferguson', 'nferguson1@artisteer.com', 0, 1002, '9296248187');
insert into customer (id, first_name, last_name, email_id, gender, customer_account, mobile_no) values (1003, 'Denise', 'Clark', 'dclark2@joomla.org', 0, 1003, '9296248187');
insert into customer (id, first_name, last_name, email_id, gender, customer_account, mobile_no) values (1004, 'Elizabeth', 'Sanchez', 'esanchez3@china.com.cn', 1, 1004, '9296248187');
insert into customer (id, first_name, last_name, email_id, gender, customer_account, mobile_no) values (1005, 'Cynthia', 'Crawford', 'ccrawford4@patch.com', 1, 1005, '9296248187');


insert into hard_cash_payment (id, amount, recived_by, customer_account, vendor_account, time_stamp) values (1, 450, 'Parag', 1001, 1, '2015-08-05');
insert into hard_cash_payment (id, amount, recived_by, customer_account, vendor_account, time_stamp) values (2, 230, 'Parag', 1002, 1, '2015-08-05');
insert into hard_cash_payment (id, amount, recived_by, customer_account, vendor_account, time_stamp) values (3, 177, 'Parag', 1003, 1, '2015-08-05');
insert into hard_cash_payment (id, amount, recived_by, customer_account, vendor_account, time_stamp) values (4, 177, 'Parag', 1004, 1, '2015-08-05');
insert into hard_cash_payment (id, amount, recived_by, customer_account, vendor_account, time_stamp) values (5, 450, 'Parag', 1005, 1, '2015-08-05');

insert into customer_payement (id, amount, timestamp, customer_account, payment) values (1, 450, '2015-08-05', 1001, 1);
insert into customer_payement (id, amount, timestamp, customer_account, payment) values (2, 230, '2015-08-05', 1002, 2);
insert into customer_payement (id, amount, timestamp, customer_account, payment) values (3, 177, '2015-08-05', 1003, 3);
insert into customer_payement (id, amount, timestamp, customer_account, payment) values (4, 177, '2015-08-05', 1004, 4);
insert into customer_payement (id, amount, timestamp, customer_account, payment) values (5, 450, '2015-08-05', 1005, 5);

insert into customer_order (id, is_customized, status, total_cost, customer_account, mess_deck_service_instance) values (1, 0, '3', '80', '1001', 1);
insert into customer_order_line_items (customer_order, vendor_item, count, cost) values ('1', 9, '1', '20');
insert into customer_order_line_items (customer_order, vendor_item, count, cost) values ('1', 16, '1', '20');
insert into customer_order_line_items (customer_order, vendor_item, count, cost) values ('1', 11, '1', '20');
insert into customer_order_line_items (customer_order, vendor_item, count, cost) values ('1', 1, '1', '20');