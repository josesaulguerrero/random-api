package co.com.randomapi.persistence.mapper;

import java.util.List;

public interface BasicMapper<T, K> {
    T DTOToEntity(K dto);
    K entityToDTO(T entity);
    List<K> entitiesToDTOs(List<T> entities);
}
