package co.com.randomapi.domain.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * A common interface that serves as a standard for all the services in the application.
 * @param <T> The DTO of the entity you are creating the service for (entities shouldn't leave the data layer, that's what DTOs exist for).
 * @param <I> The entity's Id datatype.
 */
@Transactional
public interface BasicService<T, I> {
    List<T> findAll();
    Optional<T> findById(I id) throws Throwable;
    T create(T dto);
    T update(T updatedDto);
    T delete(I id);
}
