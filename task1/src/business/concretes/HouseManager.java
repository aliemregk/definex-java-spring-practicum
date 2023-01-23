package business.concretes;

import java.util.List;

import business.abstracts.HouseService;
import dataAccess.abstracts.HouseDao;
import entities.concretes.House;

public class HouseManager implements HouseService {

    private final HouseDao houseDao;

    public HouseManager(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    @Override
    public List<House> getAll() {
        return houseDao.getAll();
    }

    @Override
    public double getTotalPrice() {
        return houseDao.getTotalPrice();
    }

    @Override
    public double averageSquareMeters() {
        return houseDao.averageSquareMeters();
    }

    @Override
    public List<House> getAllByRoomCount(int roomCount) {
        return houseDao.getAllByRoomCount(roomCount);
    }

    @Override
    public List<House> getAllBySalonCount(int salonCount) {
        return houseDao.getAllBySalonCount(salonCount);
    }

    @Override
    public List<House> getAllDetached(boolean isDetached) {
        return houseDao.getAllDetached(isDetached);
    }

    @Override
    public void add(House entity) {
        houseDao.add(entity);
    }

    @Override
    public void update(House entity) {
        houseDao.update(entity);
    }

    @Override
    public void delete(int id) {
        houseDao.delete(id);
    }

}
