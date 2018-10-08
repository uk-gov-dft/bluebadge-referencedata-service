DELETE FROM referencedata.reference_data WHERE data_group_id='LC' AND code IN (
'NYKCC', 'CRA', 'HAE', 'HAG', 'RIH',
'RYE', 'SCE', 'SEL', 'ESUCC', 'EAS',
'HAS', 'LEE', 'ROH', 'WEA', 'SURCC',
'ELM', 'EPS', 'GRT', 'MOL', 'REI',
'RUN', 'SPE', 'SUR', 'TAN', 'WAE',
'WOI');

insert into referencedata.reference_data(data_group_id, code, description, data_subgroup_id, meta_data) VALUES
  ('LC', 'NWA', 'North Warwickshire borough council', null, '{"issuingAuthorityShortCode":"WARCC"}'),
  ('LC', 'NUN', 'Nuneaton and Bedworth borough council', null, '{"issuingAuthorityShortCode":"WARCC"}'),
  ('LC', 'RUG', 'Rugby borough council', null, '{"issuingAuthorityShortCode":"WARCC"}'),
  ('LC', 'STR', 'Stratford-on-Avon district council', null, '{"issuingAuthorityShortCode":"WARCC"}'),
  ('LC', 'WAW', 'Warwick district council', null, '{"issuingAuthorityShortCode":"WARCC"}'),
  ('LC', 'WARCC', 'Warwickshire county council', null, '{"issuingAuthorityShortCode":"WARCC"}'),
  ('LC', 'BAB', 'Babergh district council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'FOR', 'Forest Heath district council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'IPS', 'Ipswich borough council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'MSU', 'Mid Suffolk district council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'SED', 'St Edmundsbury borough council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'SUF', 'Suffolk Coastal district council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'SUFCC', 'Suffolk county council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'WAV', 'Waveney district council', null, '{"issuingAuthorityShortCode":"SUFCC"}'),
  ('LC', 'BARNS', 'Barnsley metropolitan borough council', null, '{"issuingAuthorityShortCode":"BARNS"}');

update referencedata.reference_data
    set meta_data = '{"issuingAuthorityShortCode": "WARCC",
        "issuingAuthorityName": "Warwickshire county council",
        "nation": "ENG",
        "contactUrl": "https://www.warwickshire.gov.uk/bluebadges"}'
     where data_group_id='LA' and code='WARCC';
update referencedata.reference_data
    set meta_data = '{"issuingAuthorityShortCode": "SUFCC",
        "issuingAuthorityName": "Suffolk county council",
        "nation": "ENG",
        "contactUrl": "https://www.suffolk.gov.uk/roads-and-transport/parking/blue-badge-scheme/who-can-get-a-blue-badge/"}'
    where data_group_id='LA' and code='SUFCC';
update referencedata.reference_data
    set meta_data = '{"issuingAuthorityShortCode": "BARNS",
        "issuingAuthorityName": "Barnsley metropolitan borough council",
        "nation": "ENG",
        "contactUrl": "https://www.barnsley.gov.uk/services/roads-travel-and-parking/parking/blue-badges/"}'
    where data_group_id='LA' and code='BARNS';

-- //@UNDO
-- SQL to undo the change goes here.
insert into referencedata.reference_data(data_group_id, code, description, data_subgroup_id, meta_data) VALUES
  ('LC', 'NYKCC', 'North Yorkshire county council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'CRA', 'Craven district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'HAE', 'Hambleton district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'HAG', 'Harrogate borough council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'RIH', 'Richmondshire district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'RYE', 'Ryedale district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'SCE', 'Scarborough borough council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'SEL', 'Selby district council', null, '{"issuingAuthorityShortCode":"NYKCC"}')
  ,('LC', 'ESUCC', 'East Sussex county council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'EAS', 'Eastbourne borough council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'HAS', 'Hastings borough council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'LEE', 'Lewes district council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'ROH', 'Rother district council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
  ,('LC', 'WEA', 'Wealden district council', null, '{"issuingAuthorityShortCode":"ESUCC"}')
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
  ,('LC', 'WOI', 'Woking borough council', null, '{"issuingAuthorityShortCode":"SURCC"}');

DELETE FROM referencedata.reference_data WHERE data_group_id='LC' AND code IN (
'NWA', 'NUN', 'RUG', 'STR', 'WAW',
'WARCC', 'BAB', 'FOR', 'IPS', 'MSU',
'SED', 'SUF', 'SUFCC', 'WAV', 'BARNS');

update referencedata.reference_data set meta_data = null where data_group_id='LA' and code='WARCC';
update referencedata.reference_data set meta_data = null where data_group_id='LA' and code='SUFCC';
update referencedata.reference_data set meta_data = null where data_group_id='LA' and code='BARNS';
