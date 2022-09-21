--Видеокурс [Udemy] SQL (2022) Денис Матвеенко
--Средний уровень
--Практика



--создаем новую БД
CREATE DATABASE flight_repository;

--создаем таблицу airport (аэропорт) с полями:
-- code (уникальный код аэропорта)
-- country (страна)
-- city (город)
CREATE TABLE airport
(
    code    CHAR(3) PRIMARY KEY,
    country VARCHAR(256) NOT NULL,
    city    VARCHAR(128) NOT NULL
);

--создаем таблицу aircraft (самолет) с полями:
-- id
-- model (модель самолета - unique)
CREATE TABLE aircraft
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(128) NOT NULL
);

--создаем таблицу seat (место в самолете) с полями:
-- aircraft_id (самолет)
-- seat_no (номер места в самолете)
CREATE TABLE seat
(
    aircraft_id INT REFERENCES aircraft (id),
    seat_no     VARCHAR(4) NOT NULL,
    PRIMARY KEY (aircraft_id, seat_no)
);

--создаем таблицу flight (рейс) с полями:
-- id (номер рейса не уникальный, поэтому нужен id)
-- flight_no (номер рейса)
-- departure_date (дата вылета)
-- departure_airport_code (аэропорт вылета)
-- arrival_date (дата прибытия)
-- arrival_airport_code (аэропорт прибытия)
-- aircraft_id (самолет)
-- status (статус рейса: cancelled, arrived, departed, scheduled)
CREATE TABLE flight
(
    id                     BIGSERIAL PRIMARY KEY,
    flight_no              VARCHAR(16)                       NOT NULL,
    departure_date         TIMESTAMP                         NOT NULL,
    departure_airport_code CHAR(3) REFERENCES airport (code) NOT NULL,
    arrival_date           TIMESTAMP                         NOT NULL,
    arrival_airport_code   CHAR(3) REFERENCES airport (code) NOT NULL,
    aircraft_id            INT REFERENCES aircraft (id)      NOT NULL,
    status                 VARCHAR(32)                       NOT NULL
);

--создаем таблицу ticket (билет на самолет) с полями:
-- id
-- passenger_no (номер паспорта пассажира)
-- passenger_name (имя и фамилия пассажира)
-- flight_id (рейс)
-- seat_no (номер места в самолете – flight_id + seat-no - unique)
-- cost (стоимость)
CREATE TABLE ticket
(
    id             BIGSERIAL PRIMARY KEY,
    passenger_no   VARCHAR(32)                   NOT NULL,
    passenger_name VARCHAR(128)                  NOT NULL,
    flight_id      BIGINT REFERENCES flight (id) NOT NULL,
    seat_no        VARCHAR(4)                    NOT NULL,
    cost           NUMERIC(8, 2)                 NOT NULL
);


--заполняем таблицы данными
insert into airport (code, country, city)
values ('MNK', 'Беларусь', 'Минск'),
       ('LDN', 'Англия', 'Лондон'),
       ('MSK', 'Россия', 'Москва'),
       ('BSL', 'Испания', 'Барселона');

insert into aircraft (model)
values ('Боинг 777-300'),
       ('Боинг 737-300'),
       ('Аэробус A320-200'),
       ('Суперджет-100');

insert into seat (aircraft_id, seat_no)
select id, s.column1
from aircraft
         cross join (values ('A1'), ('A2'), ('B1'), ('B2'), ('C1'), ('C2'), ('D1'), ('D2') order by 1) s;

insert into flight (flight_no, departure_date, departure_airport_code, arrival_date, arrival_airport_code, aircraft_id,
                    status)
values ('MN3002', '2020-06-14T14:30', 'MNK', '2020-06-14T18:07', 'LDN', 1, 'ARRIVED'),
       ('MN3002', '2020-06-16T09:15', 'LDN', '2020-06-16T13:00', 'MNK', 1, 'ARRIVED'),
       ('BC2801', '2020-07-28T23:25', 'MNK', '2020-07-29T02:43', 'LDN', 2, 'ARRIVED'),
       ('BC2801', '2020-08-01T11:00', 'LDN', '2020-08-01T14:15', 'MNK', 2, 'DEPARTED'),
       ('TR3103', '2020-05-03T13:10', 'MSK', '2020-05-03T18:38', 'BSL', 3, 'ARRIVED'),
       ('TR3103', '2020-05-10T07:15', 'BSL', '2020-05-10T012:44', 'MSK', 3, 'CANCELLED'),
       ('CV9827', '2020-09-09T18:00', 'MNK', '2020-09-09T19:15', 'MSK', 4, 'SCHEDULED'),
       ('CV9827', '2020-09-19T08:55', 'MSK', '2020-09-19T10:05', 'MNK', 4, 'SCHEDULED'),
       ('QS8712', '2020-12-18T03:35', 'MNK', '2020-12-18T06:46', 'LDN', 2, 'ARRIVED');

