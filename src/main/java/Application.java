import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.ResultMapper;

public class Application {

	public static void main(String[] args) throws SQLException {
		InputStream resource = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource, "default");

		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:voltdb://127.0.0.1:21212");
		conn.setAutoCommit(true);
		
//		try (SqlSession session = factory.openSession(true)) {
		try (SqlSession session = factory.openSession(conn)) {
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			System.out.println("Getting all: " + mapper.getAll());
			System.out.println("Getting by 1: " + mapper.getByNumber(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
