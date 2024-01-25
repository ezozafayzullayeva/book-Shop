-- create type UserType as ENUM('ADMIN', 'USER');

create table "user"
(
    id uuid DEFAULT gen_random_uuid() primary key ,
    name  varchar not null,
    phone_number varchar not null unique,
    email        varchar not null unique ,
    password     varchar not null,
--     balance      DOUBLE PRECISION,
    balance      varchar,
    user_type    varchar
);