insert into ticket (passenger_no, passenger_name, flight_id, seat_no, cost)
values ('112233', 'Иван Иванов', 1, 'A1', 200),
       ('23234A', 'Петр Петров', 1, 'B1', 180),
       ('SS988D', 'Светлана Светикова', 1, 'B2', 175),
       ('QYASDE', 'Андрей Андреев', 1, 'C2', 175),
       ('POQ234', 'Иван Кожемякин', 1, 'D1', 160),
       ('898123', 'Олег Рубцов', 1, 'A2', 198),
       ('555321', 'Екатерина Петренко', 2, 'A1', 250),
       ('QO23OO', 'Иван Розмаринов', 2, 'B2', 225),
       ('9883IO', 'Иван Кожемякин', 2, 'C1', 217),
       ('123UI2', 'Андрей Буйнов', 2, 'C2', 227),
       ('SS988D', 'Светлана Светикова', 2, 'D2', 277),
       ('EE2344', 'Дмитрий Трусцов', 3, 'А1', 300),
       ('AS23PP', 'Максим Комсомольцев', 3, 'А2', 285),
       ('322349', 'Эдуард Щеглов', 3, 'B1', 99),
       ('DL123S', 'Игорь Беркутов', 3, 'B2', 199),
       ('MVM111', 'Алексей Щербин', 3, 'C1', 299),
       ('ZZZ111', 'Денис Колобков', 3, 'C2', 230),
       ('234444', 'Иван Старовойтов', 3, 'D1', 180),
       ('LLLL12', 'Людмила Старовойтова', 3, 'D2', 224),
       ('RT34TR', 'Степан Дор', 4, 'A1', 129),
       ('999666', 'Анастасия Шепелева', 4, 'A2', 152),
       ('234444', 'Иван Старовойтов', 4, 'B1', 140),
       ('LLLL12', 'Людмила Старовойтова', 4, 'B2', 140),
       ('LLLL12', 'Роман Дронов', 4, 'D2', 109),
       ('112233', 'Иван Иванов', 5, 'С2', 170),
       ('NMNBV2', 'Лариса Тельникова', 5, 'С1', 185),
       ('DSA586', 'Лариса Привольная', 5, 'A1', 204),
       ('DSA583', 'Артур Мирный', 5, 'B1', 189),
       ('DSA581', 'Евгений Кудрявцев', 6, 'A1', 204),
       ('EE2344', 'Дмитрий Трусцов', 6, 'A2', 214),
       ('AS23PP', 'Максим Комсомольцев', 6, 'B2', 176),
       ('112233', 'Иван Иванов', 6, 'B1', 135),
       ('309623', 'Татьяна Крот', 6, 'С1', 155),
       ('319623', 'Юрий Дувинков', 6, 'D1', 125),
       ('322349', 'Эдуард Щеглов', 7, 'A1', 69),
       ('DIOPSL', 'Евгений Безфамильная', 7, 'A2', 58),
       ('DIOPS1', 'Константин Швец', 7, 'D1', 65),
       ('DIOPS2', 'Юлия Швец', 7, 'D2', 65),
       ('1IOPS2', 'Ник Говриленко', 7, 'C2', 73),
       ('999666', 'Анастасия Шепелева', 7, 'B1', 66),
       ('23234A', 'Петр Петров', 7, 'C1', 80),
       ('QYASDE', 'Андрей Андреев', 8, 'A1', 100),
       ('1QAZD2', 'Лариса Потемнкина', 8, 'A2', 89),
       ('5QAZD2', 'Карл Хмелев', 8, 'B2', 79),
       ('2QAZD2', 'Жанна Хмелева', 8, 'С2', 77),
       ('BMXND1', 'Светлана Хмурая', 8, 'В2', 94),
       ('BMXND2', 'Кирилл Сарычев', 8, 'D1', 81),
       ('SS988D', 'Светлана Светикова', 9, 'A2', 222),
       ('SS978D', 'Андрей Желудь', 9, 'A1', 198),
       ('SS968D', 'Дмитрий Воснецов', 9, 'B1', 243),
       ('SS958D', 'Максим Гребцов', 9, 'С1', 251),
       ('112233', 'Иван Иванов', 9, 'С2', 135),
       ('NMNBV2', 'Лариса Тельникова', 9, 'B2', 217),
       ('23234A', 'Петр Петров', 9, 'D1', 189),
       ('123951', 'Полина Зверева', 9, 'D2', 234);



