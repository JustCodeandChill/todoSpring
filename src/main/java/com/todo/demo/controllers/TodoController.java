package com.todo.demo.controllers;

import com.todo.demo.model.Todo;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Data
public class TodoController {
    private List todos;

    @Autowired
    public TodoController(List todos) {
        this.todos = todos;
    }

    public TodoController() {
        this.todos = new ArrayList<String>();
    }

    @RequestMapping("/todo")
    public String todo(@Valid @ModelAttribute("task") Todo todo, Model model, Errors errors) {
        System.out.println("hit the todo asdler " + todo);
//        if (errors.hasErrors()) {
//            System.out.println("There isssd something wrong " + errors.toString());
//            return "home.html";
//        }
        todos.add(todo);
        model.addAttribute("nTodo", todos);
        return "home.html";
    }
}
