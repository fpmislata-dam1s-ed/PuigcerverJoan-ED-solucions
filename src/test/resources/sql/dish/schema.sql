create table `dish` (
    id int primary key auto_increment,
    name varchar(255) not null,
    price decimal(10, 2) not null
);

create table `allergen` (
    id int primary key auto_increment,
    name varchar(255) not null
);

create table `dish_allergen` (
    dish_id int,
    allergen_id int,
    primary key (dish_id, allergen_id),
    foreign key (dish_id) references `dish`(id) on delete cascade,
    foreign key (allergen_id) references `allergen`(id) on delete cascade
);