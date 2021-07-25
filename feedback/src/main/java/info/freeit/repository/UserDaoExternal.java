package info.freeit.repository;

import info.freeit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("userDaoExternal")
public class UserDaoExternal implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public User add(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", user.getUsername());
        params.addValue("name", user.getName());
        params.addValue("password", user.getPassword());
        namedJdbcTemplate.update("INSERT INTO users (username, password, name) VALUES (:username, :password, :name)",
                params);
        return user;
    }

    public boolean delete(long id) {
        return jdbcTemplate.update("DELETE from users WHERE id = ?", id) > 0;
    }

    public User get(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT u.id as id, u.name as name, u.username as username, u.password as password from users u where id = ?",
                (rs, rn) -> new User(rs.getLong("id"), rs.getString("name"), rs.getString("username"), rs.getString("password")),
                id);
    }

    public User get(String username) {
        return jdbcTemplate.queryForObject(
                "SELECT u.id as id, u.name as name, u.username as username, u.password as password from users u where u.username = ?",
                (rs, rn) -> new User(rs.getLong("id"), rs.getString("name"), rs.getString("username"), rs.getString("password")),
                username);
    }
}
