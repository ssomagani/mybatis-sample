import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.TransactionFactory;

import mapper.ResultMapper;

public class Application {

	public static void main(String[] args) throws SQLException {
		InputStream resource = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource, "default");

		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:voltdb://127.0.0.1:21212");
		
		CallableStatement proc = conn.prepareCall("{call SELECTFROMCONTESTANTS(?)}");
		proc.setInt(1, 1);
		ResultSet results = proc.executeQuery();
		
		while (results.next()) {
            System.out.printf("%s !\n", results.getString(1));
        }
		try (SqlSession session = factory.openSession(conn)) {
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			System.out.println("SQL Query: " + mapper.exec(1));
			System.out.println("results from DB: " + mapper.getOne(1));
		}
	}
}
