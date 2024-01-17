insert into users(username,user_email, password, user_first_name,user_last_name)
values ('admin','testingforproject2023@gmail.com', '$2a$12$zgJ04j8phmDynatHoce5iOt./pMZ1uNDlBsfiWJrUJlxg9InTzt3C','Heather','Perkins');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');
insert into users(username,user_email, password, user_first_name,user_last_name)
values ('test','test@test.com', '$2a$12$4ns3D5/4F9k2YhkBO19onejm.DIhCZC/xyxJnRdMkzQm7b1BjBSEO','test','test');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');



insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Emily', 'Thompson', '17-02-1999', '0778823744', '123456789', 'AD12456Z', 'ethompson@bipsync.com', 'Software Engineer', '02-01-2020', 'Beatriz', '07654876879');

insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Ethan', 'Rodriguez', '27-04-1996', '07876145523', '876543657', 'AB876590Z', 'erodriguez@bipsync.com', 'Data Analyst', '12-03-2020', 'Jonny', '09898765431');

insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Ava', 'Patel', '03-08-2000', '07943567892', '768798678', 'AL097869C', 'apatel@bipsync.com', 'Data Analyst', '23-05-2021', 'Liam', '07898765567');
insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Noah', 'Davis', '03-04-1998', '07957897895', '458798698', 'AW092869B', 'ndavis@bipsync.com', 'Data Analyst', '12-06-2022', 'Sarah', '07657465812');
insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Harper', 'Mitchell', '18-10-1997', '07865434545', '765678932', 'JW134678D', 'hmitchell@bipsync.com', 'Software Engineer', '14-07-2023', 'Josh', '079345789');



insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(1,'Pending Dummy Test','2024/12/20','HR');

insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(2,'Pending Overdue Test','2023/12/20','HR');



insert into StaffInfo (name, surname, email, role) values ('Heather', 'Perkins', 'HeatherHR@bipsync.com', 'Hr Manager');
insert into StaffInfo (name, surname, email, role) values ('Ben', 'Shariff', 'BenShariffIT@bipsync.com', 'IT Manager');
insert into StaffInfo (name, surname, email, role) values ('Adrian ', 'Pennington', 'Pemmigton@bipsync.com', 'Senior software developer');
insert into StaffInfo (name, surname, email, role) values ('Chau', 'mai', 'ChaiMai@bipsync.com', 'Marketing Director');
insert into StaffInfo (name, surname, email, role) values ('Bill', 'Smith', 'BillSmithData@bipsync.com', 'Data Analyst');
insert into StaffInfo (name, surname, email, role) values ('Luke', 'Jones', 'LukeJonesDevOps@bipsync.com', 'Dev ops');

insert into employee_tasks(t_recruit_id, t_task_id) values(1,1);
insert into employee_tasks(t_recruit_id, t_task_id) values(2,2);
