create table users (
    id serial,
    login varchar(255) not null unique,
    password varchar(255) not null,
    constraint users_pk primary key (id)
);
