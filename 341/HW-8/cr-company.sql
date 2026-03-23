-- cr-company.sql
-- creates the COMPANY DB-schema
-- partial

-- ALSO SEE figures 4.1 and 4.2 of Text (Elmasri 6th Ed.)

-- keep these two commands at the top of every sql file
set echo on
set linesize 150
set pagesize 120

drop table Employee cascade constraints;
commit;

create table Employee 
(
	fname varchar2(15),
	minit varchar2(1), -- can be char
	lname varchar2(15),
	ssn char(9),
	bdate date,
	address varchar2(50),
	sex varchar2(1) 	CHECK(Sex = 'M' or Sex = 'F'),
	salary number, -- need to put check on salary 
	superssn char(9),
	dno number	DEFAULT 0,
	constraint EMPPK
	    primary key(ssn),
	constraint EMPSUPERVRFK
	    foreign key(superssn) references Employee(ssn)
	    	ON DELETE SET NULL
--
--   Note:
--	ON DELETE SET DEFAULT, ON UPDATE CASCADE
-- Oracle does not support cascading updates, and does not allow you to set the value to the default 
-- when the parent row is deleted. Your two options for an on delete behavior are cascade or set null. 
-- Tested: February 05, 2018
--	, constraint EMPDEPTFK 
--		foreign key(dno) references Department(dnumber) 
--			ON DELETE SET NULL
-- ERROR - Department table has not been created yet
-- need to postpone this constraint
-- use alter table command to add this constraint
-- alter table Employee add constraint EMPDEPTFK 
--     foreign key(dno) references Department(dnumber) 
--     ON DELETE SET NULL
);

drop table Department cascade constraints;
commit;
create table Department 
(
	dname varchar2(15) 	NOT NULL,
	dnumber number,
	mgrssn char(9)		DEFAULT '000000000',
	mgrstartdate date,
	constraint DEPTPK
	    primary key(dnumber),
	constraint DEPTMGRFK
	    foreign key(mgrssn) references Employee(ssn)
			ON DELETE SET NULL 
--
--		ON DELETE SET DEFAULT, ON UPDATE CASCADE  
--
-- The above actions for DELETE SET DEFAULT and for UPDATE CASCADE does not work
-- with  the current SQL-plus version we have at this time. 
-- Just use SET NULL for delete and disable the update action part of the constraint.
--
);

alter table Employee add 
	constraint EMPDEPTFK foreign key(dno) references Department(dnumber) 
	ON DELETE SET NULL;

-- ADD the rest
