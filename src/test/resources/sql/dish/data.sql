insert into `dish` (id, name, price) values (1, 'Spaghetti Carbonara', 12.50);
insert into `dish` (id, name, price) values (2, 'Margherita Pizza', 10.00);
insert into `dish` (id, name, price) values (3, 'Caesar Salad', 8.00);

insert into `allergen` (id, name) values (1, 'Gluten');
insert into `allergen` (id, name) values (2, 'Dairy');
insert into `allergen` (id, name) values (3, 'Eggs');

insert into `dish_allergen` (dish_id, allergen_id) values (1, 1);
insert into `dish_allergen` (dish_id, allergen_id) values (1, 2);
insert into `dish_allergen` (dish_id, allergen_id) values (1, 3);
insert into `dish_allergen` (dish_id, allergen_id) values (2, 1);
insert into `dish_allergen` (dish_id, allergen_id) values (2, 2);
insert into `dish_allergen` (dish_id, allergen_id) values (3, 2);