create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('iPhone 10', 600);
insert into devices(name, price) values ('iPhone 11', 700);
insert into devices(name, price) values ('iPhone 12', 800);
insert into devices(name, price) values ('iPhone 13', 900);
insert into devices(name, price) values ('Google Pixel 3', 200);
insert into devices(name, price) values ('A', 1000);
insert into devices(name, price) values ('B', 2000);
insert into devices(name, price) values ('C', 46000);
insert into devices(name, price) values ('D', 6000);
insert into devices(name, price) values ('E', 500);
insert into devices(name, price) values ('F', 4780);
insert into devices(name, price) values ('G', 97630);
insert into devices(name, price) values ('H', 9000);
insert into devices(name, price) values ('I', 60080);
insert into devices(name, price) values ('J', 7400);

insert into people (name) values ('Denis');
insert into people (name) values ('John');
insert into people (name) values ('Tomas');
insert into people (name) values ('Nastya');
insert into people (name) values ('Alex');

insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 4);
insert into devices_people(device_id, people_id) values (4, 5);
insert into devices_people(device_id, people_id) values (5, 1);
insert into devices_people(device_id, people_id) values (6, 1);
insert into devices_people(device_id, people_id) values (7, 2);
insert into devices_people(device_id, people_id) values (8, 3);
insert into devices_people(device_id, people_id) values (9, 4);
insert into devices_people(device_id, people_id) values (10, 5);
insert into devices_people(device_id, people_id) values (11, 5);
insert into devices_people(device_id, people_id) values (12, 4);
insert into devices_people(device_id, people_id) values (13, 1);
insert into devices_people(device_id, people_id) values (14, 2);
insert into devices_people(device_id, people_id) values (15, 3);

-- Средняя цена устройств
select round(cast(avg(d.price) as numeric), 0) СРЕДНЯЯ_ЦЕНА from devices d;

-- Средняя цена устройств для каждого человека
select p.name ИМЯ, round(cast(avg(d.price) as numeric), 0) СРЕДНЯЯ_ЦЕНА from devices d
join devices_people dp on d.id = dp.device_id
join people p on p.id = people_id
group by p.name;

-- Средняя цена устройств для каждого человека, которая больше 5000
select p.name ИМЯ, round(cast(avg(d.price) as numeric), 0) СРЕДНЯЯ_ЦЕНА from devices d
join devices_people dp on d.id = dp.device_id
join people p on p.id = people_id
group by p.name
having avg(d.price) > 5000;
