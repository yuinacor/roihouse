drop database roihouse;

drop user 'roihouse'@'localhost';

create database roihouse;


create user 'roihouse'@'localhost' identified by 'roihouse';
grant all privileges on roihouse.* to roihouse@localhost;

flush privileges;

create table roihouse.user(
id varchar(50) primary key,
pwd varchar(100) not null,
permission varchar(30) default 'viewer'
);

create table roihouse.reserver(
id integer primary key auto_increment,
rname varchar(50) not null,
gender varchar(1),
nationality varchar(50),
phone varchar(20),
email varchar(50)
);

create table roihouse.reserve(
id integer primary key auto_increment,
rtype varchar(20),
reserve_date timestamp not null,
room_no varchar(5),
chkin timestamp not null,
nights integer not null,
reserver integer,
pay_per_day integer,
payment integer,
deposit integer,
balance integer,
via varchar(50),
memo varchar(500)
);

insert into roihouse.user(id, pwd, permission) values('admin', password('admin'), 'viewer');