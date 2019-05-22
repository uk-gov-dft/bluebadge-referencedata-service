
-- // BBB-1419-new-cancellation-and-replace-reasons
-- Migration SQL that makes the change goes here.
INSERT INTO referencedata.reference_data
 (data_group_id,code,description,display_order)
VALUES
 ('REPLACE','UNDELIVER','Undelivered - Lost in post',4)
,('CANCEL' ,'UNDELIVER','Undelivered - Lost in post',7)
,('CANCEL' ,'LOST'     ,'Lost',3)
,('CANCEL' ,'STOLE'   ,'Stolen',6)
,('CANCEL' ,'DAMAGED'  ,'Damaged',1)
;

UPDATE referencedata.reference_data set display_order = 2 WHERE data_group_id = 'CANCEL' AND code = 'DECEASE';
UPDATE referencedata.reference_data set display_order = 4 WHERE data_group_id = 'CANCEL' AND code = 'NOLONG';
UPDATE referencedata.reference_data set display_order = 5 WHERE data_group_id = 'CANCEL' AND code = 'REVOKE';


-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM referencedata.reference_data
WHERE (data_group_id,code) IN (
 ('REPLACE','UNDELIVER')
,('CANCEL','UNDELIVER')
,('CANCEL','LOST')
,('CANCEL','STOLE')
,('CANCEL','DAMAGED')
);

