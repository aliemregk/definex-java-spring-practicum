package dataAccess.abstracts;

import java.util.List;

/*
 * Generic base interface for entity operations.
 */
public interface EntityDaoBase<T> {

    List<T> getAll();

    double getTotalPrice();

    double averageSquareMeters();

    List<T> getAllByRoomCount(int roomCount);

    List<T> getAllBySalonCount(int salonCount);

    void add(T entity);

    void update(T entity);

    void delete(int id);
}