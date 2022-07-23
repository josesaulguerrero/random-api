package co.com.randomapi.domain.service;

import java.util.List;
import java.util.Optional;

/**
 * A common interface that serves as a standard for all the services in the application.
 * @param <K> The DTO of the entity you are creating the service for (entities shouldn't leave the data layer, that's what DTOs exist for).
 * @param <I> The entity's Id datatype.
 */
public interface BasicService<K, I> {
    List<K> findAll();
    Optional<K> findOneById(I id);
    K create(K dto);
    K update(K updatedDto);
    K delete(I id);
}
