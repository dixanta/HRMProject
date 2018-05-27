create table companies(id serial primary key,name varchar(50),email varchar(100),logo varchar(255),
contact_person varchar(100),phone_no varchar(20),mobile_no varchar(20),
address varchar(255),lat varchar(20),lng varchar(20),created_at timestamp
default current_timestamp,updated_at timestamp null,status boolean);

create table personnels(id serial primary key,
salute enum('Mr','Mrs','Miss','Mrs'),
first_name varchar(50),last_name varchar(50),
email varchar(100),contact_no varchar(20),
address varchar(255),created_at timestamp
default current_timestamp,updated_at timestamp null,status boolean);


create table demands(id serial primary key,
title varchar(255),description text,company_id int,
openings int,deadline date,salary int,created_at timestamp
default current_timestamp,updated_at timestamp null,status boolean);

create table demand_followups(id serial primary key,
message text,demand_id int, next_followup_date date,
created_at timestamp
default current_timestamp,updated_at timestamp null);

create table mst_skills(id serial primary key,
skill_name varchar(50));


create table mst_educations(id serial primary key,
education_name varchar(100));

create table mst_email_templates(id serial primary key,
title varchar(255),slug varchar(255),description text,created_at timestamp
default current_timestamp,updated_at timestamp null,status boolean);

create table settings(id serial primary key,name varchar(100) unique,
value text);

create table mst_socials(id serial primary key, name varchar(100)
unique,created_at timestamp
default current_timestamp,updated_at timestamp null,status boolean);


