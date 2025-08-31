CREATE TABLE Employees2(

EmployeeID INT PRIMARY KEY ,
FirstName  VARCHAR2(100),
LastName VARCHAR2(100),
Department VARCHAR2(70),
salary DECIMAL(10,2) 

);

INSERT INTO Employees2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (101, 'John1', 'Doe1', 'HR', 20000);

INSERT INTO Employees2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (102, 'John2', 'Doe2', 'IT', 50000);

INSERT INTO Employees2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (103, 'John3', 'Doe3', 'CS', 40000);

INSERT INTO Employees2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (104, 'John4', 'Doe4', 'IT', 10000);

INSERT INTO Employees2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (105, 'John5', 'Doe5', 'ZX', 30000);

UPDATE Employees2 SET salary=600000 WHERE EmployeeID=101;

DELETE Employees2 WHERE Department ='CS';

SELECT * FROM Employees2 WHERE Department='IT';

SELECT 
       EmployeeID ,
       FirstName ||' '|| LastName AS "fullName" ,
       Department,
       salary
       FROM Employees2;

DROP TABLE Employees2;
 
SELECT LTRIM ('234234217www.mywebsite.com', '0123456789') trm from dual;

