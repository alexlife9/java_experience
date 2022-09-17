--Видеокурс [Udemy] SQL (2022) Денис Матвеенко
--Начальный уровень. 



CREATE DATABASE company_repository;

CREATE SCHEMA company_repository;

DROP SCHEMA company_storage;

--создаем таблицу Компании
CREATE TABLE company
(
    id   INT PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL,
    date DATE                NOT NULL CHECK ( date > '1995-01-01' AND date < '2000-01-01')
--констрейты - на уровне базы данных не позволяем вставить в таблицу данные которые будут не валидны
-- NOT NULL - поле обязательно должно быть заполнено
-- UNIQUE - поле будет уникальное
-- UNIQUE(name, date) - сразу оба указанных поля должны быть уникальны
-- CHECK - ограничения или условия при создании полей
-- PRIMARY KEY == UNIQUE and NOT NULL
-- FOREIGN KEY
);

--вставляем данные в таблицу Компании
INSERT INTO company(id, name, date)
VALUES (1, 'Goggle', '2001-01-01'),
       (2, 'Apple', '2002-10-29'),
       (3, 'Facebook', '1998-09-13');

--создаем таблицу Работники
CREATE TABLE employee
(
    id         INT PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    salary     INT,
    company_id int          not null
);

--можно удалить таблицу
DROP TABLE employee;

--добавляем данные в таблицу
insert into employee (id, first_name, last_name, salary)
values (1, 'Ivan', 'Ivanov', 1000),
       (2, 'Petr', 'Petrov', 2000),
       (3, 'Sveta', 'Svetikova', 1500);



--есть неудобство в том, что надо запоминать последний ключ, чтобы все записи были уникальны
--поэтому удаляем таблицы и в новую таблицу добавляем SERIAL KEY для автоматической генерации уникальных ключей
DROP TABLE employee;

--создаем таблицу Сотрудники с уникальным счетчиком ключа
CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    salary     INT
);

--добавляем данные в таблицу. теперь не надо вручную указывать идентификатор записи
INSERT INTO employee (first_name, last_name, salary)
VALUES ('Ivan', 'Ivanov', 1000),
       ('Petr', 'Petrov', 2000),
       ('Sveta', 'Svetikova', 1500);
--можно увидеть что в структуру БД дабавилась запись sequence, которая как раз и генерирует автоматический счетчик


--чтобы невозможно было добавить одинаковые записи установим уникальность суммы двух полей:
DROP TABLE employee; --дропаем

CREATE TABLE employee --создаем снова таблицу с уникальным значением двух полей
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    salary     INT,
    UNIQUE (first_name, last_name)
);

INSERT INTO employee (first_name, last_name, salary) --добавляем данные
VALUES ('Ivan', 'Ivanov', 1000),
       ('Petr', 'Petrov', 2000),
       ('Sveta', 'Svetikova', 1500);
--если два раза попробовать вставить данные, то уже ничего не получится


--про SELECT
SELECT id, first_name, last_name, salary
FROM employee;
--выбираем поля значения которых хотим вывести


--про алиасы. поля можно именовать следующим образом:
SELECT id,
       first_name AS f_name, --AS в постгресе писать не обязательно
       last_name  AS l_name,
       salary     AS зарплата
FROM employee AS empl;
--саму таблицу тоже можно обозвать как угодно


--про DISTINCT. выбираем только уникальные значения
INSERT INTO employee (first_name, last_name, salary) --добавляем еще одну запись
VALUES ('Ivan', 'Sydorov', 500);
SELECT DISTINCT --оператор DISTINCT служит для выборки уникальных записей
                first_name AS f_name --в таблице уже два Ivan, но выведется только первый, по аналогии с SET в Java
FROM employee;


--про LIMIT и OFFSET. можно ограничивать выборку получаемых записей
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
LIMIT 2
-- например показываем только две первые записи из выборки
OFFSET
1;
-- например указываем сколько ПРОПУСТИТЬ записей перед показом выборки
--оператор DISTINCT в данном случае не гарантирует порядок вывода, поэтому LIMIT/OFFSET можно применять либо без него,
--либо сначала применять оператор сортировки ORDER BY


-- про ORDER BY
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
ORDER BY salary;
--сортируем по дефолту по возрастанию - от меньшего к большему. Чтобы сделать убывание пишем DESC
--в ORDER BY можно передавать поля которые перечислены в результирующем наборе после оператора SELECT


--про WHERE. Если нам не надо делать выборку по всей таблице, то фильтруем данные после выбора этой таблицы
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE salary > 1000 -- например выбираем всех сотрудников у которых зарплата больше 1000
ORDER BY salary DESC;
--и сортируем по убыванию - от большей к меньшей

