package mybatis;

import domain.GameRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GameMapper {

    @Select("SELECT * from game where id = #{gameId}")
    GameRecords loadGameRecords(@Param("gameId") Long gameId);
}
