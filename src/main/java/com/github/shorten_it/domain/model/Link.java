package com.github.shorten_it.domain.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "links")
@EntityListeners(AuditingEntityListener.class)
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, unique = true)
    private String shot_url;
    @CreatedDate
    @Column(nullable = false,name = "created_at")
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false,name = "updated_at")
    private LocalDateTime updatedAt;

    public Link() {
    }

    public Link(Long id, String url, String title, String description, String shot_url) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.description = description;
        this.shot_url = shot_url;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id) && Objects.equals(url, link.url) && Objects.equals(title, link.title) && Objects.equals(description, link.description) && Objects.equals(shot_url, link.shot_url) && Objects.equals(createdAt, link.createdAt) && Objects.equals(updatedAt, link.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, title, description, shot_url, createdAt, updatedAt);
    }
}
