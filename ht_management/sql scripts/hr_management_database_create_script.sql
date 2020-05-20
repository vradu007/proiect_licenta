drop database if exists hr_management_database;
create database hr_management_database;
use hr_management_database;

create table Account(
	id int primary key auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    access_rights enum('VIEW_SELF','VIEW_ALL') not null,
    edit_rights enum('VIEW_ONLY','EDIT'),
    nickname varchar(50),
    employee_id int
);

create table Employee(
	id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    employment_date date not null,
    salary double not null,
    bonus_scheme double,
    address varchar(100),
    email varchar(50) not null,
    CNP varchar(13),
    phone_number varchar(10) not null,
    job_title varchar(50) not null,
    productivity_index double not null,
    department_id int
);

create table Department(
	id int primary key auto_increment,
    department_name varchar(50),
    maximum_capacity int,
    location varchar(50),
    taxes_percentage double,
    manager_id int
);

alter table Account
add foreign key (employee_id) references Employee(id)
on delete cascade
on update cascade;

alter table Employee
add foreign key (department_id) references Department(id)
on delete cascade
on update cascade;


insert into Department (department_name, maximum_capacity, location, taxes_percentage, manager_id) values 
('Development', 10, 'Bucuresti', 38, 1),
('HR', 5, 'Bucuresti', 45, 2),
('Vanzari', 15, 'Bucuresti', 45, 3),
('Tech Support', 45, 'Outsource', 45, 4),
('Management', 5, 'Bucuresti', 45, 5);
insert into Employee (first_name, last_name, employment_date, salary, bonus_scheme, address, email, CNP, phone_number, job_title, productivity_index, department_id) values 
('Radu','Voin','2013-01-25',11500,5,'Bucuresti','voin.radu@firma.ro','1950125460035','0123456789','programator',85,1),
('Decebal','Popescu','2014-07-01',8700,7,'Bucuresti','decebal.popescu@firma.ro','1740701234567','0123456789','specialist resurse umane',77,2),
('Ionescu','Ion','2015-08-21',9650,6,'Bucuresti','ionescu.ion@firma.ro','1591107234567','0123456789','agent vanzari',47,3),
('Emilia','Ionescu','2016-11-22',4700,4,'Cluj','emilia.ionescu@firma.ro','2840701234567','0123456789','operator suport tehnic',89,4),
('Andreea','Baciu','2009-07-01',18000,5,'Bucuresti','andreea.baciu@firma.ro','27940701234567','0123456789','manager general',48,5),
('Cristian','Oncescu','2016-07-01',5800,9,'Franta','cristian.oncescu@firma.ro','1920701234567','0123456789','operator suport tehnic',93,4);
insert into Account (username, password, access_rights, edit_rights, nickname, employee_id) values 
('vradu007','vradu007','VIEW_ALL','EDIT','vradu',1),
('vradu7','vradu7','VIEW_SELF','VIEW_ONLY','vradu7',1),
('decebalpop10','decebalpop10','VIEW_SELF','VIEW_ONLY','dp10',2),
('superdecebalpop10','superdecebalpop10','VIEW_ALL','EDIT','sdp10',2),
('ionion','ionion','VIEW_SELF','VIEW_ONLY','ion2x',3),
('emion','emion','VIEW_SELF','VIEW_ONLY','emy',4),
('andreea.baciu','andreea.baciu','VIEW_ALL','EDIT','andreea',5),
('crisonc','crisonc','VIEW_SELF','VIEW_ONLY','cris',6);
