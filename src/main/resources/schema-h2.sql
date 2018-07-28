CREATE TABLE country (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(45) NOT NULL,
  short_name VARCHAR(10)
);

ALTER TABLE country ADD CONSTRAINT NAME_UNIQUE UNIQUE (NAME);

CREATE TABLE player (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(45) NOT NULL,
  country_id INT         NOT NULL
);

ALTER TABLE player ADD FOREIGN KEY (country_id) REFERENCES country (id);