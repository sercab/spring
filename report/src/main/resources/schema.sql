drop table if exists Users ;
drop table if exists Roles;

create table Users (
  user_name varchar(15) not null primary key,
  user_pass varchar(15) not null
);

create table Roles (
  user_name varchar(15) not null,
  role_name varchar(15) not null,
  primary key (user_name, role_name)
);