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
CREATE TABLE data_domain(
    id VARCHAR(10) PRIMARY KEY,
    description VARCHAR(100)
);

COMMENT ON TABLE data_domain IS 'Holds reference data domain service names.';
COMMENT ON COLUMN data_domain.id IS 'Short code.';
COMMENT ON COLUMN data_domain.description IS 'Short code.';

INSERT INTO data_domain (id, description) VALUES
    ('BADGE', 'Badge management service.'),
    ('MESSAGE', 'Message service.'),
    ('USER', 'User management service.'),
    ('APP', 'Application management service.');

CREATE TABLE data_group(
    id VARCHAR(10) PRIMARY KEY,
    description VARCHAR(100)
);

COMMENT ON TABLE data_group IS 'Holds reference categories, e.g. eligibility.';
COMMENT ON COLUMN data_group.id IS 'Short code.';
COMMENT ON COLUMN data_group.description IS 'Group name.';

INSERT INTO data_group(id, description) VALUES
  ('ELIGIBILIT', 'Eligibility'),
  ('APPSOURCE', 'Application source'),
  ('PARTY', 'Party type')
;

CREATE TABLE data_subgroup (
  id VARCHAR(10) PRIMARY KEY,
  description VARCHAR(100)
);

COMMENT ON TABLE data_subgroup IS 'Groups reference data under sub categories.';
COMMENT ON COLUMN data_subgroup.id IS 'Short code.';
COMMENT ON COLUMN data_subgroup.description IS 'Group display name.';

INSERT INTO data_subgroup(id, description) VALUES
  ('ELIG_AUTO', 'Automatic'),
  ('ELIG_FURTH', 'Further assessment')
;

CREATE TABLE reference_data(
  data_group_id VARCHAR(10) NOT NULL,
  code VARCHAR(10) NOT NULL,
  description VARCHAR(100) NOT NULL,
  display_order INTEGER NOT NULL,
  data_subgroup_id VARCHAR(10),
  PRIMARY KEY (data_group_id, code)
);

COMMENT ON TABLE reference_data IS 'Holds reference data.';
COMMENT ON COLUMN reference_data.code IS 'Short code.';
COMMENT ON COLUMN reference_data.description IS 'Reference data display text.';
COMMENT ON COLUMN reference_data.data_group_id IS 'Group of reference data.';
COMMENT ON COLUMN reference_data.data_subgroup_id IS 'Sub grouping of reference data.';

ALTER TABLE reference_data
    ADD CONSTRAINT reference_data_data_group_id_fk
    FOREIGN KEY (data_group_id)
    REFERENCES data_group(id);
ALTER TABLE reference_data
    ADD CONSTRAINT reference_data_data_subgroup_id_fk
    FOREIGN KEY (data_subgroup_id)
    REFERENCES data_subgroup(id);


INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('ELIGIBILIT', 'PIP', 'PIP', 1, 'ELIG_AUTO'),
('ELIGIBILIT', 'DLA', 'DLA', 2, 'ELIG_AUTO'),
('ELIGIBILIT', 'AFRFCS', 'Armed Forces Compensation scheme', 3, 'ELIG_AUTO'),
('ELIGIBILIT', 'WPMS', 'War Pensioners'' Mobility Supplement', 4, 'ELIG_AUTO'),
('ELIGIBILIT', 'BLIND', 'Registered blind', 5, 'ELIG_AUTO'),
('ELIGIBILIT', 'WALKD', 'Walking ability', 6, 'ELIG_FURTH'),
('ELIGIBILIT', 'ARMS', 'Disability in both arms', 7, 'ELIG_FURTH'),
('ELIGIBILIT', 'CHILDBULK', 'Child under 3 with bulky medical equipment', 8, 'ELIG_FURTH'),
('ELIGIBILIT', 'CHILDVEHIC', 'Child under 3 who needs to be near a vehicle', 9, 'ELIG_FURTH'),
('ELIGIBILIT', 'TERMILL', 'Terminal illness', 10, 'ELIG_FURTH'),
('APPSOURCE', 'PAPER', 'Paper', 1, null),
('APPSOURCE', 'PHONE', 'Phone', 2, null),
('APPSOURCE', 'INPERSON', 'In person', 3, null),
('APPSOURCE', 'ONLINE', 'Online', 4, null),
('PARTY', 'PERSON', 'Person', 1, null),
('PARTY', 'ORG', 'Organisation', 2, null)
;

CREATE TABLE group_domain_map(
  data_group_id VARCHAR(10),
  data_domain_id VARCHAR(10),
  PRIMARY KEY (data_domain_id, data_group_id)
);

COMMENT ON TABLE group_domain_map IS 'Assignes sets of reference data to services.';
COMMENT ON COLUMN group_domain_map.data_group_id IS 'FK.';
COMMENT ON COLUMN group_domain_map.data_domain_id IS 'FK.';

ALTER TABLE group_domain_map
    ADD CONSTRAINT group_domain_map_category_fk
    FOREIGN KEY (data_group_id)
    REFERENCES data_group(id);

ALTER TABLE group_domain_map
    ADD CONSTRAINT group_domain_map_domain_id_fk
    FOREIGN KEY (data_domain_id)
    REFERENCES data_domain(id);

INSERT INTO group_domain_map (data_group_id, data_domain_id) VALUES
  ('ELIGIBILIT', 'BADGE'),
  ('ELIGIBILIT', 'APP'),
  ('APPSOURCE', 'BADGE'),
  ('APPSOURCE', 'APP'),
  ('PARTY', 'BADGE'),
  ('PARTY', 'APP')
;

CREATE OR REPLACE VIEW reference_data_vw AS
  SELECT
    rd.code,
    rd.description,
    rd.data_group_id AS group_code,
    dg.description AS group_description,
    rd.data_subgroup_id AS sub_group_code,
    dsg.description AS sub_group_description,
    rd.display_order,
    ccm.data_domain_id
  FROM reference_data rd
  INNER JOIN group_domain_map ccm
    ON (ccm.data_group_id = rd.data_group_id)
  INNER JOIN data_group dg
    ON (rd.data_group_id = dg.id)
  LEFT JOIN data_subgroup dsg
    ON (rd.data_subgroup_id = dsg.id)
  ORDER BY (ccm.data_domain_id, rd.data_group_id, dsg.id, rd.display_order);

--//@UNDO
-- SQL to undo the change goes here.
DROP VIEW IF EXISTS reference_data_vw CASCADE;
DROP TABLE IF EXISTS reference_data CASCADE;
DROP TABLE IF EXISTS group_domain_map CASCADE;
DROP TABLE IF EXISTS data_group CASCADE;
DROP TABLE IF EXISTS data_domain CASCADE;
DROP TABLE IF EXISTS data_subgroup CASCADE;
