package business.concretes;

import java.util.List;

import business.abstracts.VillaService;
import dataAccess.abstracts.VillaDao;
import entities.concretes.Villa;

public class VillaManager implements VillaService {

    private final VillaDao villaDao;

    public VillaManager(VillaDao villaDao) {
        this.villaDao = villaDao;
    }

    @Override
    public List<Villa> getAll() {
        return villaDao.getAll();
    }

    @Override
    public double getTotalPrice() {
        return villaDao.getTotalPrice();
    }

    @Override
    public double averageSquareMeters() {
        return villaDao.averageSquareMeters();
    }

    @Override
    public List<Villa> getAllByRoomCount(int roomCount) {
        return villaDao.getAllByRoomCount(roomCount);
    }

    @Override
    public List<Villa> getAllBySalonCount(int salonCount) {
        return villaDao.getAllBySalonCount(salonCount);
    }

    @Override
    public List<Villa> getAllByPool(boolean hasPool) {
        return villaDao.getAllByPool(hasPool);
    }

    @Override
    public void add(Villa entity) {
        villaDao.add(entity);
    }

    @Override
    public void update(Villa entity) {
        villaDao.update(entity);
    }

    @Override
    public void delete(int id) {
        villaDao.delete(id);
    }

}
