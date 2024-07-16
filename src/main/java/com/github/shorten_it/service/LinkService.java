package com.github.shorten_it.service;

import com.github.shorten_it.domain.dto.LinkRequestDto;
import com.github.shorten_it.domain.dto.LinkResponseDto;
import com.github.shorten_it.domain.model.Link;
import com.github.shorten_it.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.github.shorten_it.domain.dto.mapper.EntityMapper.mapObject;

@Service
public class LinkService {
    @Autowired
    LinkRepository linkRepository;
    private String baseUrl = "http://localhost:8080/links/rd/";

    public LinkResponseDto save(LinkRequestDto linkRequestDto) {
        Link link = mapObject(linkRequestDto, Link.class);
        String newUrl  = baseUrl+RandomStringUtils.randomAlphanumeric(5,10);
        link.setShot_url(newUrl);
        link.setCreatedAt(LocalDate.now());
        link.setUpdatedAt(LocalDate.now());
        var response = linkRepository.save(link);
        return mapObject(response, LinkResponseDto.class);
    }

}
