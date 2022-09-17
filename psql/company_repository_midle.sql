--Видеокурс [Udemy] SQL (2022) Денис Матвеенко
--Средний уровень


--про соединение таблиц
--грохаем ранее созданные таблицы
DROP TABLE employee;
DROP TABLE company;


--создаем и заполняем данными
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
    company_id INT REFERENCES company (id),
    salary     INT,
    UNIQUE (first_name, last_name)
);

INSERT INTO employee (first_name, last_name, salary, company_id)
VALUES ('ivan', 'Sidorov', 500, 1),
       ('ivan', 'Ivanov', 1000, 2),
       ('Arni', 'Paramonov', NULL, 2),
       ('Petr', 'Petrov', 2000, 3),
       ('Sveta', 'Svetikova', 1500, NULL);

select *
from employee;

--смотрим что получилось БЕЗ помощи операторов соединения таблиц
SELECT company.name, employee.first_name || employee.last_name fio
FROM employee,
     company
WHERE employee.company_id = company.id;
--ключевое слово ON используется для связи двух таблиц


--смотрим что получилось с помощью оператора соединения таблиц - JOIN
--вывод будет аналогичный предыдущему запросу
SELECT c.name, employee.first_name || employee.last_name fio
FROM employee
         JOIN company c
              ON employee.company_id = c.id;
--ключевое слово ON используется для связи двух таблиц

-- всего существует 5 видов соединения таблиц:
-- JOIN        - внутреннее соединение. отсекает все записи у которых нет внешнего ключа
-- CROSS JOIN
-- LEFT JOIN   - внешнее левое соединение
-- RIGHT JOIN  - внешнее правое соединение
-- FULL JOIN

--снова грохаем таблицы
DROP TABLE employee;
DROP TABLE company;


--и создаем новые таблицы со связью many-to-many
CREATE table company
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE employee
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(128),
    last_name  VARCHAR(128),
    company_id INT REFERENCES company (id)
);

CREATE TABLE contact
(
    id     BIGSERIAL PRIMARY KEY,
    number VARCHAR(128) NOT NULL,
    type   VARCHAR(128)
);

create table employee_contact
(
    employee_id BIGINT REFERENCES employee (id),
    contact_id  BIGINT REFERENCES contact (id),
    PRIMARY KEY (employee_id, contact_id)
);

--заполняем таблицы данными
insert into contact (number, type)
values ('234-56-78', 'домашний'),
       ('987-65-43', 'рабочий'),
       ('565-25-91', 'мобильный'),
       ('332-55-67', NULL),
       ('465-11-22', NULL);

INSERT INTO company(name)
VALUES ('Goggle'),
       ('Apple'),
       ('Facebook');

insert into employee (first_name, last_name, company_id)
VALUES ('ivan', 'Sidorov', 1),
       ('ivan', 'Ivanov', 2),
       ('Arni', 'Paramonov', 2),
       ('Petr', 'Petrov', 3),
       ('Sveta', 'Svetikova', null);

insert into employee_contact (employee_id, contact_id)
values (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 4),
       (4, 5);


--теперь применяем соединение JOIN для всех созданных таблиц чтобы добраться до контактов
SELECT c.name,
       employee.first_name || ' ' || employee.last_name fio,
       ec.contact_id,
       c2.number
FROM employee
         JOIN company c
              ON employee.company_id = c.id
         JOIN employee_contact ec
              ON employee.id = ec.employee_id
         JOIN contact c2
              ON ec.contact_id = c2.id;

--ВНИМАНИЕ! Если конкантинировать непустое значение и null, то вывод будет null

--добавили еще одну компанию
INSERT INTO company(name)
VALUES ('Amazon');


-- про INNER JOIN. На практике чаще применяется обычный внутренний JOIN и LEFT JOIN
SELECT c.name, e.first_name
FROM company c
         JOIN employee e -- внутреннее соединение. отсекает все записи у которых нет внешнего ключа
              ON c.id = e.company_id -- про LEFT JOIN. На практике чаще применяется обычный внутренний JOIN и LEFT JOIN
;

SELECT c.name, e.first_name
FROM company c
         LEFT JOIN employee e --запись говорит о том, что все записи СЛЕВА (из таблицы company) должны быть выведены
                   ON c.id = e.company_id -- в результирующей выборке, а все записи справа нам не важны
;

