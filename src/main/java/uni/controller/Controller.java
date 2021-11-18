package uni.controller;

import uni.repository.ICrudRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Controller<E> {
    protected final ICrudRepository<E> repository;

    public Controller(ICrudRepository<E> repository) {
        this.repository = repository;
    }

    /**
     * adds given entity
     * @param entity entity must be not null
     */
    public void add(E entity) {
        repository.save(entity);
    }

    /**
     * removes the entity with the specified id
     * @param entity entity must not be null
     */
    public void delete(E entity) {
        repository.delete(entity);
    }

    /**
     * updates given entity
     * @param entity entity must not be null
     */
    public void update(E entity) {
        repository.update(entity);
    }

    /**
     * @return all entities
     */
    public List<E> getAll() {
        return repository.getAll();
    }

    /**
     * general filter function for entities with certain property
     * @param function to apply to each entity to determine if it should be included
     * @return a new list containing only the entities with the given property
     */
    public List<E> filter(Predicate<E> function) {
        return repository.getAll()
                .stream()
                .filter(function)
                .collect(Collectors.toList());
    }

    /**
     * general sort function
     * @param comparator used to compare list elements
     */
    public void sort(Comparator<E> comparator) {
        repository.getAll().sort(comparator);
    }
}
