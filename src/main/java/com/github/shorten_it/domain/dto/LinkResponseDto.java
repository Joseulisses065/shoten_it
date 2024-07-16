package com.github.shorten_it.domain.dto;

import java.time.LocalDate;

public class LinkResponseDto {
    private Long id;
    private String url;
    private String title;
    private String description;
    private String shot_url;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public LinkResponseDto() {
    }

    public LinkResponseDto(Long id, String url, String title, String description, String shot_url, LocalDate createdAt, LocalDate updatedAt) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
