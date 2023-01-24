package business.abstracts;

import java.util.List;

import entities.abstracts.AbstractPropertyBase;

public interface PropertyService {

    double getTotalPrice();

    double averageSquareMeters();

    List<AbstractPropertyBase> getAllByRoomCount(int roomCount);

    List<AbstractPropertyBase> getAllBySalonCount(int salonCount);

}
