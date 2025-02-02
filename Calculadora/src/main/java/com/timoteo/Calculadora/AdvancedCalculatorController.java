package com.timoteo.Calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvancedCalculatorController {

    @GetMapping("/advanced")
    public String advancedCalculator() {
        return "advanced-calculator";
    }

    @GetMapping("/sqrt")
    @ResponseBody
    public double sqrt(@RequestParam double a) {
        return Math.sqrt(a);
    }

    @GetMapping("/power")
    @ResponseBody
    public double power(@RequestParam double a, @RequestParam double b) {
        return Math.pow(a, b);
    }

    @GetMapping("/inverse")
    @ResponseBody
    public double inverse(@RequestParam double a) {
        if (a == 0) {
            throw new IllegalArgumentException("Valor não pode ser zero");
        }
        return 1 / a;
    }

    @GetMapping("/modulus")
    @ResponseBody
    public double modulus(@RequestParam double a, @RequestParam double b) {
        return a % b;
    }

    @GetMapping("/factorial")
    @ResponseBody
    public long factorial(@RequestParam int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        return factorialRec(a);
    }

    private long factorialRec(int n) {
        if (n == 0) return 1;
        else return n * factorialRec(n - 1);
    }

    @GetMapping("/average")
    @ResponseBody
    public double average(@RequestParam double a, @RequestParam double b, @RequestParam double c, @RequestParam double d, @RequestParam double e) {
        return (a + b + c + d + e) / 5;
    }

    @GetMapping("/median")
    @ResponseBody
    public double median(@RequestParam double a, @RequestParam double b, @RequestParam double c, @RequestParam double d, @RequestParam double e) {
        double[] values = {a, b, c, d, e};
        java.util.Arrays.sort(values);
        return values[2];
    }
}
