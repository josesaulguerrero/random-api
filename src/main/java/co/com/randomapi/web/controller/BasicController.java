package co.com.randomapi.web.controller;

import java.util.List;

/**
 * A common interface that serves as a standard for all the services in the application.
 * @param <T> The DTO of the entity you are creating the controller for.
 * @param <I> The entity's Id datatype.
 */
public interface BasicController<T, I> {
    List<T> getAll();
    T getById(I id);
    T post(T dto);
    T update(T changes);
    T delete(I id);
}
