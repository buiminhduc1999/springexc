package com.example.demo.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse {
    private boolean success;
    private String message;
}
