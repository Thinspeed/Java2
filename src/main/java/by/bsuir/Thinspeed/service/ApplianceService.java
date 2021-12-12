package by.bsuir.Thinspeed.service;

import java.util.List;

import by.bsuir.Thinspeed.entity.Appliance;
import by.bsuir.Thinspeed.entity.criteria.Criteria;

/** Appliance service API */
public interface ApplianceService {
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
