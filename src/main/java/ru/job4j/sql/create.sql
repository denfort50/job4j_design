create table roles(
    id serial primary key,
    title varchar(255)
)

create table rules(
    id serial primary key,
    title varchar(255)
)

create table roles_rules(
    id serial primary key,
    role_id int references roles(id),
    rule_id int references rules(id)
)

create table users(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255),
    role_id int references roles(id)
)

create table statuses(
    id serial primary key,
    title varchar(255)
)

create table categories(
    id serial primary key,
    title varchar(255)
)

create table items(
    id serial primary key,
    enter_date date,
    user_id int references users(id),
    category_id int references categories(id),
    status_id int references statuses(id)
)

create table comments(
    id serial primary key,
    comment varchar(255),
    item_id int references items(id)
)

create table attachs(
    id serial primary key,
    appendix varchar(255),
    item_id int references items(id)
)
