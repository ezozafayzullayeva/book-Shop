--create type BookCover as ENUM('YUMSHOQ', 'QATTIQ');

create table "book"(
    id uuid default gen_random_uuid() primary key ,
    name varchar  ,
    author varchar ,
    price varchar ,
    cover varchar,
    publisher varchar,
--     book_pages DOUBLE PRECISION ,
    pages  varchar ,
--     year_of_publication TIMESTAMP default CURRENT_TIMESTAMP
    year_of_publication varchar
);

insert into book(id, name, author,  price, cover, publisher, pages, year_of_publication)
values ('2fba9a8d-36aa-4336-be93-57e4f7d47e4f', 'Ibtido',  'Den Braun',
        '85000',
        'QATTIQ',  'Asaxiy',
        '590', '2021');

insert into book(id, name, author,  price, cover, publisher, pages, year_of_publication)
values ('abbf8f23-8ca9-46d6-afee-cffd26a97acc', 'Raqamli qala',  'Den Braun',
        '60000',
        'YUMSHOQ',  'Asaxiy',
        '559', '2020');

insert into book(id, name, author,  price, cover, publisher, pages, year_of_publication)
values ('18a639c0-5b16-449a-ab6b-0d2035c967ac', 'Shaytonlar va farishtalar',  'Den Braun',
        '80000',
        'QATTIQ',  'Asaxiy',
        '600', '2023');

insert into book(id, name, author,  price, cover, publisher, pages, year_of_publication)
values ('cc04f8cc-dffa-4ef2-872c-a50b034e1c3c', 'Da vinchi kodi',  'Den Braun',
        '50000',
        'YUMSHOQ',  'Asaxiy',
        '560', '2019');