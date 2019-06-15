create user 'projectuser'@'%' identified by 'password=boB4.321';
drop database if exists test_exam;
create database test_exam;
use test_exam;
grant all privileges on test_exam.* to 'projectuser'@'%';
flush privileges;