--WHERE salary < 2000 --можно использовать операторы сравнения  > < != = <= >=
--к строкам можно применять только = или !=
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE first_name = 'Ivan' -- например выбираем всех сотрудников у которых имя Ivan
ORDER BY salary;
--и сортируем по возрастанию зарплаты

--в операторе WHERE НЕЛЬЗЯ использовать присвоенные алиасы!

--про LIKE
-- WHERE last_name LIKE '%ov%' --для поиска вхождения
-- LIKE чувствителен к регистру
-- % - любое кол-во символов в начале/конце или с двух сторон
-- 'ov%' - найдет все записи у которых слово начинается на (ov)
-- '%ov' - найдет все записи у которых слово заканчивается на (ov)
-- '%ov%' - найдет все записи у которых слово начинается и заканчивается на любое кол-во символов, но содержит (ov)
-- '_ov%' - найдет все записи у которых слово начинается с ОДНОГО символа ПЕРЕД (ov) и заканчивается любым кол-м символов
-- оператор ILIKE - противоположность LIKE - характерен только для постгрес
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE last_name LIKE '%ov' -- например выбираем всех сотрудников у которых имя заканчивается на (ov)
ORDER BY salary;
--и сортируем по возрастанию зарплаты

--про BETWEEN
--выборка между указанными значениями
--NOT BETWEEN - противоположность BETWEEN
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE salary BETWEEN 1000 AND 1500 --поиск по указанному диапазону (включая укаанные значения, потому что строгое равенство)
ORDER BY salary;
--и сортируем по возрастанию зарплаты

--про IN
--точное вхождение
--WHERE salary IN (1000, 1100, 2000) --поиск по указанному вхождению ИЛИ ИЛИ ИЛИ
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE salary IN (1000, 1100, 2000) --поиск по указанным значениям. несуществующие просто не учитываются
ORDER BY salary;
--и сортируем по возрастанию зарплаты

--запросы можно комбинировать с помощью булевой алгебры
--приоритет AND выше OR. Чтобы точно выделить условия надо использовать скобки ()
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE salary IN (1000, 1100, 2000) --комбинируем запрос хотим получить IN(условие) или LIKE(условие)
   OR first_name LIKE 'Iv%'
ORDER BY first_name, salary;
--и сортируем по возрастанию зарплаты


--агрегирующие функции (sum, avg, max, min, count)
SELECT sum(salary) --получаем сумму всех зарплат всех сотрудников
FROM employee;

SELECT avg(salary) --получаем среднюю зарплату всех сотрудников
FROM employee;

SELECT max(salary) --получаем максимальную зарплату из всех сотрудников
FROM employee;

SELECT min(salary) --получаем минимальную зарплату из всех сотрудников
FROM employee;

SELECT count(salary) --получаем количество строк в выборке по указанной таблице НЕ учитывая NULL значения
FROM employee;

SELECT count(*) --получаем количество строк в выборке по указанной таблице С учетом NULL значений
FROM employee;


--другие встроенные функции
--их все можно глянуть в структуре БД в папке pg_catalog.routines
SELECT upper(first_name), --смена значения поля в ВЕРХНИЙ регистр
       lower(last_name)   --смена значения поля в НИЖНИЙ регистр
FROM employee;

SELECT concat(first_name, ' ', last_name) fio --объединение строк с присвоением нового имени
--first_name || ' ' || last_name fio --идентичная запись конкантенации
FROM employee;

SELECT first_name,
       now() --возвращает текущую дату и время по серверу
FROM employee;

SELECT 2 + 2;
--можно использовать обычные математические функции


--про FOREIGN KEY внешний ключ
--с помощью внешнего ключа достигается согласованность данных и их безопасность от введения некорректных данных
--то есть мы не сможем добавить в таблицу employee идентификатор company, который не существует
DROP TABLE employee;
DROP TABLE company;

CREATE TABLE company
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL,
    date DATE                NOT NULL
);

INSERT INTO company(name, date)
VALUES ('Goggle', '2001-01-01'),
       ('Apple', '2002-10-29'),
       ('Facebook', '1998-09-13');

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    company_id INT REFERENCES company (id), --запись идентична FOREIGN KEY (company_id) REFERENCES company
    salary     INT,
    --FOREIGN KEY (company_id) REFERENCES company,
    UNIQUE (first_name, last_name)
);

--несуществющие данные нельзя добавить, но можно добавить в поле значение NULL
INSERT INTO employee (first_name, last_name, salary, company_id)
VALUES ('ivan', 'Sidorov', 500, 1),
       ('ivan', 'Ivanov', 1000, 2),
       ('Arni', 'Paramonov', NULL, 2),
       ('Petr', 'Petrov', 2000, 3),
       ('Sveta', 'Svetikova', 1500, NULL);
