package repositories;

import models.BaseEntity;

import java.util.List;
import java.util.Optional;

interface BaseRepository<T extends BaseEntity, ID> {

    T save(T entity);
    Optional<T> findById(ID Id);
    List<T> findAll();
    void deleteById(ID id);
}