create table sportcars(
	id serial primary key,
	model varchar(255),
	brand text,
	engine_volume real,
	issue_year integer
);

insert into sportcars(model, brand, engine_volume, issue_year) 
values('Vesta', 'Lada', 1.8, 2022);

update sportcars set model = 'Vesta Sport'

delete from sportcars;

select * from sportcars;