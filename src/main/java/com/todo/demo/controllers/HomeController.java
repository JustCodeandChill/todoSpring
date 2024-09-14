package com.todo.demo.controllers;

import com.todo.demo.model.Todo;
import com.todo.demo.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HomeController {
    private TodoServices todoServices;

    @Autowired
    public HomeController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("hit home controller");
        ModelAndView modelAndView = new ModelAndView("home.html");
        Iterable<Todo> temp = this.todoServices.getAllTodos();
        List<Todo> todos = StreamSupport.stream(temp.spliterator(), false).collect(Collectors.toList());
        if (todos == null) {
            System.out.println("It is empty here");
        } else {
            for (Todo t : todos) {
                System.out.println("todo " + t);
            }
        }

//        List<Holiday> holidays = StreamSupport.stream(holidaysRetrieved.spliterator(), false).collect(Collectors.toList());

        model.addAttribute("preMadeTodos", todos);
        return "home.html";
    }
}
