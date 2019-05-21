
-- // BBB-1419-new-cancellation-and-replace-reasons
-- Migration SQL that makes the change goes here.
INSERT INTO referencedata.reference_data
 (data_group_id,code,description,display_order)
VALUES
 ('REPLACE','UNDELIVER','Undelivered - Lost in post',4)
,('CANCEL' ,'UNDELIVER','Undelivered - Lost in post',4)
,('CANCEL' ,'LOST'     ,'Lost',5)
,('CANCEL' ,'STOLEN'   ,'Stolen',6)
,('CANCEL' ,'DAMAGED'  ,'Damaged',7)
;


-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM referencedata.reference_data
WHERE (data_group_id,code) IN (
 ('REPLACE','UNDELIVER')
,('CANCEL','UNDELIVER')
,('CANCEL','LOST')
,('CANCEL','STOLEN')
,('CANCEL','DAMAGED')
);

