package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.PropertyService;
import dataAccess.abstracts.HouseDao;
import dataAccess.abstracts.PropertyDao;
import dataAccess.abstracts.SummerHouseDao;
import dataAccess.abstracts.VillaDao;
import entities.abstracts.AbstractPropertyBase;

public class PropertyManager implements PropertyService {

    private final PropertyDao propertyDao;
    private final VillaDao villaDao;
    private final HouseDao houseDao;
    private final SummerHouseDao summerHouseDao;
    private List<AbstractPropertyBase> list;

    public PropertyManager(PropertyDao propertyDao, VillaDao villaDao, HouseDao houseDao,
            SummerHouseDao summerHouseDao) {
        this.propertyDao = propertyDao;
        this.villaDao = villaDao;
        this.houseDao = houseDao;
        this.summerHouseDao = summerHouseDao;

        createList();
    }

    /**
     * Create list to store all types of property.
     */
    private void createList() {
        list = new ArrayList<>();
        list.addAll(villaDao.getAll());
        list.addAll(houseDao.getAll());
        list.addAll(summerHouseDao.getAll());
    }

    @Override
    public double getTotalPrice() {
        return propertyDao.getTotalPrice(list);
    }

    @Override
    public double averageSquareMeters() {
        return propertyDao.averageSquareMeters(list);
    }

    @Override
    public List<AbstractPropertyBase> getAllByRoomCount(int roomCount) {
        return propertyDao.getAllByRoomCount(list, roomCount);
    }

    @Override
    public List<AbstractPropertyBase> getAllBySalonCount(int salonCount) {
        return propertyDao.getAllBySalonCount(list, salonCount);
    }

}
