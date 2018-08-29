INSERT INTO referencedata.group_domain_map (data_group_id, data_domain_id) VALUES ('LA','USER');

--//@UNDO
-- SQL to undo the change goes here.

DELETE FROM referencedata.group_domain_map where data_domain_id = 'USER';
