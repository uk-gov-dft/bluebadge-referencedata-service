INSERT INTO data_group(id, description) VALUES
  ('STATUS', 'Badge status'),
  ('DELIVER', 'Deliver to'),
  ('DELOP', 'Delivery option'),
  ('GENDER', 'Gender'),
  ('APPREASON', 'Application reason'),
  ('REPLACE', 'Replace reason'),
  ('CANCEL', 'Cancel reason'),
  ('WALKDIFF', 'Walking difficulty'),
  ('WALKSPEED', 'Walking speed'),
  ('WALKLEN', 'Walking length of time'),
  ('WALKMOB', 'Walking mobility aids'),
  ('BULKEQUIP', 'Bulky medical equipment')
;


-- INSERT INTO data_subgroup(id, description) VALUES
--  ('ELIG_AUTO', 'Automatic'),
--  ('ELIG_FURTH', 'Further assessment')
-- ;

INSERT INTO reference_data (data_group_id, code, description, display_order, data_subgroup_id) VALUES
('STATUS', 'AWAITCOLL', 'Awaiting collection', 1, null),
('STATUS', 'AWAITING', 'Awaiting', 2, null),
('STATUS', 'CANCELLED', 'Cancelled', 3, null),
('STATUS', 'EXTRACTED', 'Extracted', 4, null),
('STATUS', 'FAILED', 'Failed', 5, null),
('STATUS', 'ISSUED', 'Issued', 6, null),
('STATUS', 'NEW', 'New', 7, null),
('STATUS', 'PENDCANC', 'Pending cancellation', 8, null),
('STATUS', 'REFUSED', 'Refused', 9, null),
('STATUS', 'REISSUED', 'Reissued', 10, null),
('STATUS', 'REPLACED', 'Replaced', 11, null),
('STATUS', 'RETCAN', 'TBC', 12, null),
('STATUS', 'RETURNED', 'Returned', 13, null),
('STATUS', 'SUBMITTED', 'Submitted', 14, null),
('DELIVER', 'HOME', 'Home address', 1, null),
('DELIVER', 'COUNCIL', 'Your council', 2, null),
('DELOP', 'STAND', 'Standard', 1, null),
('DELOP', 'FAST', 'Fast track', 2, null),
('GENDER', 'MALE', 'Male', 1, null),
('GENDER', 'FEMALE', 'Female', 2, null),
('GENDER', 'UNSPECIFIE', 'Unspecified', 3, null),
('APPREASON', 'BLIND', 'You''re severely sight impaired (blind)', 1, null),
('APPREASON', 'TERMILL', 'You have a terminal illness and are expected to live less than 6 months', 2, null),
('APPREASON', 'WALKD', 'You have a permanent disability which means you can''t walk or find walking very difficult', 3, null),
('APPREASON', 'ARMS', 'You have a severe disability in both arms and drive regularly, but can''t operate parking meters', 4, null),
('REPLACE', 'STOLE', 'Stolen', 1, null),
('REPLACE', 'LOST', 'Lost', 2, null),
('REPLACE', 'DAMAGED', 'Damaged', 3, null),
('CANCEL', 'DECEASE', 'Deceased', 1, null),
('CANCEL', 'NOLONG', 'No longer needed', 2, null),
('CANCEL', 'REVOKE', 'Revoked', 3, null),
('WALKDIFF', 'PAIN', 'Excessive pain', 1, null),
('WALKDIFF', 'BREATH', 'Breathlessness', 2, null),
('WALKDIFF', 'BALANCE', 'Balance or coordination', 3, null),
('WALKDIFF', 'DANGER', 'Dangerous to my health', 4, null),
('WALKDIFF', 'STRUGGLE', 'Struggle planning or following a journey', 5, null),
('WALKDIFF', 'SOMELSE', 'Something else', 6, null),
('WALKSPEED', 'MSLOW', 'Much slower', 1, null),
('WALKSPEED', 'SLOW', 'Slower', 2, null),
('WALKSPEED', 'SAME', 'About the same', 3, null),
('WALKSPEED', 'FAST', 'Faster', 4, null),
('WALKLEN', 'CANTWALK', 'You can''t walk at all', 1, null),
('WALKLEN', 'LESSMIN', 'Less than a minute', 2, null),
('WALKLEN', 'FEWMIN', 'A few minutes', 3, null),
('WALKLEN', 'MORETEN', 'More than 10 minutes', 4, null),
('WALKMOB', 'PRESCRIBE', 'Prescribed by a healthcare professional', 1, null),
('WALKMOB', 'PRIVATE', 'Bought privately', 2, null),
('WALKMOB', 'SOCIAL', 'Provided by Social Services', 3, null),
('BULKEQUIP', 'VENT', 'Ventilator', 1, null),
('BULKEQUIP', 'SUCTION', 'Suction machine', 1, null),
('BULKEQUIP', 'PUMP', 'Feed pump', 1, null),
('BULKEQUIP', 'PARENT', 'Parenteral equipment', 1, null),
('BULKEQUIP', 'SYRINGE', 'Syringe driver', 1, null),
('BULKEQUIP', 'OXYADMIN', 'Oxygen administration equipment', 1, null),
('BULKEQUIP', 'OXYSAT', 'Continuous oxygen saturation monitoring equipment', 1, null),
('BULKEQUIP', 'CAST', 'Casts and associated medical equipment for the correction of hip dysplasia', 1, null),
('BULKEQUIP', 'NONE', 'None of these', 1, null)
;

INSERT INTO group_domain_map (data_group_id, data_domain_id) VALUES
  ('STATUS', 'BADGE'),
  ('DELIVER', 'BADGE'),
  ('DELOP', 'BADGE'),
  ('GENDER', 'BADGE'),
  ('GENDER', 'APP'),
  ('APPREASON', 'APP'),
  ('REPLACE', 'APP'),
  ('CANCEL', 'APP'),
  ('WALKDIFF', 'APP'),
  ('WALKSPEED', 'APP'),
  ('WALKLEN', 'APP'),
  ('WALKMOB', 'APP'),
  ('BULKEQUIP', 'APP')
;

--//@UNDO
-- SQL to undo the change goes here.
DELETE FROM group_domain_map WHERE data_group_id IN
('STATUS', 'DELIVER', 'DELOP', 'GENDER', 'APPREASON', 'REPLACE', 'CANCEL',
'WALKDIFF', 'WALKSPEED', 'WALKLEN', 'WALKMOB', 'BULKEQUIP');
DELETE FROM reference_data WHERE data_group_id IN
('STATUS', 'DELIVER', 'DELOP', 'GENDER', 'APPREASON', 'REPLACE', 'CANCEL',
'WALKDIFF', 'WALKSPEED', 'WALKLEN', 'WALKMOB', 'BULKEQUIP');
DELETE FROM data_group  WHERE id IN
('STATUS', 'DELIVER', 'DELOP', 'GENDER', 'APPREASON', 'REPLACE', 'CANCEL',
'WALKDIFF', 'WALKSPEED', 'WALKLEN', 'WALKMOB', 'BULKEQUIP');
