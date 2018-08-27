package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;

import model.Contestant;

public interface ResultMapper {
	
//	@Update(value = "{exec SelectFromContestants #{contestantNumber, mode=IN},#{contestant_name, mode=OUT, jdbcType=VARCHAR})")
	@Select(value = "select * from contestants where contestant_number = #{contestantNumber}")
	@Options(statementType = StatementType.PREPARED)
    List<Map<String, Object>> exec(@Param("contestantNumber") int contestantNumber);
	
	@Options(statementType = StatementType.CALLABLE, resultSetType=ResultSetType.SCROLL_INSENSITIVE)
	@Select(value = " { call SELECTFROMCONTESTANTS(#{contestantNumber, mode=IN}) } ")
	List<Contestant> getByNumber(@Param("contestantNumber") int contestantNumber);
	
	@Options(statementType = StatementType.CALLABLE, resultSetType=ResultSetType.SCROLL_INSENSITIVE)
	@Select(value = " { call GETALL } ")
    List<Contestant> getAll();
}
