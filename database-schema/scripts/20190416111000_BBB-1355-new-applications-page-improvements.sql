-- // BBB-1355-new-applications-page-improvements
-- Migration SQL that makes the change goes here.
UPDATE reference_data SET description = 'Reapplication' WHERE data_group_id = 'APPTYPE' and code = 'RENEW';

--//@UNDO
-- SQL to undo the change goes here.
UPDATE reference_data SET description = 'Renew' WHERE data_group_id = 'APPTYPE' and code = 'RENEW';
