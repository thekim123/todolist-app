package com.thekim12.todoapp.controller;

import com.thekim12.todoapp.domain.Todo;
import com.thekim12.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Todo> allTodo = todoRepository.findAll();
        model.addAttribute("todos", allTodo);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        Todo todoList = new Todo();
        todoList.setTodo(todo);
        System.out.println(todo);
        todoRepository.save(todoList);
        return "redirect:/";
    }
}
