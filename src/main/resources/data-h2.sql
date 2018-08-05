INSERT INTO country (id, name, short_name) VALUES (1, 'United States', 'USA');
INSERT INTO country (id, name, short_name) VALUES (2, 'Norway', 'NOR');
INSERT INTO country (id, name, short_name) VALUES (3, 'Russia', 'RUS');

INSERT INTO player (id, name, country_id) VALUES (1, 'Magnus Carlson', 2);
INSERT INTO player (id, name, country_id) VALUES (2, 'Sergey Karjakin', 3);

INSERT INTO game (id, type, name) VALUES (1, 'TUTORIAL', 'Sicilian defense');
INSERT INTO gamemove (game_id, ordernum, color, piece, moveFrom, moveTo) VALUES (1, 1, 'WHITE', 'PAWN', 'e2', 'e4');
INSERT INTO gamemove (game_id, ordernum, color, piece, moveFrom, moveTo) VALUES (1, 2, 'BLACK', 'PAWN', 'c7', 'c5');

INSERT INTO tournament (id, name) VALUES (1, 'World Championship 2016');

INSERT INTO game (id, type) VALUES (2, 'REAL');
INSERT INTO gamemove (game_id, ordernum, color, piece, moveFrom, moveTo) VALUES (2, 1, 'WHITE', 'PAWN', 'e2', 'e4');
INSERT INTO gamemove (game_id, ordernum, color, piece, moveFrom, moveTo) VALUES (2, 2, 'BLACK', 'PAWN', 'c7', 'c5');

INSERT INTO tournament_game (game_id, tournament_id, player1_id, player2_id) VALUES (2, 1, 1, 2);

INSERT INTO tournament_player (tournament_id, player_id) VALUES (1, 1);
INSERT INTO tournament_player (tournament_id, player_id) VALUES (1, 2);
