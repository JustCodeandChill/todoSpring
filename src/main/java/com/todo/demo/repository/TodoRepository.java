package com.todo.demo.repository;

import com.todo.demo.model.Todo;
import com.todo.demo.rowMappers.TodoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TodoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> getAllTodos() {
        String sql = "SELECT * FROM todo";

        return jdbcTemplate.query(
                sql, new TodoRowMapper()
        );
    }

    public int insertTodo(Todo todo) {
        String sql = "INSERT INTO todo (TODO_NAME, TODO_STATUS) VALUES (?, ?)";

        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, todo.getTaskName());
                ps.setString(2, todo.getStatus());
            }
        });

    }

    public Todo findById(int id) {
        String sql = "SELECT * FROM todo WHERE TODO_ID = ?";

        return jdbcTemplate.queryForObject(sql, new TodoRowMapper(), id);
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM todo WHERE TODO_ID = ?";

        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        });
    }

    public int updateById(int id, Todo todo) {
        String sql = "UPDATE todo SET TODO_NAME = ?, TODO_STATUS = ? WHERE TODO_ID = ?";

        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, todo.getTaskName());
                ps.setString(2, todo.getStatus());
                ps.setInt(3, id);
            }
        });
    }
}
