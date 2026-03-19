-- cr-mailorder.sql
-- creates the mailorder DB-schema
-- Carter Tufts
-- ITC 341	Homework 7	Mar. 18, 2026

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
	zip char(5),
	city varchar2(20),
	constraint ZIPPK
	    primary key(zip)
);

-- another way of declaring primary key
--create table ZIPCODES2
--(
--	zip char(5) primary key,
--	city varchar2(20),
--);

-- one another way of declaring primary key
--create table ZIPCODES3
--(
--	zip char(5),
--	city varchar2(20),
--	primary key(zip)
--);

drop table EMPLOYEES cascade constraints;
drop table PARTS cascade constraints;
drop table CUSTOMERS cascade constraints;
drop table ORDERS cascade constraints;
drop table ODETAILS cascade constraints;
commit;

create table EMPLOYEES 
(
	eno number,
	ename varchar2(20),
	zip char(5),
	hdate date,
	constraint EMPSPK
	    primary key(eno),
	constraint EMPSZIPFK
	    foreign key(zip) references ZIPCODES(zip)
	    	ON DELETE SET NULL
);

create table PARTS
(
	pno number,
	pname varchar2(20),
	qoh number,
	price float,
	plevel number,
	constraint PRTSPK
		primary key(pno)
);

create table CUSTOMERS
(
	cno number,
	cname varchar2(20),
	street varchar2(20),
	zip char(5),
	phone varchar2(12),
	constraint CUSTPK
		primary key(cno)
);

create table ORDERS
(
	ono number,
	cno number,
	eno number,
	received date,
	shipped date,
	constraint ORDRPK
		primary key(ono),
	constraint ORDR_CNO
		foreign key(cno) references CUSTOMERS(cno)
			ON DELETE SET NULL,
	constraint ORDR_ENO
		foreign key(eno) references EMPLOYEES(eno)
			ON DELETE SET NULL
);

create table ODETAILS
(
	ono number,
	pno number,
	qty number,
	constraint ODTLS_ONO
		foreign key(ono) references ORDERS(ono)
			ON DELETE SET NULL,
	constraint ODTLS_PNO
		foreign key(pno) references PARTS(pno)
			ON DELETE SET NULL,	
	constraint DTLSPK
		primary key(ono, pno)
);
