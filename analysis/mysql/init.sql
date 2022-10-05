CREATE DATABASE IF NOT EXISTS `temperature`;
USE `temperature`;
CREATE TABLE Temperature (
  id INT NOT NULL AUTO_INCREMENT,
  temperature_value FLOAT NOT NULL,
  PRIMARY KEY (id)
);
INSERT INTO Temperature (temperature_value) VALUES (0.0);
INSERT INTO Temperature (temperature_value) VALUES (1.2);
INSERT INTO Temperature (temperature_value) VALUES (2.5);
INSERT INTO Temperature (temperature_value) VALUES (5.2);
INSERT INTO Temperature (temperature_value) VALUES (20.0);
