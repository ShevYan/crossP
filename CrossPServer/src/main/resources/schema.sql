DROP table if exists users;
DROP table if exists authorities;

create table users (
  id int primary key auto_increment not null,
  username varchar(256),
  password varchar(256),
  enabled boolean
);

create table authorities (
  id int primary key auto_increment not null,
  username varchar(256),
  authority varchar(256)
);