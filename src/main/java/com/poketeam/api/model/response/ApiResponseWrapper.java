package com.poketeam.api.model.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int status;
    private String message;
    private T data;
    private String timestamp;

    // Constructor for success response
    public ApiResponseWrapper(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = Instant.now().toString();
    }

    // Constructor for error response
    public ApiResponseWrapper(int status, String message) {
        this(status, message, null);
    }

    // Static method for success response
    public static <T> ApiResponseWrapper<T> success(T data, String message) {
        return new ApiResponseWrapper<>(200, message, data);
    }

    // Static method for error response
    public static <T> ApiResponseWrapper<T> error(String message, HttpStatus status) {
        return new ApiResponseWrapper<>(status.value(), message, null); // Convert HttpStatus to int
    }

    // Static method for error response with default 500 status
    public static <T> ApiResponseWrapper<T> error(String message) {
        return new ApiResponseWrapper<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    }
}
