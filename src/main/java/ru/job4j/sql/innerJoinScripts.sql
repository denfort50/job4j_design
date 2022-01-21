create table cars(
	id serial primary key,
	model varchar(255),
	manufacturer text,
	price int
);

create table applications(
	id serial primary key,
	enter_date date,
	client_fio text,
	requested_credit_sum int,
	down_payment_sum int,
	loan_term int,
	car_id int references cars(id) 
);

insert into cars(model, manufacturer, price) values ('F-150 Raptor', 'Ford', 170000);
insert into cars(model, manufacturer, price) values ('Vesta Sport', 'Lada', 17000);
insert into cars(model, manufacturer, price) values ('GLE 63 AMG', 'Mercedes-Benz', 200000);

insert into applications(enter_date, client_fio, requested_credit_sum, down_payment_sum, loan_term, car_id)
values ('01.01.2022', 'Kalchenko Denis Alexandrovich', 70000, 100000, 36, 1);
insert into applications(enter_date, client_fio, requested_credit_sum, down_payment_sum, loan_term, car_id)
values ('01.07.2021', 'Kalchenko Denis Alexandrovich', 7000, 10000, 12, 2);
insert into applications(enter_date, client_fio, requested_credit_sum, down_payment_sum, loan_term, car_id)
values ('01.12.2021', 'Andrianova Anastasiya Vadimovna', 50000, 150000, 48, 3);

select a.client_fio ФИО_КЛИЕНТА, c.model МОДЕЛЬ, c.manufacturer БРЕНД from applications a
join cars c on a.car_id = c.id;

select c.model МОДЕЛЬ, c.price ЦЕНА, a.requested_credit_sum ЗАПРОШЕННАЯ_СУММА from cars c
join applications a on c.id = a.car_id
where c.price <= 100000;

select a.client_fio ФИО_КЛИЕНТА from applications a
join cars c on a.car_id = c.id
where lower(c.model) like '%sport%';