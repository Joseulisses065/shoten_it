package com.github.shorten_it.exceptions;

public class UniqueDataException extends RuntimeException{
    public UniqueDataException(String message) {
        super(message);
    }
}
