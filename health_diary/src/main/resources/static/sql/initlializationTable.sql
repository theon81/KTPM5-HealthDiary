USE Health_Diary;

-- Tạo bảng Users
CREATE TABLE Users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, 
    roles BOOLEAN NOT NULL, 
    username VARCHAR(255) NOT NULL UNIQUE, 
    password VARCHAR(255) NOT NULL
);

-- Tạo bảng Foods
CREATE TABLE Foods (
    foodid BIGINT PRIMARY KEY AUTO_INCREMENT, 
    nameFood VARCHAR(255) NOT NULL,
    typeFood VARCHAR(255),
    weightLimit DOUBLE
);

-- Tạo bảng DietPlans
CREATE TABLE DietPlans (
    planid BIGINT PRIMARY KEY AUTO_INCREMENT, 
    nameplan VARCHAR(255) NOT NULL,
    typeplan VARCHAR(255),
    startdate DATE,
    enddate DATE
);

-- Bảng trung gian để thiết lập mối quan hệ N-N giữa Users và DietPlans
CREATE TABLE User_DietPlans (
    planid BIGINT,
    userid BIGINT,
    FOREIGN KEY (planid) REFERENCES DietPlans(planid) ON DELETE CASCADE,
    FOREIGN KEY (userid) REFERENCES Users(id) ON DELETE CASCADE,
    PRIMARY KEY (planid, userid)
);

-- Bảng trung gian để thiết lập mối quan hệ N-N giữa Foods và DietPlans
CREATE TABLE Food_DietPlans (
    planid BIGINT,
    foodid BIGINT,
    FOREIGN KEY (planid) REFERENCES DietPlans(planid) ON DELETE CASCADE,
    FOREIGN KEY (foodid) REFERENCES Foods(foodid) ON DELETE CASCADE,
    PRIMARY KEY (planid, foodid)
);

INSERT INTO Users (roles, username, password) VALUES
(false, 'Kieutung', '05022004'),
(true, 'Tiz', '180514');

INSERT INTO Foods (nameFood, typeFood, weightLimit) VALUES
('Chicken Breast', 'Protein', 500),
('Broccoli', 'Vegetable', 300),
('Rice', 'Carbohydrate', 1000);

INSERT INTO DietPlans (nameplan, typeplan, startdate, enddate) VALUES
('Gym Diet', 'Gym', '2024-01-01', '2024-06-01'),
('Diabetes Plan', 'Diabetes', '2024-02-01', '2024-07-01');

-- connect users and plan
INSERT INTO User_DietPlans (planid, userid) VALUES
(1, 1), -- Kieutung --> Gym Diet
(2, 2); -- Tiz --> Diabetes Plan

-- connect foods and plan 
INSERT INTO Food_DietPlans (planid, foodid) VALUES
(1, 1), -- Gym Diet --> Chicken Breast
(1, 2), -- Gym Diet --> Broccoli
(2, 3); -- Diabetes Plan --> Rice
