-- cr-mailorder.sql
-- creates the mailorder DB-schema
-- ITC 341 partial hw7 (Homework #7)

-- keep these three commands at the top of every sql file
set echo on
set linesize 150
set pagesize 120

drop table ZIPCODES cascade constraints;
commit;

-- better way of declaring primary key and foreign key 
-- using constraint declaration
create table ZIPCODES
(
	zip 		char(5),
	city 		varchar2(20),
	constraint ZIPPK
	    primary key(zip)
);

-- another way of declaring primary key
--create table ZIPCODES2
--(
--	zip 		char(5) primary key,
--	city 		varchar2(20),
--);

-- one another way of declaring primary key
--create table ZIPCODES3
--(
--	zip 		char(5),
--	city 		varchar2(20),
--	primary key(zip)
--);

drop table EMPLOYEES cascade constraints;
commit;

create table EMPLOYEES 
(
	eno 		number,
	ename 		varchar2(20),
	zip 		char(5),
	hdate 		date,
	constraint 	EMPSPK
	    primary key(eno),
	constraint 	EMPSZIPFK
	    foreign key(zip) references ZIPCODES(zip)
	    	ON DELETE SET NULL
);


-- ADD the rest
