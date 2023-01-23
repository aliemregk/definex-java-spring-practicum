package business.abstracts;

import java.util.List;

import entities.concretes.SummerHouse;

public interface SummerHouseService {

    List<SummerHouse> getAll();

    double getTotalPrice();

    double averageSquareMeters();

    List<SummerHouse> getAllByRoomCount(int roomCount);

    List<SummerHouse> getAllBySalonCount(int salonCount);

    List<SummerHouse> getAllFurnished(boolean isFurnished);

    void add(SummerHouse entity);

    void update(SummerHouse entity);

    void delete(int id);
}
