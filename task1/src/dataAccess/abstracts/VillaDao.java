package dataAccess.abstracts;

import java.util.List;

import entities.concretes.Villa;

public interface VillaDao extends EntityDaoBase<Villa> {

    List<Villa> getAllByPool(boolean hasPool);
}
