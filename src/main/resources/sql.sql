drop database roi;

drop user 'roi'@'localhost';

create database roi;


create user 'roi'@'localhost' identified by 'roi';
grant all privileges on roi.* to roi@localhost;

flush privileges;

create table roi.user(
id varchar(50) primary key,
pwd varchar(100) not null,
permission varchar(30) default 'viewer'
);

create table roi.reserver(
id integer primary key,
rname varchar(50) not null,
gender varchar(1),
nationality varchar(50),
phone varchar(20),
email varchar(50)
);

create table roi.reserve(
id integer primary key,
rtype varchar(20),
reserve_date timestamp not null,
room_no varchar(5),
chkin timestamp not null,
night integer not null,
rname varchar(50),
payPerDay integer,
deposit integer,
balance integer,
via varchar(50)
);

insert into roi.user(id, pwd, permission) values('admin', password('admin'), 'viewer');