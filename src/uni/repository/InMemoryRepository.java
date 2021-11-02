package uni.repository;


import java.util.List;

public abstract class InMemoryRepository<E> implements ICrudRepository<E>{
    protected List<E> repoList;


    public InMemoryRepository(List<E> repoList) {
        this.repoList = repoList;
    }

    @Override
    public List<E> getAll() {
        return this.repoList;
    }

    @Override
    public E save(E entity) {
        if(this.repoList.contains(entity))
            return null;
        this.repoList.add(entity);
        return entity;
    }

    @Override
    public E delete(E entity) {
        if(!this.repoList.contains(entity))
            return null;
        this.repoList.remove(entity);
        return entity;
    }
}
