package dataAccess.abstracts;

import java.util.List;

import entities.abstracts.AbstractPropertyBase;

public interface PropertyDao {

    double getTotalPrice(List<AbstractPropertyBase> list);

    double averageSquareMeters(List<AbstractPropertyBase> list);

    List<AbstractPropertyBase> getAllByRoomCount(List<AbstractPropertyBase> list, int roomCount);

    List<AbstractPropertyBase> getAllBySalonCount(List<AbstractPropertyBase> list, int salonCount);
}
