CREATE TABLE Doctor (
 id INT PRIMARY KEY,
 name VARCHAR2(100),
 salary DECIMAL(10,2) ,
 address VARCHAR2(255)
);


  INSERT INTO Doctor (id, name, salary, address)
  VALUES (1, 'Dr. John Smith', 1000.00, 'New York, NY');
  INSERT INTO Doctor (id, name, salary, address) VALUES (2, 'Dr. Emily Johnson', 2000.00, 'Los Angeles, CA');
  INSERT INTO Doctor (id, name, salary, address) VALUES (3, 'Dr. Michael Brown', 8000.00, 'Chicago, IL');
  INSERT INTO Doctor (id, name, salary, address) VALUES (4, 'Dr. Sarah Davis', 9000.00, 'Houston, TX');
  INSERT INTO Doctor (id, name, salary, address) VALUES (5, 'Dr. William Wilson', 87000.00, 'Phoenix, AZ');
  INSERT INTO Doctor (id, name, salary, address) VALUES (6, 'Dr. Linda Martinez', 95000.00, 'Philadelphia, PA');
  INSERT INTO Doctor (id, name, salary, address) VALUES (7, 'Dr. James Taylor', 3000.00, 'San Antonio, TX');
  INSERT INTO Doctor (id, name, salary, address) VALUES (8, 'Dr. Barbara Anderson', 2000.00, 'San Diego, CA');
  INSERT INTO Doctor (id, name, salary, address) VALUES (9, 'Dr. Robert Thomas', 8000.00, 'Dallas, TX');
  INSERT INTO Doctor (id, name, salary, address) VALUES (10, 'Dr. Patricia Jackson', 7000.00, 'San Jose, CA');



UPDATE Doctor SET salary=20000 WHERE id=3;

DELETE Doctor WHERE id =9;

SELECT name || '-' || salary AS "name with salary " FROM Doctor;

SELECT id , name, salary*2 AS salary , address FROM Doctor;

SELECT * FROM Doctor WHERE salary IN (1000,2000,3000);

ALTER TABLE Doctor RENAME TO PRD_DOCTOR;

DROP TABLE PRD_DOCTOR;



SELECT TRIM (TRAILING 'm' FROM '     my Name is Adam   ') trm from dual;