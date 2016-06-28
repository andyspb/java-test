create table employee(id INT NOT NULL auto_increment, first_name VARCHAR(20) default NULL, last_name  VARCHAR(20) default NULL, salary INT default NULL, PRIMARY KEY (id));
create table employee_address(id INT NOT NULL auto_increment, e_Id INT, country VARCHAR(20) default NULL, city VARCHAR(20) default NULL, adress VARCHAR(20) default NULL, post_code INT default NULL, PRIMARY \ KEY (id), FOREIGN KEY (e_Id) REFERENCES employee(id));
create table employee_roles(id INT NOT NULL auto_increment, e_Id INT, country VARCHAR(20) default NULL, position VARCHAR(20) default NULL, PRIMARY KEY (id), FOREIGN KEY (e_Id) REFERENCES employee(id));

alter table Persons CHANGE FirstName first_name VARCHAR(20) default NULL;
Aalter table Persons CHANGE PersonID id int;


CREATE TABLE Persons (PersonID int PRIMARY KEY, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255));
CREATE TABLE Customers (CustomerID int PRIMARY KEY, Manager varchar(255));


insert into Customers(CustomerID, Manager) values (1, 'Laskin');
insert into Customers(CustomerID, Manager) values (2, 'Laskin');
insert into Customers(CustomerID, Manager) values (4, 'Laskin');
insert into Customers(CustomerID, Manager) values (3, 'Bobk');
insert into Customers(CustomerID, Manager) values (5, 'Bobk');
insert into Customers(CustomerID, Manager) values (6, 'Bobk');
insert into Customers(CustomerID, Manager) values (21, 'Pop');
insert into Customers(CustomerID, Manager) values (22, 'Pop');
insert into Customers(CustomerID, Manager) values (23, 'Pop');
insert into Customers(CustomerID, Manager) values (24, 'Pop');

CREATE TABLE Countries (CountryID int PRIMARY KEY, Country varchar(255));

insert into Countries(CountryID, Country) values (1, 'US');
insert into Countries(CountryID, Country) values (2, 'RU');
insert into Countries(CountryID, Country) values (3, 'FI');
insert into Countries(CountryID, Country) values (4, 'GE');
insert into Countries(CountryID, Country) values (5, 'LV');
insert into Countries(CountryID, Country) values (6, 'SW');
insert into Countries(CountryID, Country) values (7, 'ME');
RENAME TABLE Persons TO person;