-- про RIGHT JOIN
SELECT c.name, e.first_name
FROM company c
         RIGHT JOIN employee e --запись говорит о том, что все записи СПРАВА (из таблицы employee) должны быть выведены
                    ON c.id = e.company_id -- в результирующей выборке, а все записи слева нам не важны
;

-- про FULL JOIN
SELECT c.name, e.first_name
FROM company c
         FULL JOIN employee e --запись говорит о том, что все записи СЛЕВА (из таблицы company) должны быть выведены
                   ON c.id = e.company_id -- и ТАКЖЕ должны быть показаны все записи СПРАВА (из таблицы employee)
;

-- про CROSS JOIN.
SELECT *
FROM employee
         CROSS JOIN company;
-- в таком виде CROSS JOIN выводит декартово произведение всех сотрудников на все компании


--ГРУПИРОВКА ЗАПРОСОВ. GROUP BY & HAVING
--Агрегирующие функции используются только с группировками. Это те функции которые схлопывают несколько строк в одну.
--Этих функций всего 5: count, SUM, AVG, MAX, MIN

--ПРИМЕР: найти кол-во сорудников в указанной компании
SELECT count(*) -- (*) выведет всех даже null
FROM company
         LEFT JOIN employee e --используем LEFT, чтобы получить компании в которых вообще нет сотрудников
                   ON company.id = e.company_id
WHERE company.name = 'Apple';
--указываем компанию по которой будем узнавать кол-во ее сотрудников

--указываем компанию в которой нет сотрудников
SELECT count(*) -- (*) выведет всех даже null
FROM company
         LEFT JOIN employee e --используем LEFT, чтобы получить компании в которых вообще нет сотрудников
                   ON company.id = e.company_id
WHERE company.name = 'Amazon';
--указываем компанию в которой нет сотрудников
--и в оутпуте видим каунт = 1. Хотя в амазон мы точно не добавляли людей. Это произошло потому что стоит (*).

--чтобы убедиться в этом, выберем две колонки
SELECT company.name, e.first_name
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id
WHERE company.name = 'Apple';
--в оутпуте видим данные двух колонок - Amazon и null

--но выбор двух колонок не решает поставленную задачу
SELECT company.name, e.first_name
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id
WHERE company.name = 'Apple';
--если выбрать Apple, то в оутпуте видим имена сотрудников в этой компании, а не кол-во

--поэтому вернемся к count
SELECT count(e.id) --хотим узнать кол-во сотрудников
FROM company
         LEFT JOIN employee e ON company.id = e.company_id
WHERE company.name = 'Amazon';
--и теперь видим корректный оутпут - 0 сотрудников

--но поскольку колонка теперь просто count, мы не видим что это действительно сотрудники Amazon
SELECT count(e.id) --хотим узнать кол-во сотрудников
FROM company
         LEFT JOIN employee e ON company.id = e.company_id
WHERE company.name = 'Amazon';
--и теперь видим корректный оутпут - 0 сотрудников

--если указать еще одну колонку company.name, то ничего не получится, потому что это не агрегирующая функция
SELECT company.name, count(e.id)
FROM company
         LEFT JOIN employee e ON company.id = e.company_id
WHERE company.name = 'Amazon'
GROUP BY company.name;
--поэтому необходимо сгруппировать все данные по указанной колонке

--хорошим тоном будет группировать по id, чтобы можно было перечислять все колонки в таблице company в запросе SELECT
SELECT company.name, count(e.id)
FROM company
         LEFT JOIN employee e ON company.id = e.company_id
WHERE company.name = 'Amazon'
GROUP BY company.id;
--вывод будет аналогичный

--можно убрать WHERE и отобразить ВСЕ компании с кол-вом их сотрудников
SELECT company.name, count(e.id)
FROM company
         LEFT JOIN employee e ON company.id = e.company_id
--WHERE company.name = 'Amazon' --убрали из запроса
GROUP BY company.id;
--в оутпут будут выведены все 4 компании и кол-во их сотрудников

--GROUP BY позволяет схлопывать все записи которые относятся к одному и тому же ключу группировки
--в группировках нельзя использовать колонки, которых не выбраны в SELECT

--можно продолжить фильтровать уже ГРУППЫ с помощью HAVING
SELECT company.name, count(e.id)
FROM company
         LEFT JOIN employee e ON company.id = e.company_id
--WHERE company.name = 'Amazon' --WHERE используется для КАЖДОЙ строчки
GROUP BY company.id --GROUP BY групирует строки в колонке, убирая дубликаты
HAVING count(e.id) > 0;
--HAVING применяет условие для уже сгруппировавшихся строк


