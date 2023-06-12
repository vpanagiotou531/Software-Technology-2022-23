USE HOTELIDAY_DB;

INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES
('John', 'Doe', 'john.doe@exa.com', 'password123'),
('Alice', 'Johnson', 'alice.johnson@exa.com', 'qwerty456'),
('Michael', 'Smith', 'michael.smith@exa.com', 'pass123'),
('Sarah', 'Williams', 'sarah.williams@exa.com', 'abc456'),
('David', 'Brown', 'david.brown@exa.com', 'secure123');

INSERT INTO ADMIN (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)VALUES 
('Emily', 'Taylor', 'emily.taylor@exa.com', 'test456'),
('James', 'Anderson', 'james.anderson@exa.com', 'p@$$w0rd'),
('Olivia', 'Clark', 'olivia.clark@exa.com', 'strongpass'),
('Daniel', 'Wilson', 'daniel.wilson@exa.com', 'secret123'),
('Sophia', 'Miller', 'sophia.miller@exa.com', 'mypassword');

INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, SALARY)VALUES 
('Matthew', 'Roberts', 'matthew.roberts@exa.com', 'pass789',5000.00),
('Ava', 'Turner', 'ava.turner@exa.com', 'abc123',7500.00),
('William', 'Cooper', 'william.cooper@exa.com', 'test789',10000.00),
('Chloe', 'Garcia', 'chloe.garcia@exa.com', 'qwerty123',6200.50),
('Ethan', 'Parker', 'ethan.parker@exa.com', 'password789',8300.25);

INSERT INTO ROOM (ROOM_TYPE, ROOM_CAPACITY, PRICE_PER_NIGHT, ROOM_STATUS)VALUES
  ('NORMAL', 2, 100.00, 'GREEN'),
  ('NORMAL', 2, 100.00, 'GREEN'),
  ('SUITE', 4, 200.00, 'GREEN'),
  ('ECONOMIC', 1, 50.00, 'YELLOW'),
  ('NORMAL', 3, 150.00, 'GREEN'),
  ('ECONOMIC', 1, 50.00, 'GREEN'),
  ('SUITE', 4, 200.00, 'RED'),
  ('NORMAL', 2, 100.00, 'YELLOW'),
  ('ECONOMIC', 1, 50.00, 'GREEN'),
  ('NORMAL', 4, 180.00, 'GREEN');
  
INSERT INTO reservation (CHECK_IN_DATE, CHECK_OUT_DATE, CUSTOMER_ID, ROOM_ID, PRICE, ADULT_NUMBER, CHILDREN_NUMBER, INCLUDED_MEAL, INCLUDED_POOL, INCLUDED_TENNIS_COURT)VALUES 
('2023-06-10', '2023-06-13', 1, 1, 100.00, 2, 1, FALSE, FALSE, FALSE),
('2023-06-09', '2023-06-12', 4, 2, 100.00, 2, 1, FALSE, FALSE, FALSE),
('2023-06-08', '2023-06-11', 2, 3, 150.00, 1, 0, TRUE, FALSE, TRUE),
('2023-06-10', '2023-06-21', 3, 4, 200.00, 2, 2, TRUE, TRUE, FALSE),
('2023-06-11', '2023-06-13', 4, 6, 180.00, 2, 1, FALSE, TRUE, TRUE),
('2023-06-07', '2023-06-16', 5, 9, 120.00, 1, 0, TRUE, FALSE, FALSE),
('2023-06-09', '2023-06-12', 1, 10, 220.00, 2, 2, TRUE, TRUE, TRUE);



