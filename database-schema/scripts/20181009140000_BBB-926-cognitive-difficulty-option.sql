UPDATE reference_data SET display_order = 5 WHERE display_order = 4 and code = 'DANGER';
UPDATE reference_data SET display_order = 6 WHERE display_order = 5 and code = 'STRUGGLE';
UPDATE reference_data SET display_order = 7 WHERE display_order = 6 and code = 'SOMELSE';

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES ('WALKDIFF', 'LONGTIME', 'Long time', 4, null);

-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM reference_data WHERE code = 'LONGTIME' and display_order = 4;

UPDATE reference_data SET display_order = 4 WHERE display_order = 5 and code = 'DANGER';
UPDATE reference_data SET display_order = 5 WHERE display_order = 6 and code = 'STRUGGLE';
UPDATE reference_data SET display_order = 6 WHERE display_order = 7 and code = 'SOMELSE';
