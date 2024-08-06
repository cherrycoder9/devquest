package devquest.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class BaseDao {
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected boolean queryForBoolean(final String sql, final Object... args) {
        final Integer count = jdbcTemplate.queryForObject(sql, Integer.class, args);
        return count != null && count > 0;
    }
}
