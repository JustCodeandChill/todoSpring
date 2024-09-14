package com.todo.demo.controllers;

import com.todo.demo.constants.TodoConstants;
import com.todo.demo.model.Todo;
import com.todo.demo.services.TodoServices;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@NoArgsConstructor
@Slf4j
@Data
public class TodoController {
    private TodoServices todoServices;
    private List<Todo> todos;

    @Autowired
    public TodoController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    @RequestMapping(value="/")
    public String todoPage(Model model) {
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

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    public String todo(@Valid @ModelAttribute("taskName") Todo todo, Model model, Errors errors) {
        System.out.println("hit the todo asdler " + todo);
        todo.setStatus(TodoConstants.incompleteStatus);
        boolean isAdded = this.todoServices.addTodo(todo);
        if (isAdded) {
            todos = this.todoServices.getAllTodos();
            model.addAttribute("nTodo", todos);
        }

        return "redirect:/";
    }

    @RequestMapping(path = "/todo/find", method = RequestMethod.GET)
    public String findTodo(@RequestParam(name="taskId", required = true) String todoId, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("Task Id is " + todoId);

        Todo todoFound = this.todoServices.findTodoById(Integer.parseInt(todoId));
        if (todoFound != null) {
            log.info("found a todo " + todoFound);
            redirectAttributes.addFlashAttribute("todoFound", todoFound);
        } else {
            log.warn("Not found any task with id " + todoId);
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/todo/delete")
    public String deleteTodo(@RequestParam(name="taskId", required = true) String taskId, Model model) {
        System.out.println("hit deleted");
        log.info("Task Id is " + taskId);
        int result = this.todoServices.deleteTodoById(Integer.parseInt(taskId));
        log.info("delete operation " + result);
        return "redirect:/";
    }

    @RequestMapping(value="/todo/update")
    public String updateTodo(@Valid @ModelAttribute Todo newTodo, BindingResult bindingResult) {
        System.out.println("new to do is " + newTodo);
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.getAllErrors().toString());
            return "redirect:/";
        } else {
            this.todoServices.updateTodoById(newTodo.getTaskId(), newTodo);
        }
        return "redirect:/";
    }
}
