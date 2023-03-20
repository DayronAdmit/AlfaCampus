SELECT 
emp_id,
fname,
lname
FROM
employee
ORDER BY
lname,
fname;


SELECT 
account_id,
cust_id,
SUM(avail_balance) AS sum_avail_balance
FROM
account
WHERE avail_balance>2500 AND status='ACTIVE'
GROUP BY cust_id;


SELECT
DISTINCT open_emp_id
FROM 
account;


SELECT
*
FROM 
account
WHERE year(open_date) = 2002;


SELECT
e.emp_id,
e.fname,
e.lname,
(SELECT name FROM branch b WHERE b.branch_id = e.assigned_branch_id) AS branch_name,
(SELECT name FROM department d WHERE d.dept_id=e.dept_id) AS department_name
FROM 
employee e;


SELECT
*
FROM
individual
WHERE lname LIKE '_a%e%';


SELECT
e.emp_id,
e.fname,
e.lname
FROM employee e
JOIN employee mgr ON e.superior_emp_id = mgr.emp_id
WHERE WHERE e.dept_id != mgr.dept_id;


SELECT
a.account_id,
c.fed_id,
p.name
FROM customer c
JOIN account a ON c.cust_id=a.cust_id
JOIN product p ON a.product_cd=p.product_cd
WHERE cust_type_cd = 'I';


SELECT
c.cust_id,
CONCAT(i.fname, ' ', i.lname) AS individual_name,
b. name AS business_name
FROM customer c
LEFT JOIN individual i ON c.cust_id=i.cust_id
LEFT JOIN business b ON c.cust_id= b.cust_id;


SELECT
a.account_id,
CONCAT (e.fname, ' ', e.lname) AS emp_name,
a.open_date
FROM account a
JOIN employee e ON e. emp_id=a.open_emp_id
WHERE e.lname='Markham' AND DAYNAME(a.open_date)='Wednesday';