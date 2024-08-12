package com.todo.demo.services;

import java.util.List;

public interface iTodo<T> {
    public List<T> getAllTodos();

    public boolean addTodo(T todo);
}
