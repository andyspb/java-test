--CREATE table countries (id int, name varchar(255));
--create table cities (id int, name varchar(255), country_id int, population int);
--INSERT INTO countries (1, 'US'), (2, 'China'),(3, 'India'),(4, 'Germany'),(5, 'Russia');

--INSERT INTO cities values 
--(1, 'NY', 1, 10000),(2, 'Washington', 1, 10000),(3, 'San-Francisko', 1, 10000),(4, 'Atlanta', 1, 10000),(5, 'Phoenix', 1, 10000),
--(6, 'ChinaCity1', 2, 5000),(7, 'ChinaCity2', 2, 5000),(8, 'ChinaCity3', 2, 5000),
--(9, 'IndiaCity1', 3, 4000),(10, 'IndiaCity2', 3, 4000),(11, 'IndiaCity3', 3, 4000),
--(12, 'GermanyCity1', 4, 3000),(13, 'GermanyCity2', 4, 3000),(14, 'GermanyCity3', 4, 3000),
--(15, 'Moscow', 5, 20000),(16, 'Saint Petersburg', 5, 20000),(17, 'Novgorod', 5, 20000),(18, 'Sochi', 5, 20000),(19, 'Anapa', 5, 20000);


select top 3 co.id, co.name, sum(ci.population) from countries as co join cities as ci on co.id=ci.country_id group by co.id, co.name order by sum(ci.population) desc;



--select * from countries;
--select * from cities;

--INSERT INTO countries VALUES (1, 'US'), (2, 'China'), (3, 'India'), (4, 'Germany'), (5, 'Russia');

--select * from countries  join cities on countries.id=cities.country_id group by countries.id;

--select country_id, sum(population) from cities group by country_id;

--select * from contries join (select country_id, sum(population) from cities group by country_id as res) on id=res.country_id;

--select top 3 co.id, co.name, sum(ci.population) from countries as co join cities as ci on co.id=ci.country_id group by co.id, co.name order by sum(ci.population) desc;

--select * from countries join (select sum(population) from cities where country_id=;