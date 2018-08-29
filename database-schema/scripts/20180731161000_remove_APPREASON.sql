DELETE FROM group_domain_map WHERE data_group_id ='APPREASON';
DELETE FROM reference_data WHERE data_group_id = 'APPREASON';
DELETE FROM data_group  WHERE id = 'APPREASON';

--//@UNDO
-- SQL to undo the change goes here.

-- Not Needed.
