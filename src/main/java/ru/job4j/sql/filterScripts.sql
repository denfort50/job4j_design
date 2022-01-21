create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key, 
	name text, 
	type_id int, 
	expired_date date, 
	price int
);

insert into type(name) values('СЫР');
insert into type(name) values('МОЛОКО');
insert into type(name) values('ШАШЛЫК');

insert into product(name, type_id, expired_date, price) values('Сыр плавленный', 1, '01.02.2022', 200);
insert into product(name, type_id, expired_date, price) values('Сыр моцарелла', 1, '11.03.2022', 1000);
insert into product(name, type_id, expired_date, price) values('мороженое', 2, '05.07.2022', 500);
insert into product(name, type_id, expired_date, price) values('безлактозное мороженое', 2, '05.07.2022', 500);
insert into product(name, type_id, expired_date, price) values('шашлык из баранины', 3, '05.07.2022', 500);
insert into product(name, type_id, expired_date, price) values('Сыр гауда', 1, '11.03.2021', 1000);
insert into product(name, type_id, expired_date, price) values('Сыр пармезан', 1, '11.06.2022', 2000);

-- 1. Все продукты с типом "СЫР"
select p.name from product p
join type t on p.type_id = t.id
where t.name = 'СЫР';

-- 2. Все продукты, у кого в имени есть слово "мороженое"
select p.name from product p
where p.name like '%мороженое%';

-- 3. Все продукты, срок годности которых уже истек
select p.name from product p
where p.expired_date < current_date;

-- 4. Самый дорогой продукт
select p.name from product p
where p.price = (select max(price) from product);

-- 5. Количество продуктов, принадлежащих к конкретному типу
select t.name, count (p.*) amt from product p
join type t on p.type_id = t.id
group by t.name;

-- 6. Все продукты с типом "СЫР" и "МОЛОКО"
select p.name from product p
join type t on p.type_id = t.id
where t.name in ('СЫР', 'МОЛОКО');

-- 7. Тип продуктов, которых осталось меньше 10 штук
select t.name from product p
join type t on p.type_id = t.id
group by t.name
having count(p.*) < 10;

-- 8. Все продукты и их тип
select p.name, t.name from product p
join type t on p.type_id = t.id;