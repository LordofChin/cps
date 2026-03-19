-- ins-mailorder.sql
-- inserts tuples into the mailorder DB
-- Carter Tufts
-- ITC 341	Homework 7	Mar. 18, 2026

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

delete from PARTS;
commit;
insert into PARTS values (10506, 'Land Before Time I', 200, 19.99, 20);
insert into PARTS values (10507, 'Land Before Time II', 156, 19.99, 20);
insert into PARTS values (10508, 'Land Before Time III', 190, 19.99, 20);
insert into PARTS values (10509, 'Land Before Time IV', 60, 19.99, 20);
insert into PARTS values (10601, 'Sleeping Beauty', 300, 24.99, 20);
insert into PARTS values (10701, 'When Harry Met Sally', 120, 19.99, 30);
insert into PARTS values (10800, 'Dirty Harry', 140, 14.99, 30);
insert into PARTS values (10900, 'Dr. Zhivago', 100, 24.99, 30);

delete from CUSTOMERS;
commit;
insert into CUSTOMERS values (1111, 'Charles', '123 Main St.', '67226', '316-636-5555');
insert into CUSTOMERS values (2222, 'Bertram', '237 Ash Ave.', '67226', '316-689-5555');
insert into CUSTOMERS values (3333, 'Barbara', '111 Inwood St.', '60606', '316-111-1234');

delete from ORDERS;
commit;
INSERT INTO ORDERS VALUES (1020, 1111, 1000, TO_DATE('10-DEC-94', 'DD-MON-RR'), TO_DATE('12-DEC-94', 'DD-MON-RR'));
INSERT INTO ORDERS VALUES (1021, 1111, 1000, TO_DATE('12-JAN-95', 'DD-MON-RR'), TO_DATE('15-JAN-95', 'DD-MON-RR'));
INSERT INTO ORDERS VALUES (1022, 2222, 1001, TO_DATE('13-FEB-95', 'DD-MON-RR'), TO_DATE('20-FEB-95', 'DD-MON-RR'));
INSERT INTO ORDERS VALUES (1023, 3333, 1000, TO_DATE('20-JAN-97', 'DD-MON-RR'), NULL);

delete from ODETAILS;
commit;
insert into ODETAILS values (1020, 10506, 1);
insert into ODETAILS values (1020, 10507, 1);
insert into ODETAILS values (1020, 10508, 2);
insert into ODETAILS values (1020, 10509, 3);
insert into ODETAILS values (1021, 10601, 4);
insert into ODETAILS values (1022, 10601, 1);
insert into ODETAILS values (1022, 10701, 1);
insert into ODETAILS values (1023, 10800, 1);
insert into ODETAILS values (1023, 10900, 1);