package uni.repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * CRUD operations repository interface
 */
public interface ICrudRepository<E> {
    /**
     * @param id -the id of the entity to be returned (cannot be null)
     * @return the entity with the specified id or null - if there is no entity with the given id
     */
    /*E findOne(Long id);*/

    /**
     * @return all entities
     */
    List<E> getAll();

    /**
     * @param entity entity must be not null
     * @return null - if the given entity was created successfully, otherwise returns the entity (if the id already exists)
     */
    E create(E entity);

    /**
     * removes the entity with the specified id
     * @param entity entity must not be null
     * @return the removed entity or null if there is no such entity
     *
     */
    E delete(E entity);

    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity (if the id does not exist)
     *
     */
    E update(E entity);

}
