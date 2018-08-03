INSERT INTO country (name, short_name) VALUES ('United States', 'USA');
INSERT INTO country (name, short_name) VALUES ('Norway', 'NOR');

INSERT INTO game (id, type, name) VALUES (1, 'TUTORIAL', 'Sicilian defense');
INSERT INTO gamemove (game_id, ordernum, color, piece, moveFrom, moveTo) VALUES (1, 1, 'WHITE', 'PAWN', 'e2', 'e4');
INSERT INTO gamemove (game_id, ordernum, color, piece, moveFrom, moveTo) VALUES (1, 2, 'BLACK', 'PAWN', 'c7', 'c5');