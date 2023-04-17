package net.quazar.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/completed")
    public String completed() {
        return "completed";
    }
}
