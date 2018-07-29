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

CREATE TABLE game (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(10) NOT NULL,
  name VARCHAR(45) DEFAULT NULL
);

CREATE TABLE gamemove (
  ordernum INT         NOT NULL,
  game_id  INT         NOT NULL,
  move     VARCHAR(10) NOT NULL,
  PRIMARY KEY (game_id, ordernum)
);

ALTER TABLE gamemove ADD FOREIGN KEY (game_id) REFERENCES game (id);