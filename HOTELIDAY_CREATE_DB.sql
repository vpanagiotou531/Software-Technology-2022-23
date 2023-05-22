DROP DATABASE IF EXISTS HOTELIDAY_DB;
CREATE DATABASE HOTELIDAY_DB;
USE HOTELIDAY_DB;


CREATE TABLE CUSTOMER (
CUSTOMER_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(25) NOT NULL,
LAST_NAME VARCHAR(25) NOT NULL,
EMAIL VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
PRIMARY KEY (CUSTOMER_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ADMIN (
ADMIN_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(25) NOT NULL,
LAST_NAME VARCHAR(25) NOT NULL,
EMAIL VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
PRIMARY KEY (ADMIN_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE EMPLOYEE (
EMPLOYEE_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(25) NOT NULL,
LAST_NAME VARCHAR(25) NOT NULL,
EMAIL VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
SALARY DECIMAL(7,2) NOT NULL,
PRIMARY KEY (CUSTOMER_ID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


 CREATE TABLE ROOM (
 ROOM_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 ROOM_TYPE ENUM ('ECONOMIC', 'NORMAL', 'SUITE') DEFAULT 'NORMAL',
 ROOM_CAPACITY SMALLINT UNSIGNED NOT NULL,
 PRICE_PER_NIGHT DECIMAL(7,2) NOT NULL,
 ROOM_STATUS ENUM ('RED', 'YELLOW', 'GREEN') DEFAULT 'GREEN',
 PRIMARY KEY (ROOM_ID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 CREATE TABLE RESERVATION (
 RESERVATION_ID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
 CHECK_IN_DATE DATE,
 CHECK_OUT_DATE DATE,
 CUSTOMER_ID SMALLINT UNSIGNED NOT NULL,
 ROOM_ID SMALLINT UNSIGNED NOT NULL,
 PRICE DECIMAL(7,2) NOT NULL,
 ADULT_NUMBER SMALLINT UNSIGNED NOT NULL,
 CHILDREN_NUMBER SMALLINT UNSIGNED NOT NULL,
 INCLUDED_MEAL BOOLEAN DEFAULT FALSE,
 INCLUDED_POOL BOOLEAN DEFAULT FALSE,
 INCLUDED_TENNIS_COURT BOOLEAN DEFAULT FALSE
 PRIMARY KEY (RESERVATION_ID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 
 CREATE TABLE PAYMENT (
 
 PRIMARY KEY (),
 
 )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
  

 
 