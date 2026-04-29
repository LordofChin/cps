-- project.sql
-- Dr. Ugur
--

set echo on;
set linesize 150;
set pagesize = 120
set serveroutput on;
set timing on;

-- part 3
- (sample solution for the department table only)
create or replace trigger dept_trigger
after insert on department
begin
	update department SET dname = upper(dname);
end;
/
show errors

-- **** Test **** --
-- before update
select * from department; 

-- update - lowercase dname
insert into Department values ('Lab', 9, '333445555', null);

-- notice that dnames are all uppercase now
select * from department; 

-- undo the update (insert)
delete from department where dnumber = 9; 

-- notice that dnames are all lowercase now
select * from department;

-- ADD triggers for the other tables and their testing below


-- part 4
-- Function that returns Dname from Department for any given employee. 
-- The parameter to the function is the SSN.

CREATE OR REPLACE FUNCTION get_dept_name(EMPSSN IN employee.ssn%type)
   RETURN department.dname%type
IS 
   mm department.dname%type;
BEGIN
   mm := '';  -- initially empty value 

   SELECT dname into mm FROM EMPLOYEE E, DEPARTMENT D 
   WHERE E.DNO = D.DNUMBER AND E.SSN = EMPSSN ;

   RETURN(mm);

-- exception handling

   exception
     when NO_DATA_FOUND then
       dbms_output.put_line('No data found');
       RETURN(mm);

END;
/
show errors

-- TEST the function get_dept_name, either Test1 or Test2 is sufficient 

-- Test 2:  in SQL: using the function in a query
select get_dept_name('123456789') from dual;
select get_dept_name('111111111') from dual;

-- Test 1: below will call the function for every sssn
-- select lname || ', ' || fname || ' ' || 'works at ' || get_dept_name(ssn) || '.' as EMP_DEPT_INFO
from employee;

-- ADD parts 5-8 below



