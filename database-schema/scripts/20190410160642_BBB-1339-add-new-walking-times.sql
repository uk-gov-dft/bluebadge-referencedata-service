-- // BBB-1339-add-new-walking-times
-- Migration SQL that makes the change goes here.

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('WALKLEN', 'ONEFIVE', '1 to 5 minutes', 5, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('WALKLEN', 'FIVETEN', '5 to 10 minutes', 6, null);

--//@UNDO
-- SQL to undo the change goes here.

DELETE FROM reference_data WHERE data_group_id='WALKLEN' AND code='ONEFIVE';
DELETE FROM reference_data WHERE data_group_id='WALKLEN' AND code='FIVETEN';
