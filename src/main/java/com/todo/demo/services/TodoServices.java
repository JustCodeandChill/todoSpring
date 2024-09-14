package com.todo.demo.services;

import com.todo.demo.constants.TodoConstants;
import com.todo.demo.model.Todo;
import com.todo.demo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TodoServices implements iTodo<Todo>{
    private TodoRepository todoRepository;

    @Autowired
    public TodoServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    @Override
    public List<Todo> getAllTodos() {
        return this.todoRepository.getAllTodos();
    }

    @Override
    public boolean addTodo(Todo todo) {
        boolean result = false;

        try {
            int returnValue = this.todoRepository.insertTodo(todo);
            result = returnValue > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to add todo");
        }

        return result;
    }

    @Override
    public Todo findTodoById(int id) {
        Todo todo = null;
        try {
            todo = this.todoRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("not found todo");
        }
        return todo;
    }

    @Override
    public int deleteTodoById(int id) {
        return this.todoRepository.deleteById(id);
    }

    @Override
    public int updateTodoById(int id, Todo todo) {
        if (todo.getStatus() != TodoConstants.incompleteStatus && todo.getStatus() != TodoConstants.completeStatus) {
            todo.setStatus(TodoConstants.incompleteStatus);
        }

        int result = 0;
        try {
            result = this.todoRepository.updateById(id, todo);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("result ifno" + result);
        }

        return result;
    }
}
