package dataAccess.abstracts;

import java.util.List;

import entities.concretes.House;

public interface HouseDao extends EntityDaoBase<House> {

    List<House> getAllDetached(boolean isDetached);
}
