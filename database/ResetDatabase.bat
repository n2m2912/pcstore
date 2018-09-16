@ECHO OFF
ECHO Step 1: Input the password of root to drop the database if it exited.
mysql -u root -pMinhMan29121996 < pcstore_drop_database.sql

ECHO Step 2: Input the password of root to drop the database if it exited.
mysql -u root -pMinhMan29121996 < pcstore_create_database.sql

ECHO Step 3: Input the password of root to create the database.
mysql -u pcstore -pPcstore@123 pcstore < pcstore.sql

REM ECHO Step 4: Insert data to database pcstore
REM mysql -u pcstore -pPcstore@123 pcstore < pcstore_data.sql


PAUSE