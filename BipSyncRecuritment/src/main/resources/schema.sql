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

CREATE TABLE IF NOT EXISTS recruits (
                                        recruit_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        first_name VARCHAR(50) NOT NULL,
                                        last_name VARCHAR(50) NOT NULL,
                                        date_of_birth DATE NOT NULL,
                                        phone_number VARCHAR(15) NOT NULL,
                                        passport_number INT NOT NULL,
                                        national_insurance_number VARCHAR(20) NOT NULL,
                                        email VARCHAR(100) NOT NULL,
                                        position VARCHAR(50) NOT NULL,
                                        date_of_hire DATE NOT NULL,
                                        emergency_contact_name VARCHAR(100) NOT NULL,
                                        emergency_contact_phone VARCHAR(15) NOT NULL
) ENGINE=InnoDB;


