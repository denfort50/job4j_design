create table bodies(
	id serial primary key,
	name varchar(255)
);

create table engines(
	id serial primary key,
	name varchar(255),
	volume float,
	horse_powers int
);

create table transmissions(
	id serial primary key,
	type varchar(255)
);

create table cars(
	id serial primary key,
	model varchar(255),
	brand varchar(255),
	body_id int references bodies(id),
	engine_id int references engines(id),
	transmission_id int references transmissions(id)
);

insert into bodies(name) values ('sedan');
insert into bodies(name) values ('hatchback');
insert into bodies(name) values ('station wagon');
insert into bodies(name) values ('cabriolet');
insert into bodies(name) values ('pickup');
insert into bodies(name) values ('minivan');
insert into bodies(name) values ('coupe');
insert into bodies(name) values ('off-road car');
insert into bodies(name) values ('roadster');
insert into bodies(name) values ('crossover');
insert into bodies(name) values ('sportback');

insert into engines(name, volume, horse_powers) values('x1', 1.6, 120);
insert into engines(name, volume, horse_powers) values('x2', 1.8, 145);
insert into engines(name, volume, horse_powers) values('x3', 2.0, 170);
insert into engines(name, volume, horse_powers) values('x4', 2.5, 181);
insert into engines(name, volume, horse_powers) values('x5', 3.0, 215);
insert into engines(name, volume, horse_powers) values('x6', 3.5, 249);
insert into engines(name, volume, horse_powers) values('x7', 4.5, 235);
insert into engines(name, volume, horse_powers) values('x8', 4.8, 335);
insert into engines(name, volume, horse_powers) values('x9', 5.5, 450);

insert into transmissions(type) values('manual');
insert into transmissions(type) values('automatic');
insert into transmissions(type) values('robotic');
insert into transmissions(type) values('variator');

insert into cars(model, brand, body_id, engine_id, transmission_id) values ('Camry', 'Toyota', 1, 6, 2);
insert into cars(model, brand, body_id, engine_id, transmission_id) values ('Land Cruiser 200', 'Toyota', 8, 7, 2);
insert into cars(model, brand, body_id, engine_id, transmission_id) values ('F-150 Raptor', 'Ford', 5, 9, 2);
insert into cars(model, brand, body_id, engine_id, transmission_id) values ('Octavia', 'Skoda', 1, 3, 3);
insert into cars(model, brand, body_id, engine_id, transmission_id) values ('Starex', 'Hyundai', 6, 5, 1);
insert into cars(model, brand, body_id, engine_id, transmission_id) values ('Panamera', 'Porsche', 11, 8, 3);

-- Список всех машин и все привязанные к ним детали
select c.model, c.brand, b.name body, e.name engine, e.volume, e.horse_powers, t.type from cars c
join bodies b on c.body_id = b.id
join engines e on c.engine_id = e.id
join transmissions t on c.transmission_id = t.id;

-- Кузова, которые не используются НИ в одной машине
select b.name body from bodies b
left join cars c on b.id = c.body_id
where c.body_id is null;

-- Двигатели, которые не используются НИ в одной машине
select e.name engine from engines e
left join cars c on e.id = c.engine_id
where c.engine_id is null;

-- Коробки передач, которые не используются НИ в одной машине
select t.type from transmissions t
left join cars c on t.id = c.transmission_id
where c.transmission_id is null;
