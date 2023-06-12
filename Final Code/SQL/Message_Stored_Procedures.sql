use HOTELIDAY_DB;
DELIMITER $ 
DROP PROCEDURE IF EXISTS  listReceivedMessages$ 
CREATE PROCEDURE listReceivedMessages(identifier SMALLINT) 
begin

select * from EMPLOYEE_MESSAGE where EMPLOYEE_MESSAGE.RECEIVER_ID=identifier;
select * from ADMIN_MESSAGE where ADMIN_MESSAGE.RECEIVER_ID=identifier;
select * from ANNOUNCEMENTS;

end$
delimiter ;

DELIMITER $ 
DROP PROCEDURE IF EXISTS  listSentMessages$ 
CREATE PROCEDURE listSentMessages(identifier SMALLINT) 
begin

select * from EMPLOYEE_MESSAGE where EMPLOYEE_MESSAGE.SENDER_ID=identifier;
select * from ADMIN_MESSAGE where ADMIN_MESSAGE.SENDER_ID=identifier;

end$
delimiter ;

