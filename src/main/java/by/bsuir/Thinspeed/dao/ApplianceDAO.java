package by.bsuir.Thinspeed.dao;

import by.bsuir.Thinspeed.entity.Appliance;
import by.bsuir.Thinspeed.entity.criteria.Criteria;

import java.util.List;

/** DAO API */
public interface ApplianceDAO {
	/**
	 * Searches for the specified criteria
	 * 
	 * @param criteria search criterias
	 * @return List of appliance
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * Sorts the list of appliance by price
	 * 
	 * @return List of appliance
	 */
	List<Appliance> sortByPrice();
}
