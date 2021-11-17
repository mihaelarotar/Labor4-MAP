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

    public void add(E entity) {
        repository.save(entity);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public void update(E entity) {
        repository.update(entity);
    }

    public List<E> getAll() {
        return repository.getAll();
    }

    public List<E> filter(Predicate<E> function) {
        return repository.getAll()
                .stream()
                .filter(function)
                .collect(Collectors.toList());
    }

    public void sort(Comparator<E> comparator) {
        repository.getAll().sort(comparator);
    }
}
