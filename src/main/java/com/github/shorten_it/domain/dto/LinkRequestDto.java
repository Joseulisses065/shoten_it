package com.github.shorten_it.domain.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class LinkRequestDto {
    @NotBlank(message = "Url can't be empty")
    @URL(message = "Invalid url format")
    private String url;
    @NotBlank(message = "Title can't be empty")
    private String title;
    @NotBlank(message = "Description can't be empty")
    @Size(min = 5 , message = "Description must have a minimum 5 characters ")
    private String description;

    public LinkRequestDto() {
    }

    public LinkRequestDto(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    public @NotBlank(message = "Url can't be empty") @URL(message = "Invalid url format") String getUrl() {
        return url;
    }

    public void setUrl(@NotBlank(message = "Url can't be empty") @URL(message = "Invalid url format") String url) {
        this.url = url;
    }

    public @NotBlank(message = "Title can't be empty") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title can't be empty") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Description can't be empty") @Size(min = 5, message = "Description must have a minimum 5 characters ") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description can't be empty") @Size(min = 5, message = "Description must have a minimum 5 characters ") String description) {
        this.description = description;
    }
}
