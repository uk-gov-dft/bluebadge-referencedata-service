INSERT INTO group_domain_map (data_group_id, data_domain_id) VALUES
  ('REPLACE', 'BADGE'),
  ('CANCEL', 'BADGE')
;

--//@UNDO
-- SQL to undo the change goes here.
DELETE FROM group_domain_map
WHERE data_domain_id = 'BADGE' AND data_group_id IN('REPLACE', 'CANCEL');
