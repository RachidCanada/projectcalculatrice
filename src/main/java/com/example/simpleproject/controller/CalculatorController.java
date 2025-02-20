package com.example.simpleproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double number1,
                            @RequestParam double number2,
                            @RequestParam String operation,
                            Model model) {
        double result = 0;
        String message = "";

        switch (operation) {
            case "add":
                result = number1 + number2;
                message = "Addition";
                break;
            case "subtract":
                result = number1 - number2;
                message = "Soustraction";
                break;
            case "multiply":
                result = number1 * number2;
                message = "Multiplication";
                break;
            case "divide":
                if (number2 != 0) {
                    result = number1 / number2;
                    message = "Division";
                } else {
                    message = "Erreur: Division par zéro!";
                }
                break;
            default:
                message = "Opération inconnue!";
                break;
        }

        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "calculator";
    }
}
