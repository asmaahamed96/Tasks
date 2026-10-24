CREATE TABLE Doctor (id      INT PRIMARY KEY, name    VARCHAR(100), salary  DECIMAL(10,2), address VARCHAR(200));

INSERT INTO Doctor (id, name, salary, address) VALUES (1,  'Ahmed',   1000, 'Cairo');
INSERT INTO Doctor (id, name, salary, address) VALUES (2,  'Mohamed', 2000, 'Giza');
INSERT INTO Doctor (id, name, salary, address) VALUES (3,  'Sara',    3000, 'Alexandria');
INSERT INTO Doctor (id, name, salary, address) VALUES (4,  'Mona',    4000, 'Luxor');
INSERT INTO Doctor (id, name, salary, address) VALUES (5,  'Omar',    5000, 'Aswan');
INSERT INTO Doctor (id, name, salary, address) VALUES (6,  'Laila',   6000, 'Tanta');
INSERT INTO Doctor (id, name, salary, address) VALUES (7,  'Hassan',  7000, 'Mansoura');
INSERT INTO Doctor (id, name, salary, address) VALUES (8,  'Nour',    8000, 'Suez');
INSERT INTO Doctor (id, name, salary, address) VALUES (9,  'Youssef', 9000, 'Ismailia');
INSERT INTO Doctor (id, name, salary, address) VALUES (10, 'Hana',   10000, 'Fayoum');

UPDATE Doctor SET salary = 20000 WHERE id = 3;

DELETE FROM Doctor WHERE id = 9;

SELECT name || ' ' || salary AS name_salary FROM Doctor;

SELECT id, name, salary * 2 AS salary, address FROM Doctor;

ALTER TABLE Doctor RENAME TO PRD_DOCTOR;