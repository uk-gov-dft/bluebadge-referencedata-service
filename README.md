# DFT BLUE BADGE BETA - REFERENCEDATA-SERVICE

## Getting Started in few minutes
From command line:
```
git clone git@github.com:uk-gov-dft/referencedata-service.git
cd usermanagement-service
gradle wrapper
./gradlew build
./gradlew bootRun
```

## INSTALLATION
From command line:
```
brew install postgres
```
[Download and install pgadmin](https://www.pgadmin.org/download/pgadmin-4-macos/)

To Start postgresql:
```
pg_ctl start -D /usr/local/var/postgres
```

Create User (from command line):
```
createuser -W developer -P
createdb bb_dev
psql bb_dev -U developer
```

Create admin user (from command line):
```
createuser -s admin
psql bb_dev -U admin
```

Once you are in psql prompt, then follow the sql commands in this file [setup.sql](https://github.com/uk-gov-dft/referencedata-service/blob/develop/database-schema/setup.sql)
You may need to skip the first two steps if you do them before for other projects:
```
CREATE USER developer ***REMOVED***;
CREATE DATABASE bb_dev OWNER developer;
```

And if you want to change schema in psql to referencedata:
```
SET search_path TO referencedata;
```

To list tables:
```
\dt
```

To check the schemas en postrgresql:
```
select schema_name from information_schema.schemata;
```

To show current schema:
```SHOW search_path;```

To upgrade your schema, from reference data project parent folder
```
cd database-schema
gradle migrateUp -Penv=development
```

You may need to create the database using the (database-schemas project)[https://github.com/uk-gov-dft/database-schemas], please read the 
[database-schemes Readme](https://github.com/uk-gov-dft/database-schemas/blob/develop/migrations/README.md)

Some useful commands to test things in posgresql
```
psql bb_dev -U developer
\l to show all database
use database_name --- to change database
\dt to list tables 
```



## PLAY WITH THE API

See api-acceptance-tests for examples.
