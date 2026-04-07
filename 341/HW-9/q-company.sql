set echo on -- this is a MUST (for displaying queries in the output file)
set linesize 150 -- needed for displaying larger tables
set pagesize 120 -- for a better display

-- 1
SELECT e.fname, e.lname
FROM Employee e
JOIN Works_On w ON e.ssn = w.essn
JOIN Project p ON w.pno = p.pnumber
WHERE e.dno = 5
  AND p.pname = 'ProductX'
  AND w.hours > 10;

-- 2
SELECT e.fname, e.lname
FROM Employee e
JOIN Dependent d ON e.ssn = d.essn
WHERE e.fname = d.dependent_name;

-- 3
SELECT e.fname, e.lname
FROM Employee e
JOIN Employee s ON e.superssn = s.ssn
WHERE s.fname = 'Franklin'
  AND s.lname = 'Wong';

-- 4
SELECT p.pname, SUM(w.hours) AS total_hours
FROM Project p
JOIN Works_On w ON p.pnumber = w.pno
GROUP BY p.pname;

-- 5
SELECT e.fname, e.lname
FROM Employee e
WHERE NOT EXISTS (
    SELECT p.pnumber
    FROM Project p
    WHERE NOT EXISTS (
        SELECT *
        FROM Works_On w
        WHERE w.essn = e.ssn
          AND w.pno = p.pnumber
    )
);

-- 6
SELECT e.fname, e.lname
FROM Employee e
WHERE NOT EXISTS (
    SELECT *
    FROM Works_On w
    WHERE w.essn = e.ssn
);

-- 7
SELECT d.dname, AVG(e.salary) AS avg_salary
FROM Department d
JOIN Employee e ON d.dnumber = e.dno
GROUP BY d.dname;

-- 8
SELECT AVG(salary) AS avg_female_salary
FROM Employee
WHERE sex = 'F';

-- 9
SELECT MAX(salary) AS max_salary,
       MIN(salary) AS min_salary
FROM Employee;

-- 10
SELECT e.lname
FROM Employee e
JOIN Department d ON e.ssn = d.mgrssn
WHERE NOT EXISTS (
    SELECT *
    FROM Dependent dep
    WHERE dep.essn = e.ssn
);

