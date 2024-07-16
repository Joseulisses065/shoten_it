package com.github.shorten_it.repository;

import com.github.shorten_it.domain.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Long> {
}
