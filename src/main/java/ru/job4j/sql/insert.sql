insert into roles(title) values ('administrator');
insert into roles(title) values ('moderator');
insert into roles(title) values ('client');

insert into rules(title) values ('create');
insert into rules(title) values ('edit');
insert into rules(title) values ('delete');

insert into roles_rules(role_id, rule_id) values (1, 1);
insert into roles_rules(role_id, rule_id) values (1, 2);
insert into roles_rules(role_id, rule_id) values (1, 3);
insert into roles_rules(role_id, rule_id) values (2, 2);
insert into roles_rules(role_id, rule_id) values (3, 1);
insert into roles_rules(role_id, rule_id) values (3, 2);
insert into roles_rules(role_id, rule_id) values (3, 3);

insert into users(firstname, lastname, role_id) values ('Denis', 'Kalchenko', 1);
insert into users(firstname, lastname, role_id) values ('Anastasiya', 'Andrianova', 2);
insert into users(firstname, lastname, role_id) values ('Jonny', 'Depp', 3);
insert into users(firstname, lastname, role_id) values ('Brat', 'Pitt', 3);
insert into users(firstname, lastname, role_id) values ('James', 'Cameron', 1);

insert into statuses(title) values ('created');
insert into statuses(title) values ('assembling');
insert into statuses(title) values ('delivery');
insert into statuses(title) values ('executed');

insert into categories(title) values ('home');
insert into categories(title) values ('kitchen');
insert into categories(title) values ('electronics');

insert into items(enter_date, user_id, category_id, status_id) values ('20.01.2022', 3, 3, 1);

insert into comments(comment, item_id) values ('The product is out of stock.', 1);

insert into attachs(appendix, item_id) values ('Picture', 1);
