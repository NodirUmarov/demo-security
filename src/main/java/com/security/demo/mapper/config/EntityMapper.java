package com.security.demo.mapper.config;

import java.util.List;

/**
 * The interface that defines basic methods for mapping dto to entity. Object types are generic and
 * must be specified in parameters of class
 *
 * @param <T> entity to map to
 * @param <S> dto to map from
 */
public interface EntityMapper<T, S> {

    T toEntity(S dto);
    List<T> toEntityList(List<S> dtoList);

}