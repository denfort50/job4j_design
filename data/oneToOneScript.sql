create table driving_licenses(
    id serial primary key,
    seria int,
    number int
);

create table persons(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255),
    driving_license_id int references driving_licenses(id) unique
);

insert into driving_licenses(seria, number) values (5468, 987236);
insert into driving_licenses(seria, number) values (9234, 827946);

insert into persons(first_name, last_name, driving_license_id) values ('Denis', 'Kalchenko', 1);
insert into persons(first_name, last_name, driving_license_id) values ('Anastasiya', 'Andrianova', 2);

select * from driving_licenses
where id = (select driving_license_id from persons where last_name = 'Kalchenko');
