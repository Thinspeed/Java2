package by.bsuir.Thinspeed.service.impl;

import java.util.List;

import by.bsuir.Thinspeed.dao.ApplianceDAO;
import by.bsuir.Thinspeed.dao.DAOFactory;
import by.bsuir.Thinspeed.entity.Appliance;
import by.bsuir.Thinspeed.entity.criteria.Criteria;
import by.bsuir.Thinspeed.service.ApplianceService;
import by.bsuir.Thinspeed.service.validation.Validator;

/** Implementation of appliance service interface */
public class ApplianceServiceImpl implements ApplianceService {

	/**
	 * Validate criterias and call DAO find method
	 * 
	 * @param criteria search criterias
	 * @return List of appliance
	 */
	public List<Appliance> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		List<Appliance> appliance = applianceDAO.find(criteria);

		return appliance;
	}

	/**
	 * Call DAO sortByPrice method
	 * 
	 * @return List of appliance
	 */
	public List<Appliance> sortByPrice() {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		List<Appliance> appliances = applianceDAO.sortByPrice();

		return appliances;
	}
}
