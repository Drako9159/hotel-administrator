CREATE DATABASE hotel;

USE hotel;

CREATE TABLE reservations (
  id INT NOT NULL AUTO_INCREMENT,
  check_in VARCHAR(100) NOT NULL,
  check_out VARCHAR(100) NOT NULL,
  value VARCHAR(100) NOT NULL,
  payment_method VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE guests (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  date_of_birth VARCHAR(255) NOT NULL,
  nationality VARCHAR(255) NOT NULL,
  telephone VARCHAR(100) NOT NULL,
  reservation_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (reservation_id) REFERENCES reservations(id)
);
