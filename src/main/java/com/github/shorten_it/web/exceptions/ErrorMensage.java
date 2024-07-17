package com.github.shorten_it.web.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class ErrorMensage {
    private String path;
    private String method;
    private String statusText;
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,String> errors;

    public ErrorMensage(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getContextPath();
        this.method = request.getMethod();
        this.statusText = status.getReasonPhrase();
        this.code = status.value();
        this.message = message;
    }

    public ErrorMensage(HttpServletRequest request, HttpStatus status, String message, BindingResult result) {
        this.path = request.getContextPath();
        this.method = request.getMethod();
        this.statusText = status.getReasonPhrase();
        this.code = status.value();
        this.message = message;
        addError(result);
    }

    private void addError(BindingResult result) {
        this.errors = new HashMap<>();
        for (FieldError error :result.getFieldErrors()){
            errors.put(error.getField(),error.getDefaultMessage());
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
