package com.todo.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Todo {

    @NotBlank(message = "task cannot be null")
    @Size(min = 2, max = 100, message = "task need to be in right size")
    private String task;

    @NotBlank(message = "email cant be blank")
    @Email(message = "please provide valid email")
    private String email;
}
