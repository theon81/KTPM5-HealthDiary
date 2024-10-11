create database health_diary;

create table Account (
    ID bigint not null auto_increment,
    Roles boolean not null,
    Username varchar(255) not null,
    Password varchar(255) not null,
    PRIMARY KEY (ID)
);

create table DietPlan (
    planId bigint not null auto_increment,
    startDate date not null,
    endDate date not null,
    namePlan varchar(255) not null,
    primary key (planId)
);

create table WaterConsumption (
    waterId bigint not null auto_increment,
    date date not null,
    amount int not null,
    Foreign Key (ID) REFERENCES (Account.ID),
);

create table UserInfo (
    Foreign Key (ID) REFERENCES (Account.ID),
    Foreign Key (planId) REFERENCES (DietPlan.planId),
    Foreign Key (waterId) REFERENCES (WaterConsumption.waterId)

);
