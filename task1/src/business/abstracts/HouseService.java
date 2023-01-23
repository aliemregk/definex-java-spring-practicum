package business.abstracts;

import java.util.List;

import entities.concretes.House;

public interface HouseService {

    List<House> getAll();

    double getTotalPrice();

    double averageSquareMeters();

    List<House> getAllByRoomCount(int roomCount);

    List<House> getAllBySalonCount(int salonCount);

    List<House> getAllDetached(boolean isDetached);

    void add(House entity);

    void update(House entity);

    void delete(int id);

}