--Ококнные функции. Window function
--

--добавим еще несколько сотрудников
insert into employee (first_name, last_name, company_id)
VALUES ('Petr', 'Petrov', 2),
       ('Sidr', 'Sidorov', 3),
       ('Bro', 'Brown', 1);

--выводим все Существующие компании и всех сотрудников в них
SELECT company.name, e.last_name
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id;

--сортируем вывод по имени компании
SELECT company.name, e.last_name
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id
ORDER BY company.name;

--группа отсортированных значений называется окно
-- Apple | Ivanov
-- Apple | Paramonov
-- Apple | Petrov

--суть оконных функций в том что мы можем не схлопывать значения в одну строку, а отображать нужную информацию по окну
--оконные функции включают в себя агрегирующие и много специальных оконных

--ПРИМЕР: узнать сколько всего сотрудников работает во всех компаниях
SELECT company.name,
       e.last_name,
       count(*) OVER (),    --запись OVER () говорит о том, что окном будет вся сделанная выборка
       row_number() OVER () --присваиваем номера строкам
       --rank() OVER (ORDER BY salary) --нумерация сотрудников в зависимости от их зарплат
       --dense_rank() OVER (partition by company.name ORDER BY e.salary) --partition ранжирует по компаниям
       --lag(e.salary) over (ORDER BY e.salary)
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id
ORDER BY company.name;



--ПРЕДСТАВЛЕНИЯ. VIEW
--создание View
CREATE VIEW employee_view AS --указываем имя представления
SELECT company.name, --и после AS пишем что именно будет представлять это пердставление
       e.last_name,
       count(*) OVER (),
       row_number() OVER ()
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id
ORDER BY company.name;

--и теперь чтобы не писать длинный запрос, можно оперативно обращаться к созданному представлению
SELECT *
FROM employee_view
WHERE name = 'Facebook';
--и получаем значения из view, в которую ранее сохранили запрос

--каждый раз когда мы обращаемся к employee_view, он делает полноценный запрос в БД и никак не кэшируется.
--по сути обычный view делает из громоздких запросов более лаконичную запись вызова этого запроса для быстрого вызова

--чтобы закешировать запрос и тем самым ускорить процесс получения даных, существует MATERIALIZED VIEW
CREATE MATERIALIZED VIEW m_employee_view AS --в материализованном view уже хранятся сами данные, а не обращение к ним
SELECT company.name, --и после AS пишем что именно будет представлять это пердставление
       e.last_name,
       count(*) OVER (),
       row_number() OVER ()
FROM company
         LEFT JOIN employee e
                   ON company.id = e.company_id
ORDER BY company.name;

--обращаемся к материализованному запросу
SELECT *
FROM m_employee_view
WHERE name = 'Facebook';

--разница между m_view и обычной view еще в том,
-- что при добавлении новых значений в таблицы - обычная view будет их показывать, а m_view это по сути слепок состояния
--m_view обычно используется для сохранения статистических данных либо для доступа к выбранным данным без возможности
--их редактирования.

--чтобы обновить данные в m_view надо выполнить:
REFRESH MATERIALIZED VIEW m_employee_view;



--ИЗМЕНЕНИЕ ТАБЛИЦ. ALTER
--например добавим пол в таблицу сотрудников
ALTER TABLE IF EXISTS employee
    ADD COLUMN gender INT;
--NOT NULL при создании колонки обычно не пишут
--IF EXISTS проверяет существует ли такая таблица.

--и обновляем данные сотрудников, дабавляя им gender
UPDATE employee
SET gender = 1 -- для примера 0-ж, 1-м.
WHERE id < 5; --например установим мужской пол для всех айди меньше 5

UPDATE employee
SET gender = 0 -- для примера 0-ж, 1-м.
WHERE id >= 5;
--например установим жеенский пол для всех айди больше 4

--теперь можно установить ограничение на новую колонку NOT NULL, потому что все значения уже заполнены
ALTER TABLE employee
    ALTER COLUMN gender SET NOT NULL;

--можно удалить новую колонку как и любую другую
ALTER TABLE employee
    DROP COLUMN gender;

--можно переименовать колонку
ALTER TABLE employee
    RENAME last_name TO l_name;

--можно переименовать саму таблицу
ALTER TABLE employee
    RENAME TO people;



