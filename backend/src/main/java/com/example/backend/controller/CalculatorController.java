package com.example.backend.controller;

import com.example.backend.DTO.CalculationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

    @PostMapping("/calculator")
    public ResponseEntity<?> calculate(@RequestBody CalculationRequest request) {
        if (request == null || request.getOperation() == null) {
            return ResponseEntity.badRequest().body("Missing required parameters");
        }

        try {
            double result = switch (request.getOperation()) {
                case "add" -> request.getValue1() + request.getValue2();
                case "subtract" -> request.getValue1() - request.getValue2();
                case "multiply" -> request.getValue1() * request.getValue2();
                case "divide" -> {
                    if (request.getValue2() == 0) throw new ArithmeticException("Division by zero is not allowed.");
                    yield (double) request.getValue1() / request.getValue2();
                }
                default -> throw new IllegalArgumentException("Invalid operation");
            };
            System.out.println("Result sent back to client: " + result);  // Logging the result
            return ResponseEntity.ok(result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred during the calculation");
        }
    }
}