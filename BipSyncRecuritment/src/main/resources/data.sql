insert into users(username, password, user_first_name,user_last_name)
values ('admin', '$2a$12$zgJ04j8phmDynatHoce5iOt./pMZ1uNDlBsfiWJrUJlxg9InTzt3C','Heather','Perkins');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');
insert into users(username, password, user_first_name,user_last_name)
values ('test', '$2a$12$4ns3D5/4F9k2YhkBO19onejm.DIhCZC/xyxJnRdMkzQm7b1BjBSEO','test','test');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');

insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Emily', 'Thompson', '1999/02/17', '0778823744', '123456789', 'AD12456Z', 'ethompson@bipsync.com', 'Software Engineer', '2020/01/02', 'Beatriz', '07654876879');

insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Ethan', 'Rodriguez', '1996/04/27', '07876145523', '876543657', 'AB876590Z', 'erodriguez@bipsync.com', 'Data Analyst', '2020/03/12', 'Jonny', '09898765431');

insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Ava', 'Patel', '2000/08/03', '07943567892', '768798678', 'AL097869C', 'apatel@bipsync.com', 'Data Analyst', '2021/05/23', 'Liam', '07898765567');
insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Noah', 'Davis', '1998/04/03', '07957897895', '458798698', 'AW092869B', 'ndavis@bipsync.com', 'Data Analyst', '2022/06/12', 'Sarah', '07657465812');
insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Harper', 'Mitchell', '1997/10/18', '07865434545', '765678932', 'JW134678D', 'apatel@bipsync.com', 'Software Engineer', '2023/07/14', 'Josh', '079345789');

insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(1,'Add to Company group lists and calenders','2023/12/20','HR','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(2,'Create email accounts','2023/12/01','IT','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(3,'Prepare Contracts','2023/12/15','HR','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(4,'Sign contracts,tax forms','2023/12/06','HR','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(5,'Check confirmation of work permits','2023/12/14','HR','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(6,'Ensure correct IT equipment is updated and ready to use','2023/12/13','IT','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(7,'Set up Desk','2023/12/14','Facilities','testingforproject2023@gmail.com');
insert into tasks(task_id, task_name, task_due_date, task_responsibility,task_department_email)
values(8,'Ensure all access cards are prepared','2023/11/30','IT','testingforproject2023@gmail.com');


insert into employee_tasks(t_recruit_id, t_task_id) values(1,1);

insert into employee_tasks(t_recruit_id, t_task_id) values(1,4);
insert into employee_tasks(t_recruit_id, t_task_id) values(1,5);
insert into employee_tasks(t_recruit_id, t_task_id) values(1,8);
insert into employee_tasks(t_recruit_id, t_task_id) values(2,1);
insert into employee_tasks(t_recruit_id, t_task_id) values(2,6);
insert into employee_tasks(t_recruit_id, t_task_id) values(3,4);
insert into employee_tasks(t_recruit_id, t_task_id) values(3,5);;
insert into employee_tasks(t_recruit_id, t_task_id) values(3,8);
insert into employee_tasks(t_recruit_id, t_task_id) values(4,1);
insert into employee_tasks(t_recruit_id, t_task_id) values(4,2);
insert into employee_tasks(t_recruit_id, t_task_id) values(4,3);
insert into employee_tasks(t_recruit_id, t_task_id) values(4,8);
insert into employee_tasks(t_recruit_id, t_task_id) values(5,1);
insert into employee_tasks(t_recruit_id, t_task_id) values(5,6);
insert into employee_tasks(t_recruit_id, t_task_id) values(5,7);
insert into employee_tasks(t_recruit_id, t_task_id) values(5,8);


