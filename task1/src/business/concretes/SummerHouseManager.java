package business.concretes;

import java.util.List;

import business.abstracts.SummerHouseService;
import dataAccess.abstracts.SummerHouseDao;
import entities.concretes.SummerHouse;

public class SummerHouseManager implements SummerHouseService {

    private final SummerHouseDao summerHouseDao;

    public SummerHouseManager(SummerHouseDao summerHouseDao) {
        this.summerHouseDao = summerHouseDao;
    }

    @Override
    public List<SummerHouse> getAll() {
        return summerHouseDao.getAll();
    }

    @Override
    public double getTotalPrice() {
        return summerHouseDao.getTotalPrice();
    }

    @Override
    public double averageSquareMeters() {
        return summerHouseDao.averageSquareMeters();
    }

    @Override
    public List<SummerHouse> getAllByRoomCount(int roomCount) {
        return summerHouseDao.getAllByRoomCount(roomCount);
    }

    @Override
    public List<SummerHouse> getAllBySalonCount(int salonCount) {
        return summerHouseDao.getAllBySalonCount(salonCount);
    }

    @Override
    public List<SummerHouse> getAllFurnished(boolean isDetached) {
        return summerHouseDao.getAllFurnished(isDetached);
    }

    @Override
    public void add(SummerHouse entity) {
        summerHouseDao.add(entity);
    }

    @Override
    public void update(SummerHouse entity) {
        summerHouseDao.update(entity);
    }

    @Override
    public void delete(int id) {
        summerHouseDao.delete(id);
    }
}
