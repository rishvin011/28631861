# Document Management System
To develop a menu based console application that will simulate a document management for a law firm

## Setup Instructions

1. Create a database and the create table using MySQL with the following script

MySQL scripts that has to be ran in your MySQL Workbench:

	1. create database lawFirmDB;
	2. use lawFirmDB;
	3. CREATE TABLE documents (
   Document_id INT AUTO_INCREMENT PRIMARY KEY,
   Title VARCHAR(255),
   Description varchar(50),
   File_Path VARCHAR(255),
   Upload_Date DATE);
	4.CREATE TABLE clients (
    Client_id INT PRIMARY KEY,
    Name VARCHAR(255),
    Contact VARCHAR(15), 
    Email VARCHAR(255),
    Address VARCHAR(255));
	5. CREATE TABLE cases (
    Case_id INT AUTO_INCREMENT PRIMARY KEY,
    Client_id INT,
    Case_num INT,
    Description VARCHAR(255),
    Status VARCHAR(50),
    Open_date DATE,
    Close_date DATE,
    FOREIGN KEY (Client_id) REFERENCES clients(Client_id));



2. Enter credentials in the `DBConnection.java` file with your MySQL url, username and password.
3. Install JAR file by creating a folder under the project
4. Compile and run the `Main.java` file.


## Requirements

- Java JDK 8 or higher
- MySQL Server
- JDBC Driver for MySQL