--Создаем таблицу со студентами
create table students (
    id serial primary key,
    name varchar(50)
);
--Вносим студентов
insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');
--Создаем таблицу с авторами
create table authors (
    id serial primary key,
    name varchar(50)
);
--Вносим авторов
insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');
--Создаем таблицу с книгами
create table books (
    id serial primary key,
    name varchar(200),
    author_id integer references authors(id)
);
--Вносим книги
insert into books (name, author_id) values ('Евгений Онегин', 1);
insert into books (name, author_id) values ('Капитанская дочка', 1);
insert into books (name, author_id) values ('Дубровский', 1);
insert into books (name, author_id) values ('Мертвые души', 2);
insert into books (name, author_id) values ('Вий', 2);
--Создаем таблицу с заказами
create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);
--Вносим заказы
insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (2, 2);
--Создаем представление "show_students_with_2_or_more_books"
create view show_students_with_2_or_more_books
as select s.name as student, count(a.name), a.name as author from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
group by (s.name, a.name) having count(a.name) >= 2;
--Выводим результат на экран
select * from show_students_with_2_or_more_books;

--Задание: написать большой запрос и сделать на его основе представление
--Добавляем данные в таблицы
insert into students (name) values ('Денис Кальченко');
insert into students (name) values ('Даниэл Рэдклифф');
insert into students (name) values ('Рэйф Файнс');
insert into authors (name) values ('Джоан Роулинг');
insert into books (name, author_id) values ('Гарри Поттер и философский камень', 3);
insert into books (name, author_id) values ('Гарри Поттер и Тайная комната', 3);
insert into books (name, author_id) values ('Гарри Поттер и узник Азкабана', 3);
insert into books (name, author_id) values ('Гарри Поттер и Кубок огня', 3);
insert into books (name, author_id) values ('Гарри Поттер и Орден Феникса', 3);
insert into books (name, author_id) values ('Гарри Поттер и Принц-полукровка', 3);
insert into books (name, author_id) values ('Гарри Поттер и Дары Смерти', 3);
insert into books (name, author_id) values ('Гарри Поттер и Проклятое дитя', 3);
insert into orders (book_id, student_id) values (6, 1);
insert into orders (book_id, student_id) values (7, 1);
insert into orders (book_id, student_id) values (8, 1);
insert into orders (book_id, student_id) values (9, 1);
insert into orders (book_id, student_id) values (10, 1);
insert into orders (book_id, student_id) values (11, 1);
insert into orders (book_id, student_id) values (12, 1);
insert into orders (book_id, student_id) values (13, 1);
insert into orders (book_id, student_id) values (6, 3);
insert into orders (book_id, student_id) values (7, 3);
insert into orders (book_id, student_id) values (8, 3);
insert into orders (book_id, student_id) values (9, 3);
insert into orders (book_id, student_id) values (10, 3);
insert into orders (book_id, student_id) values (11, 3);
insert into orders (book_id, student_id) values (12, 3);
insert into orders (book_id, student_id) values (13, 3);
insert into orders (book_id, student_id) values (6, 2);
insert into orders (book_id, student_id) values (7, 2);
insert into orders (book_id, student_id) values (8, 2);
insert into orders (book_id, student_id) values (9, 2);
insert into orders (book_id, student_id) values (8, 4);
insert into orders (book_id, student_id) values (9, 4);
insert into orders (book_id, student_id) values (9, 5);
--Создаем представление "show_books_authors_and_customer_amount_more_then_two"
create view show_books_authors_and_customer_amount_more_then_two
as select b.name Book, a.name Author, count(s.name) Customer_amount from books b
    join authors a on b.author_id = a.id
    join orders o on b.id = o.book_id
    join students s on o.student_id = s.id
where a.name like '%Роулинг'
group by b.name, a.name
having count(s.name) > 2
order by Customer_amount desc;
--Выводим результат на экран
select * from show_books_authors_and_customer_amount_more_then_two;