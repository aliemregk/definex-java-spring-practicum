package dataAccess.abstracts;

import java.util.List;

import entities.concretes.SummerHouse;

public interface SummerHouseDao extends EntityDaoBase<SummerHouse> {

    List<SummerHouse> getAllFurnished(boolean isFurnished);
}
