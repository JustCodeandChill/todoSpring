package com.todo.demo.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServices implements iTodo<String>{
    private List<String> todos;

    public TodoServices() {
        this.todos = new ArrayList<String>();
    }

    @Override
    public List getAllTodos() {
        return todos;
    }

    @Override
    public boolean addTodo(String todo) {
        boolean result = false;

        try {
            todos.add(todo);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
