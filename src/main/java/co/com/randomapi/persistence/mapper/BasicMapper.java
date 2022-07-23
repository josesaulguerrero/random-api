package co.com.randomapi.persistence.mapper;

public interface BasicMapper<T, K> {
    T DTOToEntity(K dto);
    K entityToDTO(T entity);
}
