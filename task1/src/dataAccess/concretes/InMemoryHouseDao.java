package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dataAccess.abstracts.HouseDao;
import entities.concretes.House;

public class InMemoryHouseDao implements HouseDao {

    private List<House> houseList;

    public InMemoryHouseDao() {
        houseList = new ArrayList<>();
        houseList.add(new House(5, 800000D, 150D, 3, 1, false));
        houseList.add(new House(6, 900000D, 180D, 4, 1, false));
        houseList.add(new House(7, 1000000D, 300D, 5, 2, true));
        houseList.add(new House(8, 850000D, 160D, 4, 1, true));
    }

    @Override
    public List<House> getAll() {
        return new ArrayList<>(houseList);
    }

    @Override
    public double getTotalPrice() {
        return houseList.stream()
                .mapToDouble(h -> h.getPrice())
                .sum();
    }

    @Override
    public double averageSquareMeters() {
        double totalSquareMeters = 0;
        for (House House : houseList) {
            totalSquareMeters += House.getSquareMeters();
        }
        return totalSquareMeters / houseList.size();
    }

    @Override
    public List<House> getAllByRoomCount(int roomCount) {
        return houseList.stream().filter(h -> h.getRoomCount() == roomCount).collect(Collectors.toList());
    }

    @Override
    public List<House> getAllBySalonCount(int salonCount) {
        return houseList.stream().filter(h -> h.getSalonCount() == salonCount).collect(Collectors.toList());
    }

    @Override
    public void add(House entity) {
        houseList.add(entity);
    }

    @Override
    public void update(House entity) {
        House houseToUpdate = houseList.stream().filter(v -> v.getId() == entity.getId()).collect(Collectors.toList())
                .get(0);
        houseToUpdate.setPrice(entity.getPrice());
        houseToUpdate.setSquareMeters(entity.getSquareMeters());
        houseToUpdate.setRoomCount(entity.getRoomCount());
        houseToUpdate.setSalonCount(entity.getSalonCount());
        houseToUpdate.setDetached(entity.isDetached());
    }

    @Override
    public void delete(int id) {
        houseList.removeIf(v -> v.getId() == id);
    }

    @Override
    public List<House> getAllDetached(boolean hasPool) {
        return houseList.stream().filter(h -> h.isDetached()).collect(Collectors.toList());
    }
}
