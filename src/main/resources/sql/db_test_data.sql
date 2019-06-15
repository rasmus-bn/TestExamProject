
insert into course (subject, hours, startDate, endDate)
values ('English',80,'2019-7-04','2019-10-04');
set @english1 = last_insert_id();
insert into course (subject, hours, startDate, endDate)
values ('English',50,'2019-7-04','2019-10-04');
set @english2 = last_insert_id();
insert into course (subject, hours, startDate, endDate)
values ('Math',70,'2019-7-04','2019-10-04');
set @math1 = last_insert_id();
insert into course (subject, hours, startDate, endDate)
values ('Math',70,'2019-7-04','2019-10-04');
set @math2 = last_insert_id();
insert into course (subject, hours, startDate, endDate)
values ('Spanish',70,'2019-7-04','2019-10-04');
set @spanish1 = last_insert_id();

insert into student (name, email, birthday)
values ('Bob','bob@bob.com','1980-10-04');
set @new_student_id = last_insert_id();
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @math2, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @spanish1, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @english2, true);

insert into student (name, email, birthday)
values ('Carl','c@c.com','1981-10-04');
set @new_student_id = last_insert_id();
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @math2, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @spanish1, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @english2, true);

insert into student (name, email, birthday)
values ('John','j@j.com','1989-10-04');
set @new_student_id = last_insert_id();
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @math2, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @spanish1, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @english2, true);

insert into student (name, email, birthday)
values ('Jack','ja@ja.com','1971-10-04');
set @new_student_id = last_insert_id();
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @math2, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @spanish1, true);
insert into enrollment (student_id, course_id, payed)
values (@new_student_id, @english2, true);




