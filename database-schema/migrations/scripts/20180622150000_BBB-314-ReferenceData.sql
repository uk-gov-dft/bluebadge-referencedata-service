--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

--// 20180622150000_BBB-314-ReferenceData
-- Migration SQL that makes the change goes here.
CREATE TABLE data_consumer(
    id VARCHAR(10) PRIMARY KEY,
    description VARCHAR(100)
);

COMMENT ON TABLE data_consumer IS 'Holds reference data consumer service names.';
COMMENT ON COLUMN data_consumer.id IS 'Short code.';
COMMENT ON COLUMN data_consumer.description IS 'Short code.';

INSERT INTO data_consumer (id, description) VALUES 
    ('BADGE', 'Badge management service.'),
    ('MESSAGE', 'Message service.'),
    ('USER', 'User management service.'),
    ('APP', 'Application management service.');

CREATE TABLE data_category(
    id VARCHAR(10) PRIMARY KEY,
    description VARCHAR(100)
);

COMMENT ON TABLE data_category IS 'Holds reference categories, e.g. eligibility.';
COMMENT ON COLUMN data_category.id IS 'Short code.';
COMMENT ON COLUMN data_category.description IS 'Category name.';

INSERT INTO data_category(id, description) VALUES 
    ('ELIGIBILIT', 'Eligibility');

CREATE TABLE reference_data(
  data_category_id VARCHAR(10),
  code VARCHAR(10),
  description VARCHAR(100) NOT NULL,
  display_order INTEGER NOT NULL,
  PRIMARY KEY (data_category_id, code)
);

COMMENT ON TABLE reference_data IS 'Holds reference data.';
COMMENT ON COLUMN reference_data.code IS 'Short code.';
COMMENT ON COLUMN reference_data.description IS 'Reference data display text.';
COMMENT ON COLUMN reference_data.data_category_id IS 'Category of reference data.';

ALTER TABLE reference_data
    ADD CONSTRAINT reference_data_data_category_id_fk
    FOREIGN KEY (data_category_id)
    REFERENCES data_category(id);

INSERT INTO reference_data (data_category_id, code, description, display_order) VALUES
('ELIGIBILIT', 'TODO', 'Some data', 1),
('ELIGIBILIT', 'TODO2', 'Some data2', 2)
;

CREATE TABLE category_consumer_map(
  data_category_id VARCHAR(10),
  data_consumer_id VARCHAR(10),
  PRIMARY KEY (data_consumer_id, data_category_id)
);

COMMENT ON TABLE category_consumer_map IS 'Assignes sets of reference data to services.';
COMMENT ON COLUMN category_consumer_map.data_category_id IS 'FK.';
COMMENT ON COLUMN category_consumer_map.data_consumer_id IS 'FK.';

ALTER TABLE category_consumer_map
    ADD CONSTRAINT category_consumer_map_category_fk
    FOREIGN KEY (data_category_id)
    REFERENCES data_category(id);

ALTER TABLE category_consumer_map
    ADD CONSTRAINT category_consumer_map_consumer_id_fk
    FOREIGN KEY (data_consumer_id)
    REFERENCES data_consumer(id);

INSERT INTO category_consumer_map (data_category_id, data_consumer_id) VALUES
('ELIGIBILIT', 'BADGE'),
('ELIGIBILIT', 'APP');

CREATE OR REPLACE VIEW reference_data_vw AS
  SELECT
    rd.data_category_id,
    rd.code,
    rd.description,
    rd.display_order,
    ccm.data_consumer_id
  FROM reference_data rd INNER JOIN category_consumer_map ccm
    ON (ccm.data_category_id = rd.data_category_id)
  ORDER BY (ccm.data_consumer_id, rd.data_category_id, rd.display_order);

--//@UNDO
-- SQL to undo the change goes here.
DROP VIEW IF EXISTS reference_data_vw;
DROP TABLE IF EXISTS reference_data;
DROP TABLE IF EXISTS category_consumer_map;
DROP TABLE IF EXISTS data_category;
DROP TABLE IF EXISTS data_consumer;
