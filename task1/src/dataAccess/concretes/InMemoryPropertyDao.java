package dataAccess.concretes;

import java.util.List;
import java.util.stream.Collectors;

import dataAccess.abstracts.PropertyDao;
import entities.abstracts.AbstractPropertyBase;

/*
 * Dao class for properties(all of the entities). Performs operations including
 * all entities.
 */
public class InMemoryPropertyDao implements PropertyDao {

    @Override
    public double getTotalPrice(List<AbstractPropertyBase> list) {
        return list.stream()
                .mapToDouble(villa -> villa.getPrice())
                .sum();
    }

    @Override
    public double averageSquareMeters(List<AbstractPropertyBase> list) {
        double totalSquareMeters = 0;
        for (AbstractPropertyBase prop : list) {
            totalSquareMeters += prop.getSquareMeters();
        }
        return totalSquareMeters / list.size();
    }

    @Override
    public List<AbstractPropertyBase> getAllByRoomCount(List<AbstractPropertyBase> list, int roomCount) {
        return list.stream().filter(v -> v.getRoomCount() == roomCount).collect(Collectors.toList());
    }

    @Override
    public List<AbstractPropertyBase> getAllBySalonCount(List<AbstractPropertyBase> list, int salonCount) {
        return list.stream().filter(v -> v.getSalonCount() == salonCount).collect(Collectors.toList());
    }
}
