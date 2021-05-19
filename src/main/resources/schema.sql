DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  dob DATE NOT NULL,
  designation VARCHAR(40) DEFAULT NULL,
  salary DOUBLE DEFAULT NULL,
  address VARCHAR(50) DEFAULT NULL,
  blood_group VARCHAR(10) DEFAULT NULL
);