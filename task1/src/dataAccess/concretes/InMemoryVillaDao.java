package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dataAccess.abstracts.VillaDao;
import entities.concretes.Villa;

/*
 * Dao class for villa entity. Creates villa entities and performs CRUD
 * operations.
 */
public class InMemoryVillaDao implements VillaDao {

    private List<Villa> villaList;

    public InMemoryVillaDao() {
        villaList = new ArrayList<>();
        villaList.add(new Villa(1, 1000000D, 250D, 5, 2, false));
        villaList.add(new Villa(2, 1200000D, 300D, 5, 2, false));
        villaList.add(new Villa(3, 1500000D, 350D, 6, 3, true));
        villaList.add(new Villa(4, 1100000D, 200D, 5, 1, true));
    }

    @Override
    public List<Villa> getAll() {
        return new ArrayList<>(villaList);
    }

    @Override
    public double getTotalPrice() {
        return villaList.stream()
                .mapToDouble(villa -> villa.getPrice())
                .sum();
    }

    @Override
    public double averageSquareMeters() {
        double totalSquareMeters = 0;
        for (Villa villa : villaList) {
            totalSquareMeters += villa.getSquareMeters();
        }
        return totalSquareMeters / villaList.size();
    }

    @Override
    public List<Villa> getAllByRoomCount(int roomCount) {
        return villaList.stream().filter(v -> v.getRoomCount() == roomCount).collect(Collectors.toList());
    }

    @Override
    public List<Villa> getAllBySalonCount(int salonCount) {
        return villaList.stream().filter(v -> v.getSalonCount() == salonCount).collect(Collectors.toList());
    }

    @Override
    public void add(Villa entity) {
        villaList.add(entity);
    }

    @Override
    public void update(Villa entity) {
        Villa villaToUpdate = villaList.stream().filter(v -> v.getId() == entity.getId()).collect(Collectors.toList())
                .get(0);
        villaToUpdate.setPrice(entity.getPrice());
        villaToUpdate.setSquareMeters(entity.getSquareMeters());
        villaToUpdate.setRoomCount(entity.getRoomCount());
        villaToUpdate.setSalonCount(entity.getSalonCount());
        villaToUpdate.setHasPool(entity.hasPool());
    }

    @Override
    public void delete(int id) {
        villaList.removeIf(v -> v.getId() == id);
    }

    @Override
    public List<Villa> getAllByPool(boolean hasPool) {
        return villaList.stream().filter(v -> v.hasPool() == hasPool).collect(Collectors.toList());
    }

}