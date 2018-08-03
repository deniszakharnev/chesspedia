package mybatis;

import domain.GameRecords;
import domain.Move;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameMapper {

    @Select("SELECT * from game where id = #{gameId}")
    GameRecords loadGameRecords(@Param("gameId") Long gameId);

    @Select("SELECT * from gamemove where game_id = #{gameId} order by ordernum asc, color desc")
    List<Move> loadGameMoves(@Param("gameId") Long gameId);
}
