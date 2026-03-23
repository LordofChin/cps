-- q-company.sql
-- partial queries

-- keep these two commands at the top of every sql file
set echo on
set linesize 150
set pagesize 120

-- test queries
select count(*) from employee;
select count(*) as DEPT_COUNT from department;
-- need more here

-- your homework queries goes here

-- a: the first name, last name of employees who work in department 5.
select fname, lname from employee where dno = 5;

-- b: the first name, last name of every employee and name of his/her department

-- 'as' is optional and can be omitted
-- FIRST_NAME, LAST_NAME, DEPARTMENT_NAME are column aliases
-- E, D are table aliases

select E.fname as FIRST_NAME, E.lname LAST_NAME, D.dname DEPARTMENT_NAME
from employee E, department D
where E.dno = D.dnumber;

-- ADD the rest
