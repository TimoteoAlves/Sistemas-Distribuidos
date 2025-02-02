package com.timoteo.Calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicCalculatorController {

    @GetMapping("/basic")
    public String basicCalculator() {
        return "basic-calculator";
    }

    @GetMapping("/add")
    @ResponseBody
    public double add(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/subtract")
    @ResponseBody
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiply")
    @ResponseBody
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/divide")
    @ResponseBody
    public double divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor não pode ser zero");
        }
        return a / b;
    }
}
