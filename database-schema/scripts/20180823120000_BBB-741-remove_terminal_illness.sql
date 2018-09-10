DELETE FROM reference_data WHERE data_group_id='ELIGIBILIT' AND code='TERMILL';

--//@UNDO
-- SQL to undo the change goes here.

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('ELIGIBILIT', 'TERMILL', 'Terminal illness', 10, 'ELIG_FURTH');


