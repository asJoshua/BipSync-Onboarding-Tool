insert into users(username, password, user_first_name,user_last_name)
values ('admin', '$2a$12$zgJ04j8phmDynatHoce5iOt./pMZ1uNDlBsfiWJrUJlxg9InTzt3C','Heather','Perkins');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');
insert into users(username, password, user_first_name,user_last_name)
values ('test', '$2a$12$4ns3D5/4F9k2YhkBO19onejm.DIhCZC/xyxJnRdMkzQm7b1BjBSEO','test','test');
insert into user_roles(role_id, user_role)
values(1,'ADMIN');

insert into recruits(first_name, last_name, date_of_birth, phone_number, passport_number, national_insurance_number, email, position, date_of_hire, emergency_contact_name, emergency_contact_phone)
values ('Heather', 'Perkins', '1999/02/17', '0778823744', '123456', '12456', 'hperkins@bipsync.com', 'Head of onboarding', '2020/01/02', 'Beatriz', '012345678')

