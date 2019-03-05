INSERT INTO data_group(id, description) VALUES ('APPSTATUS', 'Application status');

INSERT INTO group_domain_map (data_group_id, data_domain_id) VALUES ('APPSTATUS', 'APP');

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('APPSTATUS', 'TODO', 'To do', 1, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('APPSTATUS', 'INPROGRESS', 'In progress', 2, null);
INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('APPSTATUS', 'COMPLETED', 'Completed', 3, null);

-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM reference_data WHERE data_group_id = 'APPSTATUS' and code = 'TODO';
DELETE FROM reference_data WHERE data_group_id = 'APPSTATUS' and code = 'INPROGRESS';
DELETE FROM reference_data WHERE data_group_id = 'APPSTATUS' and code = 'COMPLETED';

DELETE FROM group_domain_map WHERE data_group_id = 'APPSTATUS' and data_domain_id = 'APP';

DELETE FROM data_group WHERE id = 'APPSTATUS';