--Приступаем к запросам.

-- ЗАПРОС №1. Кто летел позавчера рейсом Минск (MNK) - Лондон (LDN) на месте B1?

--обращаемся к таблице билетов
select *
from ticket
limit 1;
--выводим пасажира на первом месте

--указываем нужное место
select *
from ticket
where seat_no = 'B1';
--выводим всех кто летел на этом месте - получилось 7 человек

--присоединяем таблицу полетов чтобы указать рейс - откуда и куда летел самолет
select *
from ticket
         join flight f
              on ticket.flight_id = f.id
where seat_no = 'B1'
  and f.departure_airport_code = 'MNK'
  and f.arrival_airport_code = 'LDN';
--в выборке видим 3 человека летевших этим рейсом на этом месте

--теперь осталось узнать кто из них летел позавчера, ддля этого работаем с датами
select now(); --получаем текущую дату
select interval '1 days'; --получаем объект типа "Интервал 1 день"
select now() - interval '2 days'; --теперь можно отнять от текщей даты необходимый интервал, чтобы получить "позавчера"
select (now() - interval '2 days')::date; --приводим тип к просто дате(2022-09-15), отсекая часы, минуты, секунды
select (now() - interval '2 days')::time;
--также напрмиер можно оставить только время(23:14:05)

--Также для извлечения данных из даты(год, месяц и тд) есть функция EXTRACT
select extract(hour from now());
--например извлекаем часы из текущей даты

--теперь добавляем в наш запрос выборку по дате с условием "позавчера". Для корректного вывода при заполнении таблиц
--нужно было указать даты вылетов равные текущей фактической дате
select *
from ticket
         join flight f
              on ticket.flight_id = f.id
where seat_no = 'B1'
  and f.departure_airport_code = 'MNK'
  and f.arrival_airport_code = 'LDN'
  and f.departure_date::date = (now() - interval '2 days')::date;



-- ЗАПРОС №2. Сколько мест осталось незанятыми 2020-06-14 на рейсе MN3002?

--сначала узнаем какие места заняты на указанном рейсе
select *
from ticket
         join flight f
              on f.id = ticket.flight_id
where f.flight_no = 'MN3002';
--выводим все билеты которые были проданы на этот рейс. 11 билетов

--теперь делаем выборку по дате
select *
from ticket
         join flight f
              on f.id = ticket.flight_id
where f.flight_no = 'MN3002'
  and f.departure_date::date = '2020-06-14';
--на этот рейс и эту дату продано 6 билетов

--теперь узнаем кол-во билетов
select count(*) -- естесственно тоже 6 билетов, но одним числом
from ticket
         join flight f
              on f.id = ticket.flight_id
where f.flight_no = 'MN3002'
  and f.departure_date::date = '2020-06-14';

--теперь по идее надо вычесть занятые билеты из общего кол-ва возможных билетов на самолете
select t.flight_id, count(*)
from ticket t
         join flight f
              on f.id = t.flight_id
where f.flight_no = 'MN3002'
  and f.departure_date::date = '2020-06-14'
group by t.flight_id;
--выводим идентификатор перелета - id=1

--узнаем идентификатор самолета
select f.aircraft_id, count(*)
from ticket t
         join flight f
              on f.id = t.flight_id
where f.flight_no = 'MN3002'
  and f.departure_date::date = '2020-06-14'
group by f.aircraft_id;
--выводим идентификатор перелета- id=1

--узнаем сколько мест есть у самолета айди которого мы вызвали выше
select *
from seat
where aircraft_id = 1;
--видим что у данного самолета 8 мест

--группируем по колонке aircraft_id и отображаем просто кол-во мест
select aircraft_id, count(*)
from seat
where aircraft_id = 1
group by aircraft_id;
--видим что у самолета c id=1 есть 8 мест

--и наконец объединяем все данные которые узнали в один запрос с помощью подзапросов
select t1.*, t2.* --выводим поля наших частей подзапросов
from (
    select f.aircraft_id, count(*)
    from ticket t
           join flight f
                on f.id = t.flight_id
    where f.flight_no = 'MN3002'
    and f.departure_date::date = '2020-06-14'
    group by f.aircraft_id) t1 --первая часть запроса