--сотрудник не работает ни в какой компании

--про UNION
--для объединения выборки должны иметь одинаковый набор колонок и их типы данных должны совпадать
SELECT first_name
FROM employee
WHERE company_id IS NOT NULL --выбираем сотрудников которых нет ни в одной компании
UNION ALL
--объединяем две выборки
SELECT first_name
FROM employee
WHERE salary IS NULL;
--в выборку попадут ВСЕ сотрудники (4 значения) из первого запроса И ВСЕ сотрудники (1 значение) из второго запроса

--UNION. в итоговую таблицу попадут только уникальные. По сути Set - множество уников.
SELECT first_name
FROM employee
WHERE company_id IS NOT NULL --выбираем сотрудников которых нет ни в одной компании
UNION
--обрезает дублирующие значения.
SELECT first_name
FROM employee
WHERE salary IS NULL;



--про Подзапросы
--например есть запрос выводящий минимальную зарплату первых двух сотрудников
SELECT *
FROM employee
ORDER BY salary
LIMIT 2;

--и мы захотели найти сумму этих двух зарплат
SELECT avg(emp.salary) --обращение к алиасу можно не указывать, но если будет много подзапросов, то лучше указать
FROM ( --в выборку вставляем подзапрос
         SELECT *
         FROM employee
         ORDER BY salary
         LIMIT 2
     ) AS emp --обязательно надо указать алиас подзапроса, если он используется в FROM
;

--позапрос можно вставить в выбор поля через запятую и указать что будем выводить в этом поле
SELECT *, (select max(salary) from employee) - salary diff
FROM employee;

--подзапрос можно использовать с оператором IN
SELECT *
FROM employee
WHERE company_id IN (
    SELECT company.id
    FROM company
    WHERE date > '2000-01-01'
);


--про DELETE - удаление строк
DELETE
FROM employee; --эта запись удаляет ВСЕ записи ИЗ таблицы. сама таблица при этом не удаляется

DELETE
FROM employee
WHERE salary IS NULL;
--эта запись удаляет записи удовлетворяющие указанному условию

--удаляем сотрудника с максимальной зарплатой
DELETE
FROM employee
WHERE salary = (
    SELECT max(salary)
    FROM employee
);

--нельзя удалить строки на которые ссылаются другие таблицы
DELETE
FROM company
WHERE id = 1;
--к компании с айди=1 привязан 1 сотрудник иван сидоров, значит удаление не произойдет

--чтобы удалить компанию 1, надо сначала удалить всех сотрудников из нее:
DELETE
FROM employee
WHERE company_id = 1;
--удаляем всех сотрудников привязанных к первой компании

--также можно удалить  компанию без предварительного удаления сотрудников
-- с помощью оператора ON DELETE CASCADE, если его сразу прописать при создании таблицы Сотрудников

--удалим таблицу и создадим заново с новым оператором
DROP TABLE employee;
CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    company_id INT REFERENCES company (id) ON DELETE CASCADE, --разрешаем удалить компанию вместе с ее работниками
    salary     INT,
    UNIQUE (first_name, last_name)
);

--вручную добавили в таблицу запись ('Goggle', '2001-01-01') -> Submit
--и теперь добавляем сотрудников
INSERT INTO employee (first_name, last_name, salary, company_id)
VALUES ('ivan', 'Sidorov', 500, 1),
       ('ivan', 'Ivanov', 1000, 2),
       ('Arni', 'Paramonov', NULL, 2),
       ('Petr', 'Petrov', 2000, 3),
       ('Sveta', 'Svetikova', 1500, NULL);

--теперь у нас получится удалить компанию 2 без предварительного удаления сотрудников из нее
DELETE
FROM company
WHERE id = 2
RETURNING *; -- оператор показывает какие именно строчки удалены


--про UPDATE
UPDATE employee --выбираем таблицу для обновления
SET company_id = 2; --выбираем колонку для обновления и через РАВНО пишем новое значение
-- если оставить запрос в таком виде то обновятся ВСЕ записи в этой колонке на указанное значение

--если хотим установить значение конкретному полю а не всей колонке, то используем фильтрацию WHERE
UPDATE employee
SET company_id = 1, --тут не получится указать компанию которой не существует
    salary = 1700
WHERE id = 11; --обновляем компанию и зарплату на указанные значения у сотрудника с айди 11

--если мы хотим показать изменения произошедшие в результате применения оператора UPDATE, то применяем RETURNING
UPDATE employee
SET company_id = 1, --тут не получится указать компанию которой не существует
    salary = 1700
WHERE id = 11
RETURNING *; --если указать * то выводим ВСЕ данные которые обновил оператор UPDATE