package com.github.shorten_it.service;

import com.github.shorten_it.domain.dto.LinkRequestDto;
import com.github.shorten_it.domain.dto.LinkResponseDto;
import com.github.shorten_it.domain.model.Link;
import com.github.shorten_it.repository.LinkRepository;
import com.github.shorten_it.web.controller.LinkController;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.shorten_it.domain.dto.mapper.EntityMapper.mapListObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDate;
import java.util.List;

import static com.github.shorten_it.domain.dto.mapper.EntityMapper.mapObject;

@Service
public class LinkService {
    @Autowired
    LinkRepository linkRepository;
    private String baseUrl = "http://localhost:8080/links/rd/";

    public LinkResponseDto save(LinkRequestDto linkRequestDto) {
        Link link = mapObject(linkRequestDto, Link.class);
        String newUrl = baseUrl + RandomStringUtils.randomAlphanumeric(5, 10);
        link.setShot_url(newUrl);

        var response = mapObject(linkRepository.save(link), LinkResponseDto.class);
        response.add(linkTo(methodOn(LinkController.class).create(linkRequestDto)).withSelfRel());
        return response;
    }

    public List<LinkResponseDto> findAll() {
        List<Link> links = linkRepository.findAll();
        var response =  mapListObject(links, LinkResponseDto.class);
        response.stream().forEach(responseIt->responseIt.add(linkTo(methodOn(LinkController.class).findAll()).withSelfRel()));;
        return response;
    }
}
