package uni.repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public abstract class InMemoryRepository<E> implements ICrudRepository<E>{
    protected List<E> repoList;

    public InMemoryRepository() {
    }

    public InMemoryRepository(List<E> repoList) {
        this.repoList = repoList;
    }

    @Override
    public List<E> getAll() {
        return this.repoList;
    }

    @Override
    public E create(E entity) {
        if(this.repoList.contains(entity))
            return entity;
        this.repoList.add(entity);
        return null;
    }

    @Override
    public E delete(E entity) {
        if(this.repoList.contains(entity))
            return null;
        this.repoList.remove(entity);
        return entity;
    }
}
