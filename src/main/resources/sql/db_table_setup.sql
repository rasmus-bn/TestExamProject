create user if not exists 'projectuser'@'%' identified by 'boB4.321';
drop database if exists test_exam;
create database test_exam;
grant all privileges on test_exam.* to 'projectuser'@'%';
flush privileges;

use test_exam;

create table course (
    id int primary key auto_increment,
    subject nvarchar(200) not null,
    hours int,
    startDate date,
    endDate date
);

create table student (
    id int primary key auto_increment,
    name nvarchar(500),
    email nvarchar(500),
    birthday date,
    unique(email)
);

create table enrollment (
    student_id int not null,
    course_id int not null,
    payed bool,
    primary key(student_id, course_id),
    foreign key (student_id) references student(id),
    foreign key (course_id) references course(id)
);

