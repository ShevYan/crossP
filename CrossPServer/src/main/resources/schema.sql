--DROP table if exists users;
--DROP table if exists authorities;



create table if not exists users (
  id int primary key auto_increment not null,
  username varchar(256),
  password varchar(256),
  enabled boolean
) ;

create table if not exists authorities (
  id int primary key auto_increment not null,
  username varchar(256),
  authority varchar(256)
);

delete from users where username = 'admin';
delete from users where username = 'user';
delete from users where username = 'api';

delete from authorities where username = 'admin';
delete from authorities where username = 'user';
delete from authorities where username = 'api';