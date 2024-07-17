package com.github.shorten_it.web.controller;

import com.github.shorten_it.domain.dto.LinkRequestDto;
import com.github.shorten_it.domain.dto.LinkResponseDto;
import com.github.shorten_it.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.logging.ErrorManager;

@Tag(name = "Links", description = "Has all features of links")
@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    LinkService service;

    @Operation(summary = "Add new link",description = "Endpoint to create a new Link.",responses = {
            @ApiResponse(responseCode = "201", description = "save successfully", content = @Content(mediaType = "application/jason", schema = @Schema(implementation = LinkResponseDto.class))),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorManager.class)))
    })
    @PostMapping
    public ResponseEntity<LinkResponseDto> create(@Valid @RequestBody LinkRequestDto requestDto) {
        var entity = service.save(requestDto);
        URI locale = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(locale).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<LinkResponseDto>> findAll(){
        List<LinkResponseDto> entity = service.findAll();
        return ResponseEntity.ok(entity);
    }

}
