-- project.sql
-- Carter Tufts and Chala Ahmed
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
create or replace trigger employee_trigger 
after insert on employee 
begin 
UPDATE employee SET fname = upper(fname), lname = upper(lname), minit = upper(minit), address = upper(address);
end;
/
create or replace trigger dept_loc_trigger 
after insert on dept_locations 
begin 
UPDATE dept_locations SET dlocation = upper(dlocation);
end;
/
create or replace trigger project_trigger 
after insert on project 
begin 
UPDATE project SET pname = upper(pname), plocation = upper(plocation);
end;
/
create or replace trigger dependent_trigger 
after insert on dependent
begin 
UPDATE dependent SET dependent_name = upper(dependent_name), sex = upper(sex), relationship = upper(relationship);
end;
/


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
select lname || ', ' || fname || ' ' || 'works at ' || get_dept_name(ssn) || '.' as EMP_DEPT_INFO
from employee;

-- ADD parts 5-8 below

-- part 5
-- Implement a Function that returns manager’s full name for any given department. 
-- The parameter to the function would be the department name.

CREATE OR REPLACE FUNCTION get_manager_name(DEPTNAME IN department.dname%type)
   RETURN varchar2
IS 
	fn employee.fname%type;
	lnm employee.lname%type;
	fulln varchar2(50);
BEGIN
	fn := '';  -- initially empty value 
	lnm := '';  -- initially empty value 
	fulln := ''; -- initially empty value 
	
	SELECT E.fname, E.lname into fn, lnm FROM DEPARTMENT D, EMPLOYEE E 
	WHERE D.mgrssn = E.SSN and D.dname = DEPTNAME;

	fulln := fn || ' ' || lnm;
	
	RETURN(fulln);

-- exception handling

   exception
     when NO_DATA_FOUND then
       dbms_output.put_line('No data found');
       RETURN(fulln);

END;
/
show errors

- **** Test **** -- function call

-- using the function in a query

select dname || ' has manager ' || get_manager_name(dname) || '.' as DEPT_MGR_INFO
from department;


-- part 6
-- Implement a Function that returns conrolling department's manager’s full name for a project. 
-- The parameter to the function would be the project name.

CREATE OR REPLACE FUNCTION get_proj_manager_name(PROJNAME IN project.pname%type)
   RETURN varchar2
IS 
	fn employee.fname%type;
	lnm employee.lname%type;
	fulln varchar2(50);
BEGIN
	fn := '';  -- initially empty value 
	lnm := '';  -- initially empty value 
	fulln := ''; -- initially empty value 
	
	SELECT E.fname, E.lname into fn, lnm FROM EMPLOYEE E, DEPARTMENT D, PROJECT P 
	WHERE P.dnum = D.dnumber and D.mgrssn = E.ssn and P.pname = PROJNAME;

	fulln := fn || ' ' || lnm;
	
	RETURN(fulln);

-- exception handling

   exception
     when NO_DATA_FOUND then
       dbms_output.put_line('No data found');
       RETURN(fulln);

END;
/
show errors

- **** Test **** -- function call


-- using the function in a query

select pname || ' has manager ' || get_proj_manager_name(pname) || '.' as PROJ_MGR_INFO
from project;

-- part 7
-- Implement a Procedure that returns increments an employess salary by x%
-- The parameter to the procedure would be a percentage.

CREATE OR REPLACE PROCEDURE incr_salary_emp_sp(EMPSSN IN employee.ssn%type, INCRRATE IN number)
AS
    eln employee.lname%type; 
BEGIN
    select lname into eln from employee where ssn = EMPSSN;
    
	if (eln is null) then
		dbms_output.put_line('Employee ' || EMPSSN || ' does not exist, no salary update!');
	else
	
		update EMPLOYEE
		set salary = salary * (1 + INCRRATE)
		WHERE SSN = EMPSSN;

		dbms_output.put_line('Salary update is done for emp ' || EMPSSN);
	end if;

	-- exception handling

	exception
		when NO_DATA_FOUND then
			dbms_output.put_line('No data found for SSN: ' || EMPSSN);
END;
/
show errors

-- TEST

select lname, ssn, salary from employee
	where ssn = '123456789';

exec incr_salary_emp_sp('123456789', 0.10);

select lname, ssn, salary from employee
	where ssn = '123456789';

rollback;

select lname, ssn, salary from employee
	where ssn = '111111111';

exec incr_salary_emp_sp('111111111', 0.10);

select lname, ssn, salary from employee
	where ssn = '111111111';


-- **** Package Declaration **** --
create or replace package emp_package as
    procedure count_emps_dept(DEPTNAME in department.dname%type);
    procedure count_deps_emp(EMPSSN in employee.ssn%type);
	procedure remove_dep_emp(SSN in employee.ssn%type, DEP in dependent.dependent_name%type);
end;
/
show errors

-- **** Package Body **** --
create or replace package body emp_package as
	-- count the employees in a department
    procedure count_emps_dept(DEPTNAME in department.dname%type)
    as
		cnt number;
    begin
		SELECT count(*) into cnt FROM EMPLOYEE E, DEPARTMENT D
		WHERE D.dnumber = E.dno and D.dname = DEPTNAME;
		
		dbms_output.put_line('# of employees for department ' || DEPTNAME || ': ' || cnt);
    end;

	-- count dependents for an employee
    procedure count_deps_emp(EMPSSN in employee.ssn%type)
    as
		cnt number;
    begin
		select count(*) into cnt from dependent where essn = EMPSSN;
		
		dbms_output.put_line('employee ' || EMPSSN || ' has ' || cnt || ' dependents.');
    end;

	-- remove dependent from employee
	procedure remove_dep_emp(SSN in employee.ssn%type, DEP in dependent.dependent_name%type)
    as 
	emp_cnt number; 
	dep_cnt number;
    begin
		select count(*) into emp_cnt from employee
		where ssn = SSN;
		select count(*) into dep_cnt from dependent
		where essn = SSN and dependent_name = DEP;

		if emp_cnt > 0 and dep_cnt > 0 then
			delete from dependent
			where essn = SSN and dependent_name = DEP;
			dbms_output.put_line(DEP || ' succesfully removed from ' || SSN);

		end if;
    end;

end;
/
show errors


-- **** Test **** --
exec emp_package.count_emps_dept('RESEARCH');

exec emp_package.count_deps_emp('123456789');

Select d.dependent_name from dependent d where '123456789' = d.essn;
exec emp_package.remove_dep_emp('123456789', 'Alice');
Select d.dependent_name from dependent d where '123456789' = d.essn;

exec emp_package.count_deps_emp('123456789');

rollback;


