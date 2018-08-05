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

CREATE TABLE tournament (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE gamemove (
  game_id  INT         NOT NULL,
  ordernum INT         NOT NULL,
  color    VARCHAR(10) NOT NULL,
  piece    VARCHAR(10) NOT NULL,
  moveFrom VARCHAR(2)  NOT NULL,
  moveTo   VARCHAR(2)  NOT NULL,
  PRIMARY KEY (game_id, ordernum, color)
);

ALTER TABLE gamemove ADD FOREIGN KEY (game_id) REFERENCES game (id);

CREATE TABLE tournament_game (
  game_id       INT NOT NULL,
  tournament_id INT NOT NULL,
  player1_id    INT NOT NULL,
  player2_id    INT NOT NULL,
  PRIMARY KEY (game_id)
);

ALTER TABLE tournament_game ADD FOREIGN KEY (game_id) REFERENCES game (id);
ALTER TABLE tournament_game ADD FOREIGN KEY (tournament_id) REFERENCES tournament (id);

CREATE TABLE tournament_player (
  tournament_id INT NOT NULL,
  player_id     INT NOT NULL,
  PRIMARY KEY (tournament_id, player_id)
);