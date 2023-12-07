insert into users(username, password, user_first_name,user_last_name)
values ('admin', '$2a$12$zgJ04j8phmDynatHoce5iOt./pMZ1uNDlBsfiWJrUJlxg9InTzt3C','Heather','Perkins');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');
insert into users(username, password, user_first_name,user_last_name)
values ('test', '$2a$12$4ns3D5/4F9k2YhkBO19onejm.DIhCZC/xyxJnRdMkzQm7b1BjBSEO','test','test');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');


insert into recruits(firstName, lastName)
values('Heather', 'Perkins')

insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(1,'Add to Company group lists and calenders','2023/12/20','HR');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(2,'Create email accounts','2023/12/17','IT');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(3,'Prepare Contracts','2023/12/15','HR');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(4,'Sign contracts,tax forms','2023/12/18','HR');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(5,'Check confirmation of work permits','2023/12/14','HR');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(6,'Ensure correct IT equipment is updated and ready to use','2023/12/28','IT');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(7,'Set up Desk','2023/12/28','Facilities');
insert into tasks(task_id, task_name, task_due_date, task_responsibility)
values(8,'Ensure all access cards are prepared','2023/12/27','IT');


insert into employee_tasks(t_recruit_id, t_task_id) values(1,1);
insert into employee_tasks(t_recruit_id, t_task_id) values(4,2);
insert into employee_tasks(t_recruit_id, t_task_id) values(1,3);
insert into employee_tasks(t_recruit_id, t_task_id) values(2,4);
insert into employee_tasks(t_recruit_id, t_task_id) values(5,5);
insert into employee_tasks(t_recruit_id, t_task_id) values(3,6);
insert into employee_tasks(t_recruit_id, t_task_id) values(4,7);
