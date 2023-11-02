create table Person
(
    id    serial,
    name  varchar,
    age   int,
    email varchar
);

create table Person
(
    id    int GENERATED BY DEFAULT AS IDENTITY ,
    name  varchar,
    age   int,
    email varchar
);

create table Person
(
    id    int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  varchar NOT NULL,
    age   int check ( age > 0 ),
    email varchar UNIQUE
);
insert into person(name, age, email) VALUES ('Ted', 44, 'School@mail.ru');
insert into person(name, age, email) VALUES ('Sonya', 15, 'Cathc@mail.ru');
insert into person(name, age, email) VALUES ('Marya', 39, 'Sotki@gmail.ru');
insert into person(name, age, email) VALUES ('Med', 15, 'soroka@mail.ru');

insert into person(name, age, email,address) VALUES ('Ted', 44, 'School@mail.ru', 'Russia, Moscow, 126555');
insert into person(name, age, email,address) VALUES ('Sonya', 15, 'Cathc@mail.ru','Russia, Astrachan, 414040');
insert into person(name, age, email,address) VALUES ('Marya', 39, 'Sotki@gmail.ru','Russia, Spb, 017454');
insert into person(name, age, email,address) VALUES ('Med', 15, 'soroka@mail.ru','Russia, Krasnodar, 698771');

select *
from Person;

drop table Person;

create sequence my_sequence;

select nextval('my_sequence');
drop sequence my_sequence;

truncate table person;

alter table person add column address varchar not null;