-- ins-company.sql
-- inserts tuples into the COMPANY DB
-- partial

-- keep these two commands at the top of every sql file
set echo on
set linesize 150
set pagesize 120

delete from Employee;
commit;

-- insert only managers first with their dno is null
INSERT INTO employee VALUES 
  ('James','E','Borg','888665555','10-NOV-37','450 Stone, Houston, TX','M',55000,null,null);
INSERT INTO employee VALUES 
  ('Franklin','T','Wong','333445555', to_date('1955-12-08', 'YYYY-MM-DD'), '638 Voss, Houston, TX','M',40000,'888665555',null);
-- need more manager inserts to employee

delete from Department;
commit;
insert into Department values ('Research',5,'333445555','22-MAY-1988');
insert into Department values ('Headquarters',1,'888665555','19-JUN-1981');
-- need more inserts here for Department

-- now, update employee.dno for managers
UPDATE employee SET dno = 1 WHERE ssn = '888665555';
UPDATE employee SET dno = 5 WHERE ssn = '333445555';
-- need to update the rest of managers

-- insert the rest of non-manager employees, supervisors first
insert into Employee values ('John','B','Smith','123456789','09-JAN-1965','731 Fondren, Houston, TX','M',30000,'333445555',5);
-- need more inserts here for Employee

-- ADD the rest

commit;
