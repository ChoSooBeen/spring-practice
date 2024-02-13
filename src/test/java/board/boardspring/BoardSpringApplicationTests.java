package board.boardspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BoardSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void testJdbcConnection() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS test_table (id INT, name VARCHAR(255))");
		jdbcTemplate.update("INSERT INTO test_table VALUES (1, 'Kim')");

		String result = jdbcTemplate.queryForObject("SELECT name FROM test_table WHERE id = 1", String.class);

		assertTrue("Kim".equals(result));
	}

}