join (
    select aircraft_id, count(*)
    from seat
    group by aircraft_id) t2 --вторая часть запроса
    ON t1.aircraft_id = t2.aircraft_id;

--и окончательное действие - вычесть из общего кол-ва мест кол-ва занятых
select (t2.count - t1.count) free_seat
from (
     select f.aircraft_id, count(*)
     from ticket t
              join flight f
                   on f.id = t.flight_id
     where f.flight_no = 'MN3002'
       and f.departure_date::date = '2020-06-14'
     group by f.aircraft_id) t1 --первая часть запроса
join (
    select aircraft_id, count(*)
    from seat
    group by aircraft_id) t2 --вторая часть запроса
              ON t1.aircraft_id = t2.aircraft_id;

--выше мы вывели общее кол-во незанятых мест. если нужно узнать номера эти мест, то воспользуемся оператором EXISTS
SELECT EXISTS(select 1 from ticket where id = 2); --оператор возвращает либо тру либо фолс

--поэтому сначала отображаем все поля из seat
select seat_no
from seat
where aircraft_id = 1; --выводим множество из 8 значений - общее кол-во мест у самолета с id=1

--делаем выборку по проданным билетам
select t.seat_no --выводим множество занятых мест
from ticket t
         join flight f
              on f.id = t.flight_id
where f.flight_no = 'MN3002'
  and f.departure_date::date = '2020-06-14';

--и применяем not exists, чтобы отбразить пустые места
select s.seat_no
from seat s
where aircraft_id = 1
and not exists(select t.seat_no
               from ticket t
                        join flight f
                             on f.id = t.flight_id
               where f.flight_no = 'MN3002'
                 and f.departure_date::date = '2020-06-14'
                 and s.seat_no = t.seat_no); --и выводим два конкретных свободных места

--еще есть 3 вариант решения:
select aircraft_id, s.seat_no
from seat s
where aircraft_id = 1
except
select f.aircraft_id, t.seat_no
from ticket t
         join flight f
              on f.id = t.flight_id
where f.flight_no = 'MN3002'
  and f.departure_date::date = '2020-06-14';




-- ЗАПРОС №3. Какие 2 перелета были самые длительные за все время?

-- поскольку нас интересуют перелету то выборку делаем из таблицы flight
select f.id,
       f.arrival_date,
       f.departure_date,
       f.arrival_date - f.departure_date
from flight f
order by (f.arrival_date - f.departure_date) DESC; --сортируем перелеты по разнице между прилетом и вылетом

--и сделаем немного более информативный вывод
select f.id,
       f.arrival_date::time,
       f.departure_date::time,
       (f.arrival_date - f.departure_date)::time AS interval
from flight f
order by (f.arrival_date - f.departure_date) DESC;

--и наконец отсекаем лишние перелеты, оставляя лишь 2 самых длительных по условию задачи:
select f.id,
       f.arrival_date::time,
       f.departure_date::time,
       (f.arrival_date - f.departure_date)::time AS interval
from flight f
order by (f.arrival_date - f.departure_date) DESC
LIMIT 2;





-- ЗАПРОС №4. Какая максимальная и минимальная продолжительность перелетов между Минском и Лондоном

--сначала делаем выборку по времени перелетов. Для этого применим оконные функции
select f.id,
       first_value((f.arrival_date - f.departure_date)::time) over () --берем первое значение интервала и over будет вся таблица
from flight f
join airport a
    on a.code = f.arrival_airport_code --джойним табу аэропорта прилета
join airport d
    on d.code = f.departure_airport_code  --джойним табу аэропорта вылета
where a.city = 'Лондон' --выбираем аэропорт прилета
  and d.city = 'Минск'; --выбираем аэропорт вылета
  --получили 3 перелета с айди 1, 3 и 9

--теперь сортируем полеты по продолжительности
select f.id,
       first_value((f.arrival_date - f.departure_date)::time)
           over (order by (f.arrival_date - f.departure_date) desc) as max_value,
       first_value((f.arrival_date - f.departure_date)::time)
       over (order by (f.arrival_date - f.departure_date)) as min_value
from flight f
         join airport a
              on a.code = f.arrival_airport_code
         join airport d
              on d.code = f.departure_airport_code
where a.city = 'Лондон' --выбираем аэропорт прилета
  and d.city = 'Минск'; --выбираем аэропорт вылета

--и покажем кол-во таких перелетов
select
       first_value((f.arrival_date - f.departure_date)::time)
       over (order by (f.arrival_date - f.departure_date) desc) as max_value,
       first_value((f.arrival_date - f.departure_date)::time)
       over (order by (f.arrival_date - f.departure_date)) as min_value,
       count(*) over ()
