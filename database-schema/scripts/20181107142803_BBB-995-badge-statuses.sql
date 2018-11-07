-- // BBB-995-badge-statuses
-- Migration SQL that makes the change goes here.

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('STATUS', 'ORDERED', 'Ordered', 20, null),
('STATUS', 'PROCESSED', 'Processed', 30, null),
('STATUS', 'REJECT', 'Rejected', 40, null);

-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM reference_data WHERE data_group_id = 'STATUS'
AND code IN ('ORDERED', 'PROCESSED', 'REJECT');


