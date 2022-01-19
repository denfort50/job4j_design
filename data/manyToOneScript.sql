create table home_addresses(
    id serial primary key,
    city varchar(255),
    street varchar(255),
    house int,
    flat int 
);

create table persons(
    id serial primary key,
    name varchar(255),
    surname varchar(255),
    address_id int references home_addresses(id)
);

insert into home_addresses(city, street, house, flat) values ('Moscow', 'Profsoyuznaya', 83, 55);
insert into persons(name, surname, address_id) values ('Denis', 'Kalchenko', 1);
insert into persons(name, surname, address_id) values ('Anastasiya', 'Andrianova', 1);


select * from persons where address_id in (select address_id from persons);