DROP DATABASE IF EXISTS HOTELIDAY_DB;
CREATE DATABASE HOTELIDAY_DB;
USE HOTELIDAY_DB;

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER (
CUSTOMER_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(25) NOT NULL,
LAST_NAME VARCHAR(25) NOT NULL,
EMAIL VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
PRIMARY KEY (CUSTOMER_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS ADMIN;
CREATE TABLE ADMIN (
ADMIN_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(25) NOT NULL,
LAST_NAME VARCHAR(25) NOT NULL,
EMAIL VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
PRIMARY KEY (ADMIN_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(25) NOT NULL,
LAST_NAME VARCHAR(25) NOT NULL,
EMAIL VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
SALARY DECIMAL(7,2) NOT NULL,
PRIMARY KEY (EMPLOYEE_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS ROOM;
 CREATE TABLE ROOM (
 ROOM_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 ROOM_TYPE ENUM ('ECONOMIC', 'NORMAL', 'SUITE') DEFAULT 'NORMAL',
 ROOM_CAPACITY SMALLINT UNSIGNED NOT NULL,
 PRICE_PER_NIGHT DECIMAL(7,2) NOT NULL,
 ROOM_STATUS ENUM ('RED', 'YELLOW', 'GREEN') DEFAULT 'GREEN',
 PRIMARY KEY (ROOM_ID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 DROP TABLE IF EXISTS RESERVATION;
 CREATE TABLE RESERVATION (
 RESERVATION_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 CHECK_IN_DATE DATE,
 CHECK_OUT_DATE DATE,
 CUSTOMER_ID SMALLINT UNSIGNED ,
 ROOM_ID SMALLINT UNSIGNED ,
 PRICE DECIMAL(7,2) NOT NULL,
 ADULT_NUMBER SMALLINT UNSIGNED NOT NULL,
 CHILDREN_NUMBER SMALLINT UNSIGNED NOT NULL,
 INCLUDED_MEAL BOOLEAN DEFAULT FALSE,
 INCLUDED_POOL BOOLEAN DEFAULT FALSE,
 INCLUDED_TENNIS_COURT BOOLEAN DEFAULT FALSE,
 PRIMARY KEY (RESERVATION_ID),
 CONSTRAINT RES_ROOM FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ROOM_ID) ON DELETE SET NULL ON UPDATE CASCADE,
 CONSTRAINT RES_CUST FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID) ON DELETE SET NULL ON UPDATE CASCADE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 
 DROP TABLE IF EXISTS PAYMENT;
 CREATE TABLE PAYMENT (
 PAYMENT_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 RESERVATION_ID SMALLINT UNSIGNED ,
 AMMOUNT DECIMAL(7,2) NOT NULL,
 COMPLETION BOOLEAN DEFAULT FALSE,
 PRIMARY KEY (PAYMENT_ID),
 CONSTRAINT PAY_RES FOREIGN KEY (RESERVATION_ID) REFERENCES RESERVATION(RESERVATION_ID) ON DELETE SET NULL ON UPDATE CASCADE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
  
 
DROP TABLE IF EXISTS EMPLOYEE_MESSAGE;
CREATE TABLE EMPLOYEE_MESSAGE ( /*Messages from Employee to other Employee*/
MESSAGE_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
SENDER_ID SMALLINT UNSIGNED NOT NULL, 
RECEIVER_ID SMALLINT UNSIGNED NOT NULL, 
TITLE VARCHAR(25),
CONTENT VARCHAR(1000),
PRIMARY KEY (MESSAGE_ID),
CONSTRAINT SNDR FOREIGN KEY (SENDER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT RCVR FOREIGN KEY (RECEIVER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS ADMIN_MESSAGE;
CREATE TABLE ADMIN_MESSAGE ( /*Messages from Admin to Employee*/
MESSAGE_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
SENDER_ID SMALLINT UNSIGNED NOT NULL, 
RECEIVER_ID SMALLINT UNSIGNED NOT NULL, 
TITLE VARCHAR(25),
CONTENT VARCHAR(1000),
PRIMARY KEY (MESSAGE_ID),
CONSTRAINT ADMN_SNDR FOREIGN KEY (SENDER_ID) REFERENCES ADMIN(ADMIN_ID) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT EMPL_RCVR FOREIGN KEY (RECEIVER_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS ANNOUNCEMENT;
CREATE TABLE ANNOUNCEMENT ( 
ANNOUNCEMENT_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
TITLE VARCHAR(25),
CONTENT VARCHAR(1000),
PRIMARY KEY (ANNOUNCEMENT_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS SALARY_RECORD;
 CREATE TABLE SALARY_RECORD (
 SALARY_REC_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 EMPLOYEE_ID SMALLINT UNSIGNED NOT NULL, 
 SALARY_AMOUNT DECIMAL(7,2) NOT NULL,
 SALARY_SUBMISSION_DATE DATE,
 PRIMARY KEY (SALARY_REC_ID),
 CONSTRAINT EMP_CNSTRNT FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID) ON DELETE CASCADE ON UPDATE CASCADE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 DROP TABLE IF EXISTS OPERATING_COSTS;
 CREATE TABLE OPERATING_COSTS (
 COST_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 COST_TYPE VARCHAR(50) NOT NULL, /*Maybe ENUM*/
 COST_PRICE DECIMAL(7,2) NOT NULL,
 SALARY_SUBMISSION_DATE DATE,
 PRIMARY KEY (COST_ID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
DROP TABLE IF EXISTS FEEDBACK;
CREATE TABLE FEEDBACK (
FEEDBACK_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
CUSTOMER_ID SMALLINT UNSIGNED NOT NULL,
STARS_RATING DECIMAL(2,1) NOT NULL,
FEEDBACK_STATUS BOOLEAN NOT NULL DEFAULT TRUE,
PRIMARY KEY (FEEDBACK_ID),
CONSTRAINT FDBKCUS FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID) ON DELETE CASCADE ON UPDATE CASCADE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 