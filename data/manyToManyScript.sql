create table actors(
    id serial primary key,
    first_name varchar(255),
    last_name varchar(255)
);

create table movies(
    id serial primary key,
    year int,
    title varchar(255),
    genre varchar(255)
);

create table actors_movies(
    id serial primary key,
    actor_id int references actors(id),
    movie_id int references movies(id)
);

insert into actors(first_name, last_name) values ('Leonardo', 'DiCaprio');
insert into actors(first_name, last_name) values ('Cillian', 'Murphy');
insert into actors(first_name, last_name) values ('Brad', 'Pitt');

insert into movies(year, title, genre) values (1997, 'Titanic', 'melodrama')
insert into movies(year, title, genre) values (2009, 'Inglourious Basterds', 'military')
insert into movies(year, title, genre) values (1999, 'Fight Club', 'thriller')
insert into movies(year, title, genre) values (2008, 'The Dark Knight', 'action')
insert into movies(year, title, genre) values (2010, 'Inception', 'fantastic')
insert into movies(year, title, genre) values (2005, 'Mr. & Mrs. Smith', 'action')

insert into actors_movies(actor_id, movie_id) values (1, 1);
insert into actors_movies(actor_id, movie_id) values (1, 5);
insert into actors_movies(actor_id, movie_id) values (2, 4);
insert into actors_movies(actor_id, movie_id) values (2, 5);
insert into actors_movies(actor_id, movie_id) values (3, 2);
insert into actors_movies(actor_id, movie_id) values (3, 3);
insert into actors_movies(actor_id, movie_id) values (3, 6);

select a.first_name, a.last_name, m.year, m.title, m.genre from actors a
join actors_movies am on a.id = am.actor_id
join movies m on am.movie_id = m.id