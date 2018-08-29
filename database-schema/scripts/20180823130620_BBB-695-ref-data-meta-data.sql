-- // BBB-695-ref-data-meta-data
-- Migration SQL that makes the change goes here.

ALTER TABLE referencedata.reference_data ADD COLUMN meta_data json;

drop view reference_data_vw;

CREATE OR REPLACE VIEW reference_data_vw AS
SELECT rd.code,
    rd.description,
    rd.data_group_id AS group_code,
    rd.meta_data AS meta_data,
    dg.description AS group_description,
    rd.data_subgroup_id AS sub_group_code,
    dsg.description AS sub_group_description,
    rd.display_order,
    ccm.data_domain_id
   FROM (((referencedata.reference_data rd
     JOIN referencedata.group_domain_map ccm ON (((ccm.data_group_id)::text = (rd.data_group_id)::text)))
     JOIN referencedata.data_group dg ON (((rd.data_group_id)::text = (dg.id)::text)))
     LEFT JOIN referencedata.data_subgroup dsg ON (((rd.data_subgroup_id)::text = (dsg.id)::text)))
  ORDER BY ROW(ccm.data_domain_id, rd.data_group_id, dsg.id, rd.display_order);

update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"BRID","issuingAuthorityName":"Bridgend county borough council","nation":"WLS","contactUrl":"https://www.bridgend.gov.uk/residents/roads-transport-and-parking/blue-badge-applications"}' where data_group_id = 'LA' and code = 'BRID';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"CAER","issuingAuthorityName":"Caerphilly county borough council","nation":"WLS","contactUrl":"http://www.caerphilly.gov.uk/bluebadge"}' where data_group_id = 'LA' and code = 'CAER';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"ESUCC","issuingAuthorityName":"East Sussex county council","nation":"ENG","contactUrl":"https://www.eastsussex.gov.uk/socialcare/transport/blue-badge-guide/apply"}' where data_group_id = 'LA' and code = 'ESUCC';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"GLOCC","issuingAuthorityName":"Gloucestershire county council","nation":"ENG","contactUrl":"https://www.gloucestershire.gov.uk/health-and-social-care/disabilities/apply-for-a-blue-badge"}' where data_group_id = 'LA' and code = 'GLOCC';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"HAMCC","issuingAuthorityName":"Hampshire county council","nation":"ENG","contactUrl":"https://www.hants.gov.uk/transport/parking/bluebadge"}' where data_group_id = 'LA' and code = 'HAMCC';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"ANGL","issuingAuthorityName":"Isle of Anglesey county council","nation":"WLS","contactUrl":"http://www.anglesey.gov.uk/transport-and-roads/parking/blue-badge-scheme"}' where data_group_id = 'LA' and code = 'ANGL';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"KENTCC","issuingAuthorityName":"Kent county council","nation":"ENG","contactUrl":"https://www.kent.gov.uk/roads-and-travel/travelling-around-kent/parking/disabled-parking-blue-badge/apply-for-a-blue-badge"}' where data_group_id = 'LA' and code = 'KENTCC';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"LBEAL","issuingAuthorityName":"London borough of Ealing","nation":"ENG","contactUrl":"https://www.ealing.gov.uk/info/201175/community_transport/163/blue_badge_scheme"}' where data_group_id = 'LA' and code = 'LBEAL';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"NELIN","issuingAuthorityName":"North East Lincolnshire council","nation":"ENG","contactUrl":"https://www.nelincs.gov.uk/roads-parking-transport/parking/blue-badge-scheme"}' where data_group_id = 'LA' and code = 'NELIN';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"NYKCC","issuingAuthorityName":"North Yorkshire county council","nation":"ENG","contactUrl":"https://www.northyorks.gov.uk/blue-badge-parking-permits-disabled-people"}' where data_group_id = 'LA' and code = 'NYKCC';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"SURCC","issuingAuthorityName":"Surrey county council","nation":"ENG","contactUrl":"https://www.surreycc.gov.uk/roads-and-transport/parking/blue-badge"}' where data_group_id = 'LA' and code = 'SURCC';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"ABERD","issuingAuthorityName":"Aberdeenshire council","nation":"SCO","contactUrl":"https://www.aberdeenshire.gov.uk"}' where data_group_id = 'LA' and code = 'ABERD';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"EAYR","issuingAuthorityName":"East Ayrshire council","nation":"SCO","contactUrl":"http://www.east-ayrshire.gov.uk"}' where data_group_id = 'LA' and code = 'EAYR';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"NAYR","issuingAuthorityName":"North Ayrshire council","nation":"SCO","contactUrl":"https://www.north-ayrshire.gov.uk"}' where data_group_id = 'LA' and code = 'NAYR';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"SLAN","issuingAuthorityName":"South Lanarkshire council","nation":"SCO","contactUrl":"http://www.southlanarkshire.gov.uk/info/200224/disabilities/142/blue_badge_scheme"}' where data_group_id = 'LA' and code = 'SLAN';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"WDUN","issuingAuthorityName":"West Dunbartonshire council","nation":"SCO","contactUrl":"http://www.west-dunbarton.gov.uk"}' where data_group_id = 'LA' and code = 'WDUN';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"WLOTH","issuingAuthorityName":"West Lothian council","nation":"SCO","contactUrl":"http://www.westlothian.gov.uk"}' where data_group_id = 'LA' and code = 'WLOTH';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"WAKE","issuingAuthorityName":"Wakefield metropolitan district council","nation":"ENG","contactUrl":"http://www.wakefield.gov.uk/roads-and-transport/parking/blue-badge"}' where data_group_id = 'LA' and code = 'WAKE';
update referencedata.reference_data set meta_data = '{"issuingAuthorityShortCode":"WORCC","issuingAuthorityName":"Worcestershire county council","nation":"ENG","contactUrl":"http://www.worcestershire.gov.uk/info/20397/blue_badge/1378/apply_for_or_renew_a_badge"}' where data_group_id = 'LA' and code = 'WORCC';

