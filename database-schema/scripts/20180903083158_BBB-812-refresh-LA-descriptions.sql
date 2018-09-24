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

-- // BBB-812-refresh-LA-descriptions
-- Migration SQL that makes the change goes here.

UPDATE referencedata.reference_data SET description ='Aberdeen city council' where data_group_id='LA' and code ='ABERC';
UPDATE referencedata.reference_data SET description ='Aberdeenshire council' where data_group_id='LA' and code ='ABERD';
UPDATE referencedata.reference_data SET description ='Isle of Anglesey county council' where data_group_id='LA' and code ='ANGL';
UPDATE referencedata.reference_data SET description ='Angus council' where data_group_id='LA' and code ='ANGUS';
UPDATE referencedata.reference_data SET description ='Argyll and Bute council' where data_group_id='LA' and code ='ARBUT';
UPDATE referencedata.reference_data SET description ='Barnsley metropolitan borough council' where data_group_id='LA' and code ='BARNS';
UPDATE referencedata.reference_data SET description ='Bedford borough council' where data_group_id='LA' and code ='BEDF';
UPDATE referencedata.reference_data SET description ='Birmingham city council' where data_group_id='LA' and code ='BIRM';
UPDATE referencedata.reference_data SET description ='Blackpool borough council' where data_group_id='LA' and code ='BLACK';
UPDATE referencedata.reference_data SET description ='Blackburn with Darwen borough council' where data_group_id='LA' and code ='BLDRN';
UPDATE referencedata.reference_data SET description ='Blaenau Gwent county borough council' where data_group_id='LA' and code ='BLGW';
UPDATE referencedata.reference_data SET description ='Bolton metropolitan borough council' where data_group_id='LA' and code ='BOLT';
UPDATE referencedata.reference_data SET description ='Bournemouth borough council' where data_group_id='LA' and code ='BOURN';
UPDATE referencedata.reference_data SET description ='City of Bradford metropolitan district council' where data_group_id='LA' and code ='BRAD';
UPDATE referencedata.reference_data SET description ='Bracknell Forest council' where data_group_id='LA' and code ='BRAFR';
UPDATE referencedata.reference_data SET description ='Bridgend county borough council' where data_group_id='LA' and code ='BRID';
UPDATE referencedata.reference_data SET description ='Brighton and Hove city council' where data_group_id='LA' and code ='BRIHV';
UPDATE referencedata.reference_data SET description ='Bristol city council' where data_group_id='LA' and code ='BRIST';
UPDATE referencedata.reference_data SET description ='Bath and North East Somerset council' where data_group_id='LA' and code ='BTNES';
UPDATE referencedata.reference_data SET description ='Buckinghamshire county council' where data_group_id='LA' and code ='BUCCC';
UPDATE referencedata.reference_data SET description ='Bury metropolitan borough council' where data_group_id='LA' and code ='BURY';
UPDATE referencedata.reference_data SET description ='Caerphilly county borough council' where data_group_id='LA' and code ='CAER';
UPDATE referencedata.reference_data SET description ='Calderdale metropolitan borough council' where data_group_id='LA' and code ='CALD';
UPDATE referencedata.reference_data SET description ='Cambridgeshire county council' where data_group_id='LA' and code ='CAMCC';
UPDATE referencedata.reference_data SET description ='City of Cardiff council' where data_group_id='LA' and code ='CARD';
UPDATE referencedata.reference_data SET description ='Carmarthenshire county council' where data_group_id='LA' and code ='CARM';
UPDATE referencedata.reference_data SET description ='Central Bedfordshire council' where data_group_id='LA' and code ='CBED';
UPDATE referencedata.reference_data SET description ='Ceredigion county council' where data_group_id='LA' and code ='CERE';
UPDATE referencedata.reference_data SET description ='Cheshire East council' where data_group_id='LA' and code ='CHESE';
UPDATE referencedata.reference_data SET description ='Cheshire West and Chester council' where data_group_id='LA' and code ='CHEWC';
UPDATE referencedata.reference_data SET description ='Clackmannanshire council' where data_group_id='LA' and code ='CLACK';
UPDATE referencedata.reference_data SET description ='Conwy county borough council' where data_group_id='LA' and code ='CONWY';
UPDATE referencedata.reference_data SET description ='Cornwall council' where data_group_id='LA' and code ='CORN';
UPDATE referencedata.reference_data SET description ='Coventry city council' where data_group_id='LA' and code ='COV';
UPDATE referencedata.reference_data SET description ='Cumbria county council' where data_group_id='LA' and code ='CUMCC';
UPDATE referencedata.reference_data SET description ='Darlington borough council' where data_group_id='LA' and code ='DARL';
UPDATE referencedata.reference_data SET description ='Denbighshire county council' where data_group_id='LA' and code ='DENB';
UPDATE referencedata.reference_data SET description ='Derby city council' where data_group_id='LA' and code ='DERBY';
UPDATE referencedata.reference_data SET description ='Derbyshire county council' where data_group_id='LA' and code ='DERCC';
UPDATE referencedata.reference_data SET description ='Devon county council' where data_group_id='LA' and code ='DEVCC';
UPDATE referencedata.reference_data SET description ='Doncaster metropolitan borough council' where data_group_id='LA' and code ='DONC';
UPDATE referencedata.reference_data SET description ='Dorset county council' where data_group_id='LA' and code ='DORCC';
UPDATE referencedata.reference_data SET description ='Dudley metropolitan borough council' where data_group_id='LA' and code ='DUDL';
UPDATE referencedata.reference_data SET description ='Dumfries and Galloway council' where data_group_id='LA' and code ='DUMGL';
UPDATE referencedata.reference_data SET description ='Dundee city council' where data_group_id='LA' and code ='DUNDC';
UPDATE referencedata.reference_data SET description ='Durham county council' where data_group_id='LA' and code ='DURHM';
UPDATE referencedata.reference_data SET description ='East Ayrshire council' where data_group_id='LA' and code ='EAYR';
UPDATE referencedata.reference_data SET description ='City of Edinburgh council' where data_group_id='LA' and code ='EDIN';
UPDATE referencedata.reference_data SET description ='East Dunbartonshire council' where data_group_id='LA' and code ='EDUN';
UPDATE referencedata.reference_data SET description ='Comhairle nan Eilean Siar' where data_group_id='LA' and code ='EILSR';
UPDATE referencedata.reference_data SET description ='East Lothian council' where data_group_id='LA' and code ='ELOTH';
UPDATE referencedata.reference_data SET description ='East Renfrewshire council' where data_group_id='LA' and code ='EREN';
UPDATE referencedata.reference_data SET description ='Essex county council' where data_group_id='LA' and code ='ESSCC';
UPDATE referencedata.reference_data SET description ='East Sussex county council' where data_group_id='LA' and code ='ESUCC';
UPDATE referencedata.reference_data SET description ='East Riding of Yorkshire council' where data_group_id='LA' and code ='EYORK';
UPDATE referencedata.reference_data SET description ='Falkirk council' where data_group_id='LA' and code ='FALK';
UPDATE referencedata.reference_data SET description ='Fife council' where data_group_id='LA' and code ='FIFE';
UPDATE referencedata.reference_data SET description ='Flintshire county council' where data_group_id='LA' and code ='FLINT';
UPDATE referencedata.reference_data SET description ='Gateshead metropolitan borough council' where data_group_id='LA' and code ='GATES';
UPDATE referencedata.reference_data SET description ='Vale of Glamorgan council' where data_group_id='LA' and code ='GLAM';
UPDATE referencedata.reference_data SET description ='Glasgow city council' where data_group_id='LA' and code ='GLAS';
UPDATE referencedata.reference_data SET description ='Gloucestershire county council' where data_group_id='LA' and code ='GLOCC';
UPDATE referencedata.reference_data SET description ='Gwynedd council' where data_group_id='LA' and code ='GWYN';
UPDATE referencedata.reference_data SET description ='Halton borough council' where data_group_id='LA' and code ='HALT';
UPDATE referencedata.reference_data SET description ='Hampshire county council' where data_group_id='LA' and code ='HAMCC';
UPDATE referencedata.reference_data SET description ='Hartlepool borough council' where data_group_id='LA' and code ='HART';
UPDATE referencedata.reference_data SET description ='Hertfordshire county council' where data_group_id='LA' and code ='HERCC';
UPDATE referencedata.reference_data SET description ='Herefordshire council' where data_group_id='LA' and code ='HEREF';
UPDATE referencedata.reference_data SET description ='Highland council' where data_group_id='LA' and code ='HIGH';
UPDATE referencedata.reference_data SET description ='Hull city council' where data_group_id='LA' and code ='HULL';
UPDATE referencedata.reference_data SET description ='Inverclyde council' where data_group_id='LA' and code ='INVC';
UPDATE referencedata.reference_data SET description ='Council of the Isles of Scilly' where data_group_id='LA' and code ='IOS';
UPDATE referencedata.reference_data SET description ='Isle of Wight council' where data_group_id='LA' and code ='IOW';
UPDATE referencedata.reference_data SET description ='Kent county council' where data_group_id='LA' and code ='KENTCC';
UPDATE referencedata.reference_data SET description ='Kirklees council' where data_group_id='LA' and code ='KIRK';
UPDATE referencedata.reference_data SET description ='Knowsley metropolitan borough council' where data_group_id='LA' and code ='KNOWS';
UPDATE referencedata.reference_data SET description ='Lancashire county council' where data_group_id='LA' and code ='LANCC';
UPDATE referencedata.reference_data SET description ='London borough of Barking and Dagenham' where data_group_id='LA' and code ='LBBAD';
UPDATE referencedata.reference_data SET description ='London borough of Barnet' where data_group_id='LA' and code ='LBBAR';
UPDATE referencedata.reference_data SET description ='London borough of Bexley' where data_group_id='LA' and code ='LBBEX';
UPDATE referencedata.reference_data SET description ='London borough of Brent' where data_group_id='LA' and code ='LBBRE';
UPDATE referencedata.reference_data SET description ='London borough of Bromley' where data_group_id='LA' and code ='LBBRO';
UPDATE referencedata.reference_data SET description ='London borough of Camden' where data_group_id='LA' and code ='LBCAM';
UPDATE referencedata.reference_data SET description ='City of London Corporation' where data_group_id='LA' and code ='LBCOL';
UPDATE referencedata.reference_data SET description ='London borough of Croydon' where data_group_id='LA' and code ='LBCRO';
UPDATE referencedata.reference_data SET description ='London borough of Ealing' where data_group_id='LA' and code ='LBEAL';
UPDATE referencedata.reference_data SET description ='London borough of Enfield' where data_group_id='LA' and code ='LBENF';
UPDATE referencedata.reference_data SET description ='Royal borough of Greenwich' where data_group_id='LA' and code ='LBGRE';
UPDATE referencedata.reference_data SET description ='London borough of Hackney' where data_group_id='LA' and code ='LBHAC';
UPDATE referencedata.reference_data SET description ='London borough of Hammersmith and Fulham' where data_group_id='LA' and code ='LBHAF';
UPDATE referencedata.reference_data SET description ='London borough of Havering' where data_group_id='LA' and code ='LBHAV';
UPDATE referencedata.reference_data SET description ='London borough of Haringey' where data_group_id='LA' and code ='LBHGY';
UPDATE referencedata.reference_data SET description ='London borough of Hillingdon' where data_group_id='LA' and code ='LBHIL';
UPDATE referencedata.reference_data SET description ='London borough of Hounslow' where data_group_id='LA' and code ='LBHOW';
UPDATE referencedata.reference_data SET description ='London borough of Harrow' where data_group_id='LA' and code ='LBHRW';
UPDATE referencedata.reference_data SET description ='London borough of Islington' where data_group_id='LA' and code ='LBISL';
UPDATE referencedata.reference_data SET description ='Royal borough of Kensington and Chelsea' where data_group_id='LA' and code ='LBKC';
UPDATE referencedata.reference_data SET description ='Royal borough of Kingston upon Thames' where data_group_id='LA' and code ='LBKUT';
UPDATE referencedata.reference_data SET description ='London borough of Lambeth' where data_group_id='LA' and code ='LBLAM';
UPDATE referencedata.reference_data SET description ='London borough of Lewisham' where data_group_id='LA' and code ='LBLEW';
UPDATE referencedata.reference_data SET description ='London borough of Merton' where data_group_id='LA' and code ='LBMER';
UPDATE referencedata.reference_data SET description ='London borough of Newham' where data_group_id='LA' and code ='LBNEW';
UPDATE referencedata.reference_data SET description ='London borough of Redbridge' where data_group_id='LA' and code ='LBRED';
UPDATE referencedata.reference_data SET description ='London borough of Richmond upon Thames' where data_group_id='LA' and code ='LBRIC';
UPDATE referencedata.reference_data SET description ='London borough of Southwark' where data_group_id='LA' and code ='LBSOU';
UPDATE referencedata.reference_data SET description ='London borough of Sutton' where data_group_id='LA' and code ='LBSUT';
UPDATE referencedata.reference_data SET description ='London borough of Tower Hamlets' where data_group_id='LA' and code ='LBTHA';
UPDATE referencedata.reference_data SET description ='London borough of Waltham Forest' where data_group_id='LA' and code ='LBWAL';
UPDATE referencedata.reference_data SET description ='London borough of Wandsworth' where data_group_id='LA' and code ='LBWAN';
UPDATE referencedata.reference_data SET description ='City of Westminster' where data_group_id='LA' and code ='LBWES';
UPDATE referencedata.reference_data SET description ='Leeds city council' where data_group_id='LA' and code ='LEEDS';
UPDATE referencedata.reference_data SET description ='Leicester city council' where data_group_id='LA' and code ='LEIC';
UPDATE referencedata.reference_data SET description ='Leicestershire county council' where data_group_id='LA' and code ='LEICC';
UPDATE referencedata.reference_data SET description ='Lincolnshire county council' where data_group_id='LA' and code ='LINCC';
UPDATE referencedata.reference_data SET description ='Liverpool city council' where data_group_id='LA' and code ='LIVER';
UPDATE referencedata.reference_data SET description ='Luton borough council' where data_group_id='LA' and code ='LUTON';
UPDATE referencedata.reference_data SET description ='Manchester city council' where data_group_id='LA' and code ='MANC';
UPDATE referencedata.reference_data SET description ='Medway council' where data_group_id='LA' and code ='MEDTN';
UPDATE referencedata.reference_data SET description ='Merthyr Tydfil county borough council' where data_group_id='LA' and code ='MERTH';
UPDATE referencedata.reference_data SET description ='Middlesbrough borough council' where data_group_id='LA' and code ='MIDDL';
UPDATE referencedata.reference_data SET description ='Midlothian council' where data_group_id='LA' and code ='MIDLH';
UPDATE referencedata.reference_data SET description ='Milton Keynes council' where data_group_id='LA' and code ='MILKN';
UPDATE referencedata.reference_data SET description ='Monmouthshire county council' where data_group_id='LA' and code ='MON';
UPDATE referencedata.reference_data SET description ='Moray council' where data_group_id='LA' and code ='MORAY';
UPDATE referencedata.reference_data SET description ='North Ayrshire council' where data_group_id='LA' and code ='NAYR';
UPDATE referencedata.reference_data SET description ='Neath Port Talbot county borough council' where data_group_id='LA' and code ='NEATH';
UPDATE referencedata.reference_data SET description ='North East Lincolnshire council' where data_group_id='LA' and code ='NELIN';
UPDATE referencedata.reference_data SET description ='Newcastle city council' where data_group_id='LA' and code ='NEWC';
UPDATE referencedata.reference_data SET description ='Newport city council' where data_group_id='LA' and code ='NEWP';
UPDATE referencedata.reference_data SET description ='Northern Ireland' where data_group_id='LA' and code ='NIRE';
UPDATE referencedata.reference_data SET description ='North Lanarkshire council' where data_group_id='LA' and code ='NLAN';
UPDATE referencedata.reference_data SET description ='North Lincolnshire council' where data_group_id='LA' and code ='NLIN';
UPDATE referencedata.reference_data SET description ='Norfolk county council' where data_group_id='LA' and code ='NOFCC';
UPDATE referencedata.reference_data SET description ='Northamptonshire county council' where data_group_id='LA' and code ='NORCC';
UPDATE referencedata.reference_data SET description ='Northumberland county council' where data_group_id='LA' and code ='NORTH';
UPDATE referencedata.reference_data SET description ='Nottinghamshire county council' where data_group_id='LA' and code ='NOTCC';
UPDATE referencedata.reference_data SET description ='Nottingham city council' where data_group_id='LA' and code ='NOTT';
UPDATE referencedata.reference_data SET description ='North Somerset council' where data_group_id='LA' and code ='NSOM';
UPDATE referencedata.reference_data SET description ='North Tyneside council' where data_group_id='LA' and code ='NTYNE';
UPDATE referencedata.reference_data SET description ='North Yorkshire county council' where data_group_id='LA' and code ='NYKCC';
UPDATE referencedata.reference_data SET description ='Oldham metropolitan borough council' where data_group_id='LA' and code ='OLDH';
UPDATE referencedata.reference_data SET description ='Orkney Islands council' where data_group_id='LA' and code ='ORKNY';
UPDATE referencedata.reference_data SET description ='Oxfordshire county council' where data_group_id='LA' and code ='OXFCC';
UPDATE referencedata.reference_data SET description ='Pembrokeshire county council' where data_group_id='LA' and code ='PEMB';
UPDATE referencedata.reference_data SET description ='Perth and Kinross council' where data_group_id='LA' and code ='PERKN';
UPDATE referencedata.reference_data SET description ='Peterborough city council' where data_group_id='LA' and code ='PETBR';
UPDATE referencedata.reference_data SET description ='Plymouth city council' where data_group_id='LA' and code ='PLYM';
UPDATE referencedata.reference_data SET description ='Borough of Poole' where data_group_id='LA' and code ='POOLE';
UPDATE referencedata.reference_data SET description ='Portsmouth city council' where data_group_id='LA' and code ='PORTS';
UPDATE referencedata.reference_data SET description ='Powys county council' where data_group_id='LA' and code ='POWYS';
UPDATE referencedata.reference_data SET description ='Rhondda Cynon Taf county borough council' where data_group_id='LA' and code ='RCT';
UPDATE referencedata.reference_data SET description ='Reading borough council' where data_group_id='LA' and code ='READ';
UPDATE referencedata.reference_data SET description ='Redcar and Cleveland borough council' where data_group_id='LA' and code ='REDCL';
UPDATE referencedata.reference_data SET description ='Renfrewshire council' where data_group_id='LA' and code ='RENF';
UPDATE referencedata.reference_data SET description ='Rochdale metropolitan borough council' where data_group_id='LA' and code ='ROCH';
UPDATE referencedata.reference_data SET description ='Rotherham metropolitan borough council' where data_group_id='LA' and code ='ROTH';
UPDATE referencedata.reference_data SET description ='Rutland county council' where data_group_id='LA' and code ='RUT';
UPDATE referencedata.reference_data SET description ='Salford city council' where data_group_id='LA' and code ='SALF';
UPDATE referencedata.reference_data SET description ='Sandwell metropolitan borough council' where data_group_id='LA' and code ='SAND';
UPDATE referencedata.reference_data SET description ='South Ayrshire council' where data_group_id='LA' and code ='SAYR';
UPDATE referencedata.reference_data SET description ='Scottish Borders council' where data_group_id='LA' and code ='SCBRD';
UPDATE referencedata.reference_data SET description ='Sefton metropolitan borough council' where data_group_id='LA' and code ='SEFT';
UPDATE referencedata.reference_data SET description ='Southend-on-Sea borough council' where data_group_id='LA' and code ='SEND';
UPDATE referencedata.reference_data SET description ='South Gloucestershire council' where data_group_id='LA' and code ='SGLCS';
UPDATE referencedata.reference_data SET description ='Sheffield city council' where data_group_id='LA' and code ='SHEFF';
UPDATE referencedata.reference_data SET description ='Shetland Islands council' where data_group_id='LA' and code ='SHETL';
UPDATE referencedata.reference_data SET description ='Shropshire council' where data_group_id='LA' and code ='SHROP';
UPDATE referencedata.reference_data SET description ='South Lanarkshire council' where data_group_id='LA' and code ='SLAN';
UPDATE referencedata.reference_data SET description ='Slough borough council' where data_group_id='LA' and code ='SLGH';
UPDATE referencedata.reference_data SET description ='Solihull metropolitan borough council' where data_group_id='LA' and code ='SOLHL';
UPDATE referencedata.reference_data SET description ='Somerset county council' where data_group_id='LA' and code ='SOMCC';
UPDATE referencedata.reference_data SET description ='Southampton city council' where data_group_id='LA' and code ='SOUTH';
UPDATE referencedata.reference_data SET description ='Staffordshire county council' where data_group_id='LA' and code ='STACC';
UPDATE referencedata.reference_data SET description ='St Helens council' where data_group_id='LA' and code ='STHEL';
UPDATE referencedata.reference_data SET description ='Stirling council' where data_group_id='LA' and code ='STIR';
UPDATE referencedata.reference_data SET description ='Stockport metropolitan borough council' where data_group_id='LA' and code ='STOPT';
UPDATE referencedata.reference_data SET description ='Stockton-on-Tees borough council' where data_group_id='LA' and code ='STOTN';
UPDATE referencedata.reference_data SET description ='Stoke-on-Trent city council' where data_group_id='LA' and code ='STOTR';
UPDATE referencedata.reference_data SET description ='South Tyneside council' where data_group_id='LA' and code ='STYNE';
UPDATE referencedata.reference_data SET description ='Suffolk county council' where data_group_id='LA' and code ='SUFCC';
UPDATE referencedata.reference_data SET description ='Sunderland city council' where data_group_id='LA' and code ='SUND';
UPDATE referencedata.reference_data SET description ='Surrey county council' where data_group_id='LA' and code ='SURCC';
UPDATE referencedata.reference_data SET description ='City and county of Swansea council' where data_group_id='LA' and code ='SWAN';
UPDATE referencedata.reference_data SET description ='Swindon borough council' where data_group_id='LA' and code ='SWIND';
UPDATE referencedata.reference_data SET description ='Tameside metropolitan borough council' where data_group_id='LA' and code ='TAME';
UPDATE referencedata.reference_data SET description ='Telford and Wrekin council' where data_group_id='LA' and code ='TELWK';
UPDATE referencedata.reference_data SET description ='Thurrock council' where data_group_id='LA' and code ='THURK';
UPDATE referencedata.reference_data SET description ='Torbay council' where data_group_id='LA' and code ='TORB';
UPDATE referencedata.reference_data SET description ='Torfaen county borough council' where data_group_id='LA' and code ='TORF';
UPDATE referencedata.reference_data SET description ='Trafford metropolitan borough council' where data_group_id='LA' and code ='TRAF';
UPDATE referencedata.reference_data SET description ='Wakefield metropolitan district council' where data_group_id='LA' and code ='WAKE';
UPDATE referencedata.reference_data SET description ='Walsall metropolitan borough council' where data_group_id='LA' and code ='WAL';
UPDATE referencedata.reference_data SET description ='Warwickshire county council' where data_group_id='LA' and code ='WARCC';
UPDATE referencedata.reference_data SET description ='Warrington borough council' where data_group_id='LA' and code ='WARR';
UPDATE referencedata.reference_data SET description ='West Berkshire council' where data_group_id='LA' and code ='WBERK';
UPDATE referencedata.reference_data SET description ='West Dunbartonshire council' where data_group_id='LA' and code ='WDUN';
UPDATE referencedata.reference_data SET description ='Wigan metropolitan borough council' where data_group_id='LA' and code ='WIGAN';
UPDATE referencedata.reference_data SET description ='Wiltshire council' where data_group_id='LA' and code ='WILT';
UPDATE referencedata.reference_data SET description ='Royal borough of Windsor and Maidenhead' where data_group_id='LA' and code ='WINMD';
UPDATE referencedata.reference_data SET description ='Wirral borough council' where data_group_id='LA' and code ='WIRR';
UPDATE referencedata.reference_data SET description ='West Lothian council' where data_group_id='LA' and code ='WLOTH';
UPDATE referencedata.reference_data SET description ='Wokingham borough council' where data_group_id='LA' and code ='WOK';
UPDATE referencedata.reference_data SET description ='City of Wolverhampton council' where data_group_id='LA' and code ='WOLV';
UPDATE referencedata.reference_data SET description ='Worcestershire county council' where data_group_id='LA' and code ='WORCC';
UPDATE referencedata.reference_data SET description ='Wrexham county borough council' where data_group_id='LA' and code ='WREX';
UPDATE referencedata.reference_data SET description ='West Sussex county council' where data_group_id='LA' and code ='WSUCC';
UPDATE referencedata.reference_data SET description ='City of York council' where data_group_id='LA' and code ='YORK';

-- //@UNDO
-- SQL to undo the change goes here.


