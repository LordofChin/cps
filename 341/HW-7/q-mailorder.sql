-- q-mailorder.sql
-- queries
-- Carter Tufts
-- ITC 341	Homework 7	Mar. 18, 2026

-- keep these three commands at the top of every sql file
set echo on
set linesize 150
set pagesize 120

-- query 2.1 testing your tables and displaying the data 
select * from employees;
select * from zipcodes;
select count(*) from employees;
select count(*) as ZIP_COUNT from zipcodes;

-- comment out the above queries for your homework

-- your queries goes here for hw#6

--query 2.1
SELECT pno, pname FROM parts WHERE price < 20.00;

-- query 2.2: get all the rows in employees table
SELECT * FROM employees; 

-- query 2.3
SELECT DISTINCT pno FROM odetails;

-- query 2.4
SELECT * FROM customers WHERE cname like 'A%';

-- query 2.5
SELECT ono, cname FROM orders, customers WHERE customers.cno = orders.cno AND shipped is null;

-- query 2.7
SELECT distinct cname, ename FROM customers, orders, employees WHERE customers.cno = orders.cno and employees.eno = orders.eno;

-- query 2.8
SELECT x.ono, x.pno, p.pname, x.qty, p.price, (x.qty * p.price) total FROM odetails x, parts p WHERE x.pno = p.pno;

--query 2.9
SELECT c1.cno, c2.cno FROM customers c1, customers c2 WHERE c1.zip = c2.zip and c1.cno < c2.cno;

--query 2.10
SELECT distinct y1.pno FROM orders x1, orders x2, odetails y1, odetails y2 WHERE y1.pno = y2.pno AND y1.ono = x1.ono AND y2.ono = x2.ono AND x1.ono < x2.ono;

