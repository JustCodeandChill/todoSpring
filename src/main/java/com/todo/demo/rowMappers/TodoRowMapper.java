package com.todo.demo.rowMappers;

import com.todo.demo.model.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setTaskId(rs.getInt("todo_id"));
        todo.setTaskName(rs.getString("todo_name"));
        todo.setStatus(rs.getString("todo_status"));
        return todo;
    }
}
