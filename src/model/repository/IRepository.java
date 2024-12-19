package model.repository;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface IRepository<T, D> {

    void save(T entity);
    Optional<T> find(D id);
    List<T> findAll();
    void delete(D id);

}
