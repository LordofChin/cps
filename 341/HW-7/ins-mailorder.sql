-- ins-mailorder.sql
-- inserts tuples into the mailorder DB
-- ITC 341 partial hw7

-- keep these two commands at the top of every sql file
set echo on
set linesize 150
set pagesize 120

delete from ZIPCODES;
commit;
insert into ZIPCODES values ('67226', 'Wichita');
insert into ZIPCODES values ('60606', 'Fort Dodge');
insert into ZIPCODES values ('50302', 'Kansas City');
insert into ZIPCODES values ('54444', 'Colombia');
insert into ZIPCODES values ('66002', 'Liberal');
insert into ZIPCODES values ('61111', 'Fort Hays');

delete from EMPLOYEES;
commit;
insert into EMPLOYEES values (1000, 'Jones', '67226', '12-DEC-95');
insert into EMPLOYEES values (1001, 'Smith', '60606', '01-JAN-92');
insert into EMPLOYEES values (1002, 'Brown', '50302', '01-SEP-94');

-- ADD the rest

