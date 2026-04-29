-- sample queries for project parts 6-8

SELECT E.fname, E.lname, P.pname FROM EMPLOYEE E, DEPARTMENT D, PROJECT P 
WHERE P.dnum = D.dnumber and D.mgrssn = E.ssn;

-- part 6
SELECT E.fname, E.lname FROM EMPLOYEE E, DEPARTMENT D, PROJECT P 
WHERE P.dnum = D.dnumber and D.mgrssn = E.ssn and P.pname = 'Computerization';

-- part 7
 update employee salary set salary=salary*(1 + 0.15) where ssn='111111111';

-- part 8
select count(*) from employee, department where dno = dnumber and dname = 'Research';

select count(*) from employee E, dependent D 
where E.ssn = D.essn and E.ssn = '123456789';

select count(*) from employee E, dependent D 
where E.ssn = D.essn and E.ssn = '987987987';
