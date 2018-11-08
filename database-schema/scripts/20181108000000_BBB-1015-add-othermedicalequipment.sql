UPDATE reference_data SET code = 'OTHER', description = 'Other'
WHERE data_group_id = 'BULKEQUIP' and code = 'NONE';

-- //@UNDO
-- SQL to undo the change goes here.
UPDATE reference_data SET code = 'NONE', description = 'None'
WHERE data_group_id = 'BULKEQUIP' and code = 'OTHER';

