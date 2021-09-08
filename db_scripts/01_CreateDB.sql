#Date: September 8 2021
#Author: Carlos Marin T
#Description: Init file that creates the database structure

#Creates the database
create database cellphone_app;

#Creates default user and password
create user 'cellphone_user'@'%%' identified by 'password';

#Grant required permissions
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES, REFERENCES ON cellphone_app.* TO 'cellphone_user'@'%%';

#Refresh privileges to take effect
FLUSH PRIVILEGES;
