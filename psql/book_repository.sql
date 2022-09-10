--Видеокурс [Udemy] SQL (2022) Денис Матвеенко
--Начальный уровень - практика



CREATE DATABASE book_repository;

CREATE TABLE author
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL
);

CREATE TABLE book
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(128) NOT NULL,
    year      SMALLINT     NOT NULL,
    pages     SMALLINT     NOT NULL,
    author_id INT REFERENCES author (id)
);

INSERT INTO author (first_name, last_name)
VALUES ('Кей', 'Хорстман'),
       ('Стивен', 'Кови'),
       ('Тони', 'Роббинс'),
       ('Наполеон', 'Хилл'),
       ('Роберт', 'Кийосаки'),
       ('Дейл', 'Карнеги');

select *
from author;

insert into book (name, year, pages, author_id)
values ('Java. Библиотеку профессионала. Том 1', 2010, 1102, (SELECT id FROM author WHERE last_name = 'Хорстман')),
       ('Java. Библиотеку профессионала. Том 2', 2012, 954, (SELECT id FROM author WHERE last_name = 'Хорстман')),
       ('Java SE 8. Вводный курс', 2015, 203, (SELECT id FROM author WHERE last_name = 'Хорстман')),
       ('7 навыков высокоэффективных людей', 1989, 396, (SELECT id FROM author WHERE last_name = 'Кови')),
       ('Разбуди в себе исполина', 1991, 576, (SELECT id FROM author WHERE last_name = 'Роббинс')),
       ('Думай и богатей', 1937, 336, (SELECT id FROM author WHERE last_name = 'Хилл')),
       ('Богатый папа, бедный папа', 1997, 352, (SELECT id FROM author WHERE last_name = 'Кийосаки')),
       ('Квадрант денежного потока', 1998, 368, (SELECT id FROM author WHERE last_name = 'Кийосаки')),
       ('Как перестать беспокоиться и начать жить', 1948, 368, (SELECT id FROM author WHERE last_name = 'Карнеги')),
       ('Как завоевывать друзей и оказывать влияние на людей', 1936, 352,
        (SELECT id FROM author WHERE last_name = 'Карнеги'));



-- Запрос, выбирающий: название книги, год и имя автора. Сортировка по году издания книги в возрастающем порядке.
-- сначала напишем простой запрос выбирающий название книги и год
SELECT name, year
FROM book
ORDER BY year;

-- теперь добавим подзапрос для выбора имени автора
SELECT year, name, (SELECT first_name FROM author WHERE author.id = book.author_id)
FROM book
ORDER BY year;

-- в запрос можно добавить алиасы
SELECT b.year,
       b.name,
       (SELECT a.first_name FROM author a WHERE a.id = b.author_id)
FROM book b
ORDER BY b.year;



-- Запрос выбирающий количество книг у заданного автора
-- сначала считаем вообще кол-во всех книг в таблице
SELECT count(*)
FROM book;

-- теперь добавлем фильтрацию по автору
SELECT count(*)
FROM book
WHERE author_id = 1;
--и задаем например автора с айди равным 1

-- но поскольку книг может быть миллион, то лучше выбирать конкретного автора через подзапрос
SELECT count(*)
FROM book
WHERE author_id = (SELECT id FROM author WHERE first_name = 'Кей');
--выбираем конкретное имя автора

-- в случае если авторов с заданным именем много, надо указать оператор IN
SELECT count(*)
FROM book
WHERE author_id IN (SELECT id FROM author WHERE first_name = 'Кей');
--выведутся все заданные имена по совпадению


-- Запрос выбирающий книги у которых кол-во страниц больше среднего кол-ва страниц по всем книгам
-- сначала узнаем среднее кол-во страниц у всех книг
SELECT avg(pages) --равно 500.7
FROM book;

-- после этого добавим условие вывода всех книг у которых кол-во страниц больше среднего
SELECT *
FROM book
WHERE pages > 500.7;

-- и теперь вставим первый запрос во второй -> создадим подзапрос
SELECT *
FROM book
WHERE pages > (SELECT avg(pages)
               FROM book);



-- Запрос выбирающий 5 самых старых книг и посчитать суммарное кол-во страниц среди них
-- сначала выбираем все книги, сортируем по возрастанию года
SELECT *
FROM book
ORDER BY year;

-- потом ограничиваем выборку первыми 5 книгами
SELECT *
FROM book
ORDER BY year
LIMIT 5;

-- теперь считаем сумму страниц вообще всех книг
SELECT sum(pages) --будет 5007
FROM book;

-- и наконец создаем подзапрос возвращающий только первые 5 самых старых книг
SELECT sum(pages)
FROM (SELECT pages
      FROM book
      ORDER BY year
      LIMIT 5) five;


-- Запрос изменяющий кол-во страниц у заданной книги
UPDATE book
SET pages = 777 -- устанавливаем 777 страниц
WHERE id = 2;
-- для книги с айди = 2


-- Запрос удаляющий автора, который написал самую большую книгу
-- сначала ищем самую большую книгу
SELECT max(pages)
FROM book;

-- ищем всех авторов книг
SELECT author_id
FROM book;

-- теперь надо найти автора написавшего самую большую книгу c помощью подзапроса
SELECT author_id
FROM book
WHERE pages = (SELECT max(pages)
               FROM book);

-- перед удалением автора, надо удалить все книги которые привязаны к нему
DELETE FROM book
    WHERE author_id = (SELECT author_id
                       FROM book
                       WHERE pages = (SELECT max(pages)
                                      FROM book));

-- и наконец удаляем этого автора c помощью двух подзапросов
DELETE FROM author
WHERE id = 1
RETURNING *;

