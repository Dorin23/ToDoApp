package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final ToDoService toDoService;

    public TaskController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = toDoService.getAllTasks();
        System.out.println("Tasks: " + tasks);
        model.addAttribute("tasks", tasks);
        return "index";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
        toDoService.createTask(title);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        toDoService.deleteTask(id);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        toDoService.toggleTask(id);
        return "redirect:/tasks";
    }
}
