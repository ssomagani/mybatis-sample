import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import mapper.ResultMapper;

public class Application {

	public static void main(String[] args) {
		InputStream resource = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
				resource, "default", new Properties());

		try (SqlSession session = factory.openSession(ExecutorType.SIMPLE, TransactionIsolationLevel.NONE)) {
			ResultMapper mapper = session.getMapper(ResultMapper.class);
			System.out.println("results from DB: " + mapper.select(1));
		}
	}
}
