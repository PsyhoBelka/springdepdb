package ua.rozhkov.springdepdb.DAO;

import java.util.Set;

public interface AbstractDAO<T> {
    long create(T newObject);

    T readById(long idToRead);

    Set<T> readAll();

    long update(long idObjectToBeUpdated, T objectToBeUpdated);

    long delete(long idToDelete);
}
