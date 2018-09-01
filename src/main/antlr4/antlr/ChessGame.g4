grammar ChessGame;

parseGame
   returns [List<domain.Move> moves]
   : pair_move+
   ;

pair_move
   returns [Pair<domain.Move, domain.Move> movePair]
   : MoveNumber Dot move Comma move Dot
   ;

move
   : Castling|(Piece? Square MoveType Square (Check|Mate)?)
   ;

Piece
   : 'N' | 'Q' | 'K' | 'B' | 'R'
   ;

Square
   : [a-h] [1-8]
   ;

MoveType
   : Dash | Capture
   ;

Check
   : '+'
   ;

Mate
   : 'mate'
   ;

Castling
   : '0-0'
   ;

Comma
   : ','
   ;

Dot
   : '.'
   ;

Dash
   : '-'
   ;

Capture
   : 'x'
   ;

MoveNumber
   : ('0' .. '9')+
   ;

SPACES : [ \r\t\n]+ -> skip ;