SET search_path TO usermanagement;

DELETE FROM usermanagement.users WHERE id =-201;
DELETE FROM usermanagement.users WHERE id =-202;

INSERT INTO usermanagement.users (id, name, email_address, local_authority_short_code, role_id, password, user_uuid, is_active, login_fail_count)
VALUES
(-201, 'Dr. Pamela Lillian Isley', 'rd_dft_test_admin@dft.gov.uk', null, 1, '$2a$11$l8Y6fw6mOmj39naJfQtgvu1KITnSBDURsP7kCHWsJXthM.atfzNWC', '78800473-857b-4a08-b01b-d72957517123'::UUID, TRUE, 0 )
,
(-202, 'Bruce Wayne', 'rd_non_dft_admin@dft.gov.uk', 'ABERD', 2, '$2a$11$l8Y6fw6mOmj39naJfQtgvu1KITnSBDURsP7kCHWsJXthM.atfzNWC', '78800473-857b-4a08-b01b-d72957517321'::UUID, TRUE, 0 )
;

SET search_path TO referencedata;

DELETE FROM referencedata.reference_data WHERE data_group_id = 'LA' and code LIKE 'DELETE%';
DELETE FROM referencedata.reference_data WHERE data_group_id = 'LC' and code IN('LC_ADD', 'LC_UPDATE');


INSERT INTO referencedata.reference_data (data_group_id, code, description, display_order, data_subgroup_id, meta_data)
VALUES
   ('LA', 'DELETE_1', 'Test LA to update metadata', 0, null, '{"town": "Town", "county": "", "country": "United Kingdom", "postcode": "B69 9EL", "nameLine2": "", "addressLine1": "PO Box 15825", "addressLine2": "", "addressLine3": "", "addressLine4": "", "emailAddress": "email@mail.gov.uk", "contactNumber": "01715692266", "differentServiceSignpostUrl": "https://bluebadge.direct.gov.uk/bluebadge/why-are-you-here"}')
 , ('LA', 'DELETE_2', 'Test LA to add metadata', 0, null, '{"town": "Town", "county": "", "country": "United Kingdom", "postcode": "B69 9EL", "nameLine2": "", "addressLine1": "PO Box 15825", "addressLine2": "", "addressLine3": "", "addressLine4": "", "emailAddress": "email@mail.gov.uk", "contactNumber": "01015692266"}')
 , ('LC', 'LC_UPDATE', 'Test LC to update metadata', 0, null, '{"welshDescription": "Original"}')
 , ('LC', 'LC_ADD', 'Test LC to add metadata', 0, null, null)
;
