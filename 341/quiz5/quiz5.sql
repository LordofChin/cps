set echo on
set linesize 120
set pagesize 120
set serveroutput on

select * from project_bk2

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
