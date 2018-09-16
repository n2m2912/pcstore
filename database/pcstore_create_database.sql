-- Create database
create database pcstore default character set utf8;

-- Create user and grant access to this database
create user 'pcstore'@'localhost' identified by 'Pcstore@123';
grant all privileges on pcstore.* to pcstore@localhost with grant option;