package com.security.demo.mapper.config;

import java.util.List;

/**
 * The interface that defines basic methods for mapping entity to dto. Object types are generic and
 * must be specified in parameters of class
 *
 * @param <T> dto to map
 * @param <S> entity to map from
 */
public interface DtoMapper<T, S> {

    /**
     * This method maps passed as argument entity object to a dto.
     *
     * @param entity must not be null
     * @return mapped dto
     */
    T toDto(S entity);

    /**
     * This method maps passed as argument {@link List} of entities to {@link List} of dtos.
     *
     * @param entityList must not be null
     * @return mapped {@link List} of dtos
     */
    List<T> toDtoList(List<S> entityList);

}