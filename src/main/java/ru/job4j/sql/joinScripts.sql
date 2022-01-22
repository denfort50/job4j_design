create table departments(
    id serial primary key,
    name varchar(255)
);

create table employers(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('Risks');
insert into departments(name) values ('Compliance');
insert into departments(name) values ('M&A');
insert into departments(name) values ('Tax');
insert into departments(name) values ('GR');
insert into departments(name) values ('PR');

insert into employers(name, department_id) values ('Alex', 1);
insert into employers(name, department_id) values ('Brad', 2);
insert into employers(name, department_id) values ('Anna', 3);
insert into employers(name, department_id) values ('Winston', 3);
insert into employers(name, department_id) values ('Daniel', 2);
insert into employers(name, department_id) values ('Marta', null);
insert into employers(name, department_id) values ('Victoria', 2);
insert into employers(name, department_id) values ('Andrew', null);
insert into employers(name, department_id) values ('James', null);
insert into employers(name, department_id) values ('Patrick', 2);
insert into employers(name, department_id) values (null, 1);
insert into employers(name, department_id) values (null, 4);

-- Left, right, full, cross
select e.*, d.* from employers e
left join departments d on e.department_id = d.id;

select e.*, d.* from employers e
right join departments d on e.department_id = d.id;

select e.*, d.* from employers e
full join departments d on e.department_id = d.id;

select e.*, d.* from employers e
cross join departments d;

-- Департаменты, у которых нет работников
select d.name from departments d
left join employers e on d.id = e.department_id
where e.department_id is null;

-- Left и right с одинаковым результатом
select e.*, d.* from employers e
left join departments d on e.department_id = d.id;

select e.*, d.* from departments d
right join employers e on d.id = e.department_id;

-- Создание разнополых пар
create table teens(
	id serial primary key,
	name varchar(255),
	gender text
);

insert into teens(name, gender) values('Anna', 'female');
insert into teens(name, gender) values('Alex', 'male');
insert into teens(name, gender) values('Nastya', 'female');
insert into teens(name, gender) values('Denis', 'male');
insert into teens(name, gender) values('Nadya', 'female');

select t1.name, t2.name from teens t1 cross join teens t2 where t1.gender <> t2.gender;