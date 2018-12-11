update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.cheshireeast.gov.uk/bluebadge", "contactUrl":"https://www.cheshireeast.gov.uk/benefits_housing_council_tax/blue_badge_scheme/blue_badge_scheme.aspx"}'
where data_group_id='LA' and code = 'CHESE';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.westminster.gov.uk/apply-renew-disabled-parking-badges", "contactUrl":"https://www.westminster.gov.uk/disabled-parking"}'
where data_group_id='LA' and code = 'LBWES';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.nidirect.gov.uk/services/apply-or-renew-blue-badge-online", "contactUrl":"https://www.nidirect.gov.uk/services/apply-or-renew-blue-badge-online"}'
where data_group_id='LA' and code = 'NIRE';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.essex.gov.uk/bluebadge", "contactUrl":"https://www.essex.gov.uk/bluebadge"}'
where data_group_id='LA' and code = 'ESSCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.dorsetforyou.gov.uk/parking/disabled-parking/blue-badges/apply-renew-blue-badge.aspx", "contactUrl":"https://www.dorsetforyou.gov.uk/parking/disabled-parking/blue-badges/blue-badge-eligibility.aspx"}'
where data_group_id='LA' and code = 'DORCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.cambridgeshire.gov.uk/residents/travel-roads-and-parking/parking-permits-and-fines/blue-badges/", "contactUrl":"https://www.cambridgeshire.gov.uk/residents/travel-roads-and-parking/parking-permits-and-fines/blue-badges/"}'
where data_group_id='LA' and code = 'CAMCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://selfservice.wokingham.gov.uk/services/apply-bluebadge/", "contactUrl":"http://www.wokingham.gov.uk/care-and-support-for-adults/parking-and-transport/blue-badge-permit-scheme-for-disabled-parking/"}'
where data_group_id='LA' and code = 'WOK';


update referencedata.reference_data
set meta_data = meta_data::JSONB - 'differentServiceSignpostUrl'
where data_group_id='LA' and code in ('BLACK', 'BEDF', 'LBBRO', 'DERCC', 'ELOTH', 'GLAS', 'BRIST', 'MANC', 'SCBRD', 'SEFT');

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.blackpool.gov.uk/Residents/Parking-roads-and-transport/Parking/Blue-badge-disabled-parking/Blue-Badge-disabled-parking.aspx"}'
where data_group_id='LA' and code = 'BLACK';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.bedford.gov.uk/transport_and_streets/parking/blue_badge_scheme.aspx"}'
where data_group_id='LA' and code = 'BEDF';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.bromley.gov.uk/info/279/disabled_parking_-_blue_badge"}'
where data_group_id='LA' and code = 'LBBRO';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.derbyshire.gov.uk/social-health/blue-badge-scheme/blue-badge-scheme.aspx"}'
where data_group_id='LA' and code = 'DERCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.eastlothian.gov.uk/info/210566/roads_and_transport/12010/blue_badge_scheme"}'
where data_group_id='LA' and code = 'ELOTH';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.glasgow.gov.uk/index.aspx?articleid=17226"}'
where data_group_id='LA' and code = 'GLAS';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.bristol.gov.uk/parking/apply-for-a-blue-badge"}'
where data_group_id='LA' and code = 'BRIST';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.manchester.gov.uk/homepage/773/blue_badges"}'
where data_group_id='LA' and code = 'MANC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.scotborders.gov.uk/info/20029/parking"}'
where data_group_id='LA' and code = 'SCBRD';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"contactUrl":"https://www.sefton.gov.uk/parking,-roads-travel/parking/blue-badge-applications.aspx"}'
where data_group_id='LA' and code = 'SEFT';




update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}'
where data_group_id='LA' and code in ('WARCC', 'WORCC', 'GLOCC');


-- //@UNDO
-- SQL to undo the change goes here.
update referencedata.reference_data
set meta_data = meta_data::JSONB - 'contactUrl'
where data_group_id='LA' and code in ('CHESE', 'LBWES', 'NIRE', 'ESSCC', 'DORCC', 'CAMCC', 'WOK');

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}'
where data_group_id='LA' and code = 'CHESE';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.westminster.gov.uk/apply-renew-disabled-parking-badges#apply-for-a-badge"}'
where data_group_id='LA' and code = 'LBWES';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.nidirect.gov.uk/services/apply-or-renew-blue-badge-online"}'
where data_group_id='LA' and code = 'NIRE';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.essex.gov.uk/Health-Social-Care/Health-and-social-care-for-adults/Blue-Badges/Pages/blue-badges.aspx"}'
where data_group_id='LA' and code = 'ESSCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://www.dorsetforyou.gov.uk/parking/disabled-parking/blue-badges/apply-renew-blue-badge.aspx"}'
where data_group_id='LA' and code = 'DORCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.cambridgeshire.gov.uk/w/webpage/295"}'
where data_group_id='LA' and code = 'CAMCC';

update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}'
where data_group_id='LA' and code = 'WOK';



update referencedata.reference_data
set meta_data = meta_data::JSONB || '{"differentServiceSignpostUrl":"https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}'
where data_group_id='LA' and code in ('BLACK', 'BEDF', 'LBBRO', 'DERCC', 'ELOTH', 'GLAS', 'BRIST', 'MANC', 'SCBRD', 'SEFT');

update referencedata.reference_data
set meta_data = meta_data::JSONB - 'contactUrl'
where data_group_id='LA' and code in ('BLACK', 'BEDF', 'LBBRO', 'DERCC', 'ELOTH', 'GLAS', 'BRIST', 'MANC', 'SCBRD', 'SEFT');



update referencedata.reference_data
set meta_data = meta_data::JSONB - 'differentServiceSignpostUrl'
where data_group_id='LA' and code in ('WARCC', 'WORCC', 'GLOCC');