from flight f
         join airport a
              on a.code = f.arrival_airport_code
         join airport d
              on d.code = f.departure_airport_code
where a.city = 'Лондон' --выбираем аэропорт прилета
  and d.city = 'Минск' --выбираем аэропорт вылета
limit 1; --ограничиваем выборку 1 строчкой






-- ЗАПРОС №4. Какие имена встречаются чаще всего и какую долю от числа всех пассажиров они составляют

--пассажиры находятся в билетах, поэтому обращаемся к таблице билетов
select t.passenger_name --отображаем имена пассажиров из всех билетов
from ticket t; --получили 55 строчек

--теперь узнаем сколько пассажиров с одинаковым именем
select t.passenger_name, count(*)
from ticket t
group by t.passenger_name; --схлопнули выборку и получили 39 имен с кол-вом их повторов во второй колонке

--отсортируем пассажиров по возрастанию повторов
select t.passenger_name,
       count(*)
from ticket t
group by t.passenger_name
order by 2 desc; --выбрали на сортировку 2 столбец указанный в селекте

--в подзапросе узнаем разницу между кол-вом пассажиров за все время и кол-вом повторов
select t.passenger_name,
       count(*),
       (select count(*) from ticket) - count(*)
from ticket t
group by t.passenger_name
order by 2 desc;

--теперь узнаем долю повторов от общего кол-ва пассажиров
select t.passenger_name,
       count(*),
       round(100.0 * count(*) / (select count(*) from ticket), 2) --обычное пропорциональное отношение. округляем до 2 знаков
from ticket t
group by t.passenger_name
order by 2 desc;





-- ЗАПРОС №4. Вывести имена пассажиров, сколько всего каждый с таким именем купил билетов,
-- а также на сколько это количество меньше от того имени пассажира, кто купил билетов больше всего

-- опять обращаемся к таблице билетов, отображаем номер и имя, а также кол-во купленных каждым пассажиром билетов
select t.passenger_no,
       t.passenger_name,
       count(*)
from ticket t
group by t.passenger_no, t.passenger_name;

--сортируем по кол-ву купленных билетов
select t.passenger_no,
       t.passenger_name,
       count(*)
from ticket t
group by t.passenger_no, t.passenger_name
order by 3 desc ;

--делаем подзапрос и применяем оконную функцию
select t1.*,
       first_value(t1.cnt) over ()
from (
select t.passenger_no,
       t.passenger_name,
       count(*) cnt
from ticket t
group by t.passenger_no, t.passenger_name
order by 3 desc) t1;

--от максимального кол-ва отнимаем кол-во билетов у каждого пассажира и отображаем эту разницу
select t1.*,
       (first_value(t1.cnt) over () - t1.cnt) delta
from (
         select t.passenger_no,
                t.passenger_name,
                count(*) cnt
         from ticket t
         group by t.passenger_no, t.passenger_name
         order by 3 desc) t1;



-- ЗАПРОС №4. Вывести стоимость всех маршрутов по убыванию.
-- Отобразить разницу в стоимости между текущим и ближайшими в отсортированном списке маршрутами

--узнаем сумму всех стоимостей билетов во всех полетах
select t.flight_id,
       sum(t.cost) sum_cost
from ticket t
group by t.flight_id
order by 2 desc ; --отсортируем по стоимости по убыванию

--вводим подзапрос и применяем оконную функцию
select t1.*, --обращаемся ко всем полям подзапроса
       lead(t1.sum_cost) over (order by t1.sum_cost) --функция lead показывает следующий элемент в строчке
    from (
    select t.flight_id,
       sum(t.cost) sum_cost
from ticket t
group by t.flight_id
order by 2 desc) t1;

--избавляеемся от NULL в последней строчке
select t1.*, --обращаемся ко всем полям подзапроса
       coalesce(lead(t1.sum_cost) over (order by t1.sum_cost), 0) --меняем null на 0
from (
         select t.flight_id,
                sum(t.cost) sum_cost
         from ticket t
         group by t.flight_id
         order by 2 desc) t1;

--теперь выведем разницу
select t1.*,
       coalesce(lead(t1.sum_cost) over (order by t1.sum_cost), t1.sum_cost) - t1.sum_cost
from (
         select t.flight_id,
                sum(t.cost) sum_cost
         from ticket t
         group by t.flight_id
         order by 2 desc) t1;



