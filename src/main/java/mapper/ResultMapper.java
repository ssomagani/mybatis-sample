package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface ResultMapper {
	
//	CREATE TABLE contestants
//	(
//	  contestant_number integer     NOT NULL
//	, contestant_name   varchar(50) NOT NULL
//	, CONSTRAINT PK_contestants PRIMARY KEY
//	  (
//	    contestant_number
//	  )
//	);
	
	
//    @Select("<script>" +
//            "SELECT contestant_number, contestant_name FROM contestants " +
//            "WHERE contestant_number = #{contestantNumber} " +
//            "</script>")
	
	@Select(value = "{CALL SelectFromContestants(#{contestant_number, mode=IN},#{contestant_name, mode=OUT, jdbcType=VARCHAR}")
	@Options(statementType = StatementType.CALLABLE)
    List<Map<String, Object>> select(@Param("contestantNumber") int contestantNumber);
}
