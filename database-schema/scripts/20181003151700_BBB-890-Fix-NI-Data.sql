UPDATE referencedata.reference_data SET description ='Northern Ireland' where data_group_id='NATION' and code ='NIR';

-- //@UNDO
-- SQL to undo the change goes here.
UPDATE referencedata.reference_data SET description ='Northern Island' where data_group_id='NATION' and code ='NIR';

