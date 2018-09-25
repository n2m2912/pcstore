#!/bin/bash
echo "Step 1: Input the password of root to drop the database if it exited."
mysql -u root -p < pcstore_drop_database.sql
echo "Step 2: Input the password of root to create the database."
mysql -u root -p < pcstore_create_database.sql
echo "Step 3: Create table by user pcstore and password is Pcstore@123."
mysql -u pcstore -pPcstore@123 pcstore  < pcstore.sql
