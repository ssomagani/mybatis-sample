package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	
//	create procedure SELECTFROMCONTESTANTS as select contestant_name from contestants where contestant_number = ?;
	
//	@Update(value = "{exec SelectFromContestants #{contestantNumber, mode=IN},#{contestant_name, mode=OUT, jdbcType=VARCHAR})")
	@Select(value = "select * from contestants where contestant_number = #{contestantNumber}")
	@Options(statementType = StatementType.PREPARED)
    List<Map<String, Object>> exec(@Param("contestantNumber") int contestantNumber);
	
//	@Select(value = "{call SelectAllContestants}")
	@Select(value = "call SELECTFROMCONTESTANTS(#{contestantNumber, mode=IN})")
	@Options(statementType = StatementType.PREPARED)
    List<Map<String, Object>> getOne(@Param("contestantNumber") int contestantNumber);
}