insert into referencedata.data_domain(id, description) VALUES ('CITIZEN', 'Citizen web app');
insert into referencedata.data_group(id, description) VALUES ('LC', 'Local Councils'),('NATION', 'Nation');
insert into referencedata.group_domain_map(data_group_id, data_domain_id) VALUES
  ('LC', 'USER')
  ,('LC', 'APP')
  ,('LC', 'BADGE')
  ;
insert into referencedata.group_domain_map(data_group_id, data_domain_id)
  SELECT g.id, 'CITIZEN' from referencedata.data_group g
;

insert into referencedata.reference_data(data_group_id, code, description, data_subgroup_id, meta_data) VALUES
  ('NATION', 'SCO', 'Scotland', null, '{"badgeCost":20}')
  ,('NATION', 'ENG', 'England', null, '{"badgeCost":10}')
  ,('NATION', 'WLS', 'Wales', null, '{"badgeCost":0}')
  ,('NATION', 'NIR', 'Northern Island', null, '{"badgeCost":10}')
;

insert into referencedata.reference_data(data_group_id, code, description, data_subgroup_id, meta_data) VALUES
  ('LC', 'BRID', 'Bridgend county borough council', null, '{"issuingAuthorityShortCode":"BRID"}')
  ,('LC', 'CAER', 'Caerphilly county borough council', null, '{"issuingAuthorityShortCode":"CAER"}')
  ,('LC', 'ESUCC', 'East Sussex county council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'EAS', 'Eastbourne borough council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'HAS', 'Hastings borough council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'LEE', 'Lewes district council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'ROH', 'Rother district council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'WEA', 'Wealden district council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'GLOCC', 'Gloucestershire county council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'CHT', 'Cheltenham borough council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'COT', 'Cotswold district council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'FOE', 'Forest of Dean district council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'GLS', 'Gloucester city council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'STO', 'Stroud district council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'TEW', 'Tewkesbury borough council', null, '{"issuingAuthorityShortCode":"GLOCC"}')
  ,('LC', 'HAMCC', 'Hampshire county council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'BAN', 'Basingstoke and Deane borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'EHA', 'East Hampshire district council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'EAT', 'Eastleigh borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'FAR', 'Fareham borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'GOS', 'Gosport borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'HAT', 'Hart district council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'HAA', 'Havant borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'NEW', 'New Forest district council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'RUH', 'Rushmoor borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'TES', 'Test Valley borough council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'WIN', 'Winchester city council', null, '{"issuingAuthorityShortCode":"HAMCC"}')
  ,('LC', 'ANGL', 'Isle of Anglesey county council', null, '{"issuingAuthorityShortCode":"ANGL"}')
  ,('LC', 'KENTCC', 'Kent county council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'ASF', 'Ashford borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'CAT', 'Canterbury city council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'DAR', 'Dartford borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'DOV', 'Dover district council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'SHE', 'Folkestone and Hythe council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'GRA', 'Gravesham borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'MAI', 'Maidstone borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'SEV', 'Sevenoaks district council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'SWL', 'Swale borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'THA', 'Thanet district council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'TON', 'Tonbridge and Malling borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'TUN', 'Tunbridge Wells borough council', null, '{"issuingAuthorityShortCode":"KENTCC"}')
  ,('LC', 'LBEAL', 'London borough of Ealing', null, '{"issuingAuthorityShortCode":"LBEAL"}')
  ,('LC', 'NELIN', 'North East Lincolnshire council', null, '{"issuingAuthorityShortCode":"NELIN"}')
  ,('LC', 'NYKCC', 'North Yorkshire county council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'CRA', 'Craven district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'HAE', 'Hambleton district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'HAG', 'Harrogate borough council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'RIH', 'Richmondshire district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'RYE', 'Ryedale district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'SCE', 'Scarborough borough council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'SEL', 'Selby district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'SURCC', 'Surrey county council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'ELM', 'Elmbridge borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'EPS', 'Epsom and Ewell borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'GRT', 'Guildford borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'MOL', 'Mole Valley district council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'REI', 'Reigate and Banstead borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'RUN', 'Runnymede borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'SPE', 'Spelthorne borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'SUR', 'Surrey Heath borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'TAN', 'Tandridge district council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'WAE', 'Waverley borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'WOI', 'Woking borough council', null, '{"issuingAuthorityShortCode":"SURCC"}')
  ,('LC', 'ABERD', 'Aberdeenshire council', null, '{"issuingAuthorityShortCode":"ABERD"}')
  ,('LC', 'EAYR', 'East Ayrshire council', null, '{"issuingAuthorityShortCode":"EAYR"}')
  ,('LC', 'NAYR', 'North Ayrshire council', null, '{"issuingAuthorityShortCode":"NAYR"}')
  ,('LC', 'SLAN', 'South Lanarkshire council', null, '{"issuingAuthorityShortCode":"SLAN"}')
  ,('LC', 'WDUN', 'West Dunbartonshire council', null, '{"issuingAuthorityShortCode":"WDUN"}')
  ,('LC', 'WLOTH', 'West Lothian council', null, '{"issuingAuthorityShortCode":"WLOTH"}')
  ,('LC', 'WAKE', 'Wakefield metropolitan district council', null, '{"issuingAuthorityShortCode":"WAKE"}')
  ,('LC', 'WORCC', 'Worcestershire county council', null, '{"issuingAuthorityShortCode":"WORCC"}')
  ,('LC', 'BRM', 'Bromsgrove district council', null, '{"issuingAuthorityShortCode":"WORCC"}')
  ,('LC', 'MAV', 'Malvern Hills district council', null, '{"issuingAuthorityShortCode":"WORCC"}')
  ,('LC', 'RED', 'Redditch borough council', null, '{"issuingAuthorityShortCode":"WORCC"}')
  ,('LC', 'WOC', 'Worcester city council', null, '{"issuingAuthorityShortCode":"WORCC"}')
  ,('LC', 'WYC', 'Wychavon district council', null, '{"issuingAuthorityShortCode":"WORCC"}')
  ,('LC', 'WYE', 'Wyre Forest district council', null, '{"issuingAuthorityShortCode":"WORCC"}')
;

-- //@UNDO
-- SQL to undo the change goes here.
delete from referencedata.reference_data where data_group_id = 'LC';
delete from referencedata.reference_data where data_group_id = 'NATION';
delete from referencedata.group_domain_map where data_group_id = 'LC';
delete from referencedata.group_domain_map where data_domain_id = 'CITIZEN';
delete from referencedata.data_group where id = 'LC';
delete from referencedata.data_group where id = 'NATION';
delete from referencedata.data_domain where id = 'CITIZEN';

drop view reference_data_vw;

CREATE OR REPLACE VIEW reference_data_vw AS
SELECT rd.code,
    rd.description,
    rd.data_group_id AS group_code,
    dg.description AS group_description,
    rd.data_subgroup_id AS sub_group_code,
    dsg.description AS sub_group_description,
    rd.display_order,
    ccm.data_domain_id
   FROM (((referencedata.reference_data rd
     JOIN referencedata.group_domain_map ccm ON (((ccm.data_group_id)::text = (rd.data_group_id)::text)))
     JOIN referencedata.data_group dg ON (((rd.data_group_id)::text = (dg.id)::text)))
     LEFT JOIN referencedata.data_subgroup dsg ON (((rd.data_subgroup_id)::text = (dsg.id)::text)))
  ORDER BY ROW(ccm.data_domain_id, rd.data_group_id, dsg.id, rd.display_order);

ALTER TABLE referencedata.reference_data drop COLUMN meta_data;

