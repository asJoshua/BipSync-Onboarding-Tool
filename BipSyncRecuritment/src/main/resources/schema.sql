drop table if exists user_roles;
drop table if exists users;
drop table if exists recruits;
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
)engine = InnoDB;

create table if not exists recruits
(
    recruitId bigint AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    dateOfBirth varchar(50) not null,
    phoneNumber int not null,
    passportNumber int not null,
    nationalInsuranceNumber varchar(50) not null,
    email varchar(50) not null,
    position varchar(50) not null,
    dateOfHire varchar(50) not null,
    emergencyContactName varchar(50) not null,
    emergencyContactPhone int not null
)engine = innoDB;

