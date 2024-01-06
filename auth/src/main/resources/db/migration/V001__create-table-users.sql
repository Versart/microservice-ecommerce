create table users(
    id SERIAL primary key,
    username varchar(100) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    user_role varchar(10) not null
);