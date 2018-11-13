INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id)
VALUES ('BULKEQUIP', 'OTHER', 'Other', 1, null);

-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM reference_data WHERE data_group_id = 'BULKEQUIP' and code = 'OTHER';

