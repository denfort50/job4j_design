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

select * from cars;

begin transaction;
insert into cars (brand, model, count, price) VALUES ('honda', 'accord', 1, 15000);
commit;

begin transaction;
delete from cars;
drop table cars;
select * from products;
rollback transaction;

begin transaction;
insert into cars (brand, model, count, price) VALUES ('lada', 'vesta', 2, 12000);
savepoint first_savepoint;
delete from cars where price = 80000;
update cars set price = 40000 where model = 'camry';
select * from cars;
rollback to first_savepoint;
select * from cars;
commit transaction;

begin transaction;
insert into cars (brand, model, count, price) VALUES ('bmw', 'x6m', 5, 150000);
savepoint first_savepoint;
delete from cars where price = 80000;
update cars set price = 40000 where model = 'camry';
savepoint second_savepoint;
insert into cars (brand, model, count, price) VALUES ('lada', 'x-ray', 3, 13000);
savepoint third_savepoint;
insert into cars (brand, model, count, price) VALUES ('mazda', 'mx-5', 5, 100000);
select * from cars;
rollback to third_savepoint;
select * from cars;
rollback to second_savepoint;
select * from cars;
rollback to first_savepoint;
select * from cars;
commit transaction;
