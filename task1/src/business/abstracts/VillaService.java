package business.abstracts;

import java.util.List;

import entities.concretes.Villa;

public interface VillaService {

    List<Villa> getAll();

    double getTotalPrice();

    double averageSquareMeters();

    List<Villa> getAllByRoomCount(int roomCount);

    List<Villa> getAllBySalonCount(int salonCount);

    List<Villa> getAllByPool(boolean hasPool);

    void add(Villa entity);

    void update(Villa entity);

    void delete(int id);

}
