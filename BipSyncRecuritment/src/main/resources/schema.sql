#create database bipsync;
drop table if exists user_roles;
drop table if exists users;
use bipsync;
create table if not exists users


(
     id bigint AUTO_INCREMENT PRIMARY KEY,
     username varchar(500)  not null,
     password varchar(500) not null,
     user_first_name varchar(50) not null,
     user_last_name varchar(50) not null
     ) engine = InnoDB;

 create table if not exists user_roles(
     role_id bigint,
     user_role varchar(50),
     FOREIGN KEY (role_id) REFERENCES users(id)
)engine = InnoDB;;


create table if not exists StaffInfo


(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    name varchar(500)  not null,
    surname varchar(500)  not null,
    email varchar(500)  not null,
    role varchar(500)  not null
)engine = InnoDB;


