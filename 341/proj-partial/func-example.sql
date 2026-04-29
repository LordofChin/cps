-- CPS 541/ITC 341, 441 - PLSQL Function example-1 
-- Dr. Ugur
--

set echo on;
set linesize 150;
set pagesize = 120
set serveroutput on;
set timing on;

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
-- **** Test1: in PLSQL: function call in a PLSQL code ****
declare 
	deptname department.dname%type;
begin
-- function call
	deptname := get_dept_name('123456789'); 
	dbms_output.put_line('dept name for ' || '123456789' || ' is ' || deptname);

-- function call   
	deptname := get_dept_name('111111111');
	if deptname != '' then
		dbms_output.put_line('dept name for ' || '111111111' || ' is ' || deptname);
	end if;
end;
/

-- Test 2:  in SQL: using the function in a query
select get_dept_name('123456789') from dual;
select get_dept_name('111111111') from dual;

-- below will call the function for every sssn
select ssn, fname, lname, get_dept_name(ssn) as DEPTNAME
from employee;

select lname || ', ' || fname || ' ' || 'works at ' || get_dept_name(ssn) || '.' as EMP_DEPT_INFO
from employee;

-- undo changes that are done for testing only, if you make a change to a table, 
-- you can undo a change by 'rollback'
-- rollback; 
-- no rollback is needed for the get_dept_name function

