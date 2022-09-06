--Очищаем таблицу
delete from products;
ALTER SEQUENCE products_id_seq RESTART WITH 1;

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 5, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 20, 20);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 30, 10);

--Создаем процедуру
create or replace procedure delete_data(i_id integer)
    language 'plpgsql'
as $$
begin
    delete from products where id = i_id;
end
$$;

--Создаем функцию
create or replace function f_delete_data(i_id integer)
    returns integer
    language 'plpgsql'
as $$
declare
    result integer;
begin
    delete from products where id = i_id;
    select into result sum(count) from products;
    return result;
end
$$;

select * from products;

--Проверяем работу процедуры
call delete_data(5);

--Проверяем работу функции
select f_delete_data(4);