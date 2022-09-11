create table cars (
                          id serial primary key,
                          brand varchar(50),
                          model varchar(50),
                          count integer default 0,
                          price integer
);

insert into cars (brand, model, count, price) VALUES ('toyota', 'camry', 3, 30000);
insert into cars (brand, model, count, price) VALUES ('audi', 's8', 2, 130000);
insert into cars (brand, model, count, price) VALUES ('kia', 'k900', 8, 80000);

-- Уровень Read Committed
begin transaction;
insert into cars (brand, model, count, price) VALUES ('honda', 'accord', 1, 15000);
delete from cars where price = 130000;
update cars set price = 35000 where model = 'camry';
commit;
select * from cars;

-- Уровень Repeatable Read c коммитом
begin transaction isolation level repeatable read;
insert into cars (brand, model, count, price) VALUES ('lada', 'vesta', 2, 12000);
delete from cars where price = 80000;
update cars set price = 40000 where model = 'camry';
commit;
select * from cars;

-- Уровень Repeatable Read с откатом
begin transaction isolation level repeatable read;
insert into cars (brand, model, count, price) VALUES ('lada', 'x-ray', 3, 13000);
delete from cars where price = 12000;
update cars set price = 33000 where model = 'camry';
rollback;
select * from cars;

-- Уровень Serializable
begin transaction isolation level serializable;
select sum(count) from cars;
update cars set count = 15 where model = 'camry';
commit;