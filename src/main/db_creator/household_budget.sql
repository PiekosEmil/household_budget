CREATE schema household;

CREATE table household.transactions (
id INT PRIMARY KEY AUTO_INCREMENT,
type ENUM('income', 'outgo') NOT NULL,
description varchar(100),
amount decimal(6, 2),
date datetime
);

INSERT INTO household.transactions (type, description, amount, date)
VALUES ('income', 'Joe''s salary', 3500, '2024-03-10 12:10'),
('income', 'Mary''s salary', 3500, '2024-03-10 12:00'),
('outgo', 'Small shopping', 99.99, '2024-04-01 10:10'),
('outgo', 'Garden utils', 149.99, '2024-05-02 11:11');