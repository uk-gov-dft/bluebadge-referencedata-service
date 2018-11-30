update referencedata.reference_data
set meta_data = '{"differentServiceSignpostUrl":"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}'
where data_group_id='LA' and code not in (
'ABERD', 'ANGL', 'BARNS', 'BRID', 'CAER',
'EAYR', 'ESUCC', 'GLOCC', 'LBEAL', 'NELIN',
'SLAN', 'SUFCC', 'WAKE', 'WARCC', 'WDUN',
'WLOTH', 'WORCC',
'HAMCC', 'KENTCC', 'NAYR', 'NYKCC', 'SURCC');

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}'
where data_group_id='LA' and code  in ('HAMCC', 'KENTCC', 'NAYR', 'NYKCC', 'SURCC');

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.nidirect.gov.uk/services/apply-or-renew-blue-badge-online"}'
where data_group_id='LA' and code = 'NIRE';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.cambridgeshire.gov.uk/w/webpage/295"}'
where data_group_id='LA' and code = 'CAMCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.dorsetforyou.gov.uk/parking/disabled-parking/blue-badges/apply-renew-blue-badge.aspx"}'
where data_group_id='LA' and code = 'DORCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.essex.gov.uk/Health-Social-Care/Health-and-social-care-for-adults/Blue-Badges/Pages/blue-badges.aspx"}'
where data_group_id='LA' and code = 'ESSCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.westminster.gov.uk/apply-renew-disabled-parking-badges#apply-for-a-badge"}'
where data_group_id='LA' and code = 'LBWES';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.southwark.gov.uk/parking/disabled-parking/blue-badge"}'
where data_group_id='LA' and code = 'LBSOU';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.eastriding.gov.uk/environment/roads-streets-traffic-and-parking/parking/blue-badge-parking-permits/"}'
where data_group_id='LA' and code = 'EYORK';


update referencedata.reference_data set meta_data = meta_data::JSONB - 'isActive' where data_group_id='LC';

-- //@UNDO
-- SQL to undo the change goes here.
update referencedata.reference_data
set meta_data = meta_data::JSONB - 'differentServiceSignpostUrl'
where data_group_id='LA';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"isActive":false}'
where data_group_id = 'LC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"isActive":true}'
where data_group_id = 'LC' and code in
(
'BRID', 'CAER', 'ESUCC', 'EAS', 'HAS', 'LEE', 'ROH', 'WEA', 'GLOCC',
'CHT', 'COT', 'FOE', 'GLS', 'STO', 'TEW', 'ANGL', 'LBEAL', 'NELIN', 'ABERD',
'EAYR', 'SLAN', 'WDUN', 'WLOTH', 'WAKE', 'WORCC', 'BRM', 'MAV', 'RED', 'WOC',
'WYC', 'WYE', 'NWA', 'NUN', 'RUG', 'STR', 'WAW', 'WARCC', 'BAB', 'FOR',
'IPS', 'MSU', 'SED', 'SUF', 'SUFCC', 'WAV', 'BARNS'
);

