CREATE TABLE employee(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(20),
    salary INT  NOT NULL,
    department_id INT,
    manager_id INT,
    designation ENUM('ASSOCIATE', 'MANAGER', 'ARCHITECT')
);

CREATE TABLE department(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(20)
);