create table products (
                          id serial primary key,
                          name varchar(50),
                          producer varchar(50),
                          count integer default 0,
                          price integer
);

create table history_of_price (
                                  id serial primary key,
                                  name varchar(50),
                                  price integer,
                                  date timestamp
);

--Триггер №1
create or replace function taxOne()
    returns trigger as
$$
BEGIN
    update products
    set price = price * 1.2
    where id = (select id from inserted);
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';
create trigger tax_one_trigger
    after insert on products
    referencing new table as inserted
    for each statement
execute procedure taxOne();



--Триггер №2
create or replace function taxTwo()
    returns trigger as
$$
BEGIN
    new.price = new.price * 1.2;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';

create trigger tax_two_trigger
    before insert
    on products
    for each row
execute procedure taxTwo();



--Триггер №3
create or replace function createRecord()
    returns trigger as
$$
BEGIN
    insert into history_of_price (name, price, date) values (new.name, new.price, current_date);
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';
create trigger create_record_trigger
    after insert on products
    for each row
execute procedure createRecord();



--Вставка значений для проверки
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);

select * from products;
select * from history_of_price;