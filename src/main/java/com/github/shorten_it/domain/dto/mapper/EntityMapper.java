package com.github.shorten_it.domain.dto.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class EntityMapper {
    public static ModelMapper mapper = new ModelMapper();
    public static<S,D> D mapObject( S s, Class<D> d) {
        return  mapper.map(s,d);
    }

    public static<S,D> List<D> mapListObject( List<S> s, Class<D> d) {
        List<D> response = new ArrayList<>();
        for (S sq: s){
            response.add(mapper.map(sq,d));
        }
        return response;
    }
}
