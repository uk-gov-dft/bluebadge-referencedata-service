
-- // BBB-1233-cognitive-impairment
-- Migration SQL that makes the change goes here.
INSERT INTO referencedata.reference_data (
  data_group_id, code, description, display_order, data_subgroup_id)
VALUES
('ELIGIBILIT', 'COGNITIVE', 'Cognitive impairment', 10, 'ELIG_FURTH');


-- //@UNDO
-- SQL to undo the change goes here.
DELETE FROM referencedata.reference_data WHERE code = 'COGNITIVE';

