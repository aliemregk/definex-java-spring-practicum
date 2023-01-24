package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dataAccess.abstracts.SummerHouseDao;
import entities.concretes.SummerHouse;

public class InMemorySummerHouseDao implements SummerHouseDao {

    private List<SummerHouse> summerHouseList;

    public InMemorySummerHouseDao() {
        summerHouseList = new ArrayList<>();
        summerHouseList.add(new SummerHouse(9, 1000000D, 250D, 4, 1, false));
        summerHouseList.add(new SummerHouse(10, 1100000D, 230D, 4, 1, true));
        summerHouseList.add(new SummerHouse(11, 1400000D, 300D, 5, 2, true));
        summerHouseList.add(new SummerHouse(12, 200000D, 400D, 6, 2, true));
    }

    @Override
    public List<SummerHouse> getAll() {
        return new ArrayList<>(summerHouseList);
    }

    @Override
    public double getTotalPrice() {
        return summerHouseList.stream()
                .mapToDouble(h -> h.getPrice())
                .sum();
    }

    @Override
    public double averageSquareMeters() {
        double totalSquareMeters = 0;
        for (SummerHouse summerHouse : summerHouseList) {
            totalSquareMeters += summerHouse.getSquareMeters();
        }
        return totalSquareMeters / summerHouseList.size();
    }

    @Override
    public List<SummerHouse> getAllByRoomCount(int roomCount) {
        return summerHouseList.stream().filter(h -> h.getRoomCount() == roomCount).collect(Collectors.toList());
    }

    @Override
    public List<SummerHouse> getAllBySalonCount(int salonCount) {
        return summerHouseList.stream().filter(h -> h.getSalonCount() == salonCount).collect(Collectors.toList());
    }

    @Override
    public void add(SummerHouse entity) {
        summerHouseList.add(entity);
    }

    @Override
    public void update(SummerHouse entity) {
        SummerHouse houseToUpdate = summerHouseList.stream().filter(v -> v.getId() == entity.getId())
                .collect(Collectors.toList())
                .get(0);
        houseToUpdate.setPrice(entity.getPrice());
        houseToUpdate.setSquareMeters(entity.getSquareMeters());
        houseToUpdate.setRoomCount(entity.getRoomCount());
        houseToUpdate.setSalonCount(entity.getSalonCount());
        houseToUpdate.setFurnished(entity.isFurnished());
    }

    @Override
    public void delete(int id) {
        summerHouseList.removeIf(v -> v.getId() == id);
    }

    @Override
    public List<SummerHouse> getAllFurnished(boolean isFurnished) {
        return summerHouseList.stream().filter(h -> h.isFurnished()).collect(Collectors.toList());
    }
}
