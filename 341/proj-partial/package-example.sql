-- CPS 541/ITC 341, 441 - PLSQL- Package example-1
-- Dr. Ugur
--

set echo on;
set linesize 150;
set pagesize = 120
set serveroutput on;
set timing on;


-- Package that includes methods to:
-- 1. display department name for an existing  employee
-- 2. count the number of existing employees
-- 3. count the number of employees  for a department, dnumber is given 

-- **** Package Declaration **** --
create or replace package emp_package as
    procedure get_dept_name(eno in employee.ssn%type);
    procedure count_emps;
    procedure count_emps_dept(DNUM in department.dnumber%type);
end;
/
show errors

-- **** Package Body **** --
create or replace package body emp_package as

    procedure get_dept_name(eno in employee.ssn%type)
    as
		dn varchar2(30);
    begin
		dn := '';  -- initially empty value 
		select d.dname into dn from employee e, department d
		where e.ssn = eno and e.dno = d.dnumber;
    
		dbms_output.put_line('Department name of emp. ' || eno || ' is ' || dn);

		-- exception handling
		exception
		when NO_DATA_FOUND then
			dbms_output.put_line('No data found');
    end;
	
    procedure count_emps
    as
		cnt number;
    begin
		select count(*) into cnt from employee;
		
		dbms_output.put_line('# of employees : ' || cnt);
    end;
	
    procedure count_emps_dept(DNUM in department.dnumber%type)
    as
		cnt number;
    begin
		select count(*) into cnt from employee where dno = DNUM;
		
		dbms_output.put_line('# of employees for department ' || DNUM || ': ' || cnt);
    end;

end;
/
show errors


-- **** Test **** --
exec emp_package.get_dept_name('123456789');

exec emp_package.get_dept_name('111111111');

exec emp_package.count_emps;

exec emp_package.count_emps_dept(4);
exec emp_package.count_emps_dept(3);

-- undo changes that are done for testing, if you make a change to a table, 
-- you can undo that change by 'rollback'
-- rollback;
-- no rollback is needed for the package elements above

