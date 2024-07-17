package com.github.shorten_it.domain.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LinkResponseDto extends RepresentationModel<LinkResponseDto> {
    private Long id;
    private String url;
    private String title;
    private String description;
    private String shot_url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LinkResponseDto() {
    }

    public LinkResponseDto(Long id, String url, String title, String description, String shot_url, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.description = description;
        this.shot_url = shot_url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShot_url() {
        return shot_url;
    }

    public void setShot_url(String shot_url) {
        this.shot_url = shot_url;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
