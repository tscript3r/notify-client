package pl.tscript3r.notify.client.backend.services;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tscript3r.notify.client.backend.data.entities.AbstractEntity;

import javax.persistence.EntityNotFoundException;

public interface CrudService<T extends AbstractEntity> {

    JpaRepository<T, Long> getRepository();

    default T save(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    default void delete(T entity) {
        if (entity == null)
            throw new EntityNotFoundException();
        getRepository().delete(entity);
    }

    default void delete(long id) {
        delete(loadById(id));
    }

    default long count() {
        return getRepository().count();
    }

    default T loadById(long id) {
        return getRepository()
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    T create();

}
