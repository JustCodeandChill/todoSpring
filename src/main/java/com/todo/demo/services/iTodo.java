package com.todo.demo.services;

import com.todo.demo.model.Todo;

import java.util.List;

public interface iTodo<T> {
    public List<T> getAllTodos();

    public boolean addTodo(T todo);

    public T findTodoById(int id);

    public int deleteTodoById(int id);

    public int updateTodoById(int id, T todo);
}
