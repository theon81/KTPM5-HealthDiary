-- Active: 1728617603603@@mysql-health-diary-final-report.l.aivencloud.com@10536@defaultdb
-- Create the health_diary database and switch to it
CREATE DATABASE IF NOT EXISTS Health_Diary;
USE Health_Diary;

-- Create the Account table
CREATE TABLE IF NOT EXISTS Account (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    Roles BOOLEAN NOT NULL,
    Username VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

-- Create the DietPlan table
CREATE TABLE IF NOT EXISTS DietPlan (
    planId BIGINT NOT NULL AUTO_INCREMENT,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    namePlan VARCHAR(255) NOT NULL,
    PRIMARY KEY (planId)
);

select * from Account;
select * from DietPlan;