package com.github.shorten_it.web.controller;

import com.github.shorten_it.domain.dto.LinkRequestDto;
import com.github.shorten_it.domain.dto.LinkResponseDto;
import com.github.shorten_it.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    LinkService service;

    @PostMapping
    public ResponseEntity<LinkResponseDto> create(@Valid @RequestBody LinkRequestDto requestDto) {
        var entity = service.save(requestDto);
        URI locale = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(locale).body(entity);
    }

}
