select * from cars;

-- Уровень Read Committed
begin transaction;
commit;
select * from cars;

-- Уровень Repeatable Read с неудачным завершением из-за параллельной транзакции
begin transaction isolation level repeatable read;
update cars set price = 39000 where model = 'camry';
commit;
select * from cars;

-- Уровень Repeatable Read с удачным завершением после отката параллельной транзакции
begin transaction isolation level repeatable read;
update cars set price = 39000 where model = 'camry';
commit;
select * from cars;

-- Уровень Serializable
begin transaction isolation level serializable;
select sum(count) from cars;
update cars set count = 8 where model = 'accord';
commit;