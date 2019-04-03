-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO data_group(id, description) VALUES ('BREATHLESS', 'Breathlessness');

INSERT INTO group_domain_map (data_group_id, data_domain_id) VALUES ('BREATHLESS', 'APP');

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('BREATHLESS', 'UPHILL', 'Walking up a slight hill', 1, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('BREATHLESS', 'KEEPUP', 'Trying to keep up with others on level ground', 2, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('BREATHLESS', 'OWNPACE', 'Walking on level ground at my own pace', 3, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('BREATHLESS', 'DRESSED', 'Getting dressed or trying to leave my home', 4, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('BREATHLESS', 'OTHER', 'Other', 5, null);

-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM reference_data WHERE data_group_id = 'BREATHLESS' and code = 'UPHILL';
DELETE FROM reference_data WHERE data_group_id = 'BREATHLESS' and code = 'KEEPUP';
DELETE FROM reference_data WHERE data_group_id = 'BREATHLESS' and code = 'OWNPACE';
DELETE FROM reference_data WHERE data_group_id = 'BREATHLESS' and code = 'DRESSED';
DELETE FROM reference_data WHERE data_group_id = 'BREATHLESS' and code = 'OTHER';

DELETE FROM group_domain_map WHERE data_group_id = 'BREATHLESS' and data_domain_id = 'APP';

DELETE FROM data_group WHERE id = 'BREATHLESS';
