package by.bsuir.Thinspeed.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import by.bsuir.Thinspeed.dao.ApplianceDAO;
import by.bsuir.Thinspeed.entity.Appliance;
import by.bsuir.Thinspeed.entity.criteria.Criteria;
import by.bsuir.Thinspeed.service.HelperService;
import by.bsuir.Thinspeed.service.JAXBService;
import by.bsuir.Thinspeed.service.ServiceFactory;

public class ApplianceDAOImpl implements ApplianceDAO {

	/** Path to DB */
	public static final String pathToDB = "src\\main\\resources\\appliances_db.xml";

	/** List of appliances from DB */
	private List<Appliance> appliances;

	/**
	 * ApplianceDAOImpl constructor
	 */
	public ApplianceDAOImpl() {
		ServiceFactory factory = ServiceFactory.getInstance();
		JAXBService service = factory.getJAXBService();

		File file = new File(pathToDB);
		appliances = service.unmarshalAppliance(file);

		if (appliances == null) {
			appliances = new ArrayList<Appliance>();
		}
	}

	/**
	 * Searches for the specified criteria
	 * 
	 * @param criteria search criterias
	 * @return List of appliance
	 */
	public List<Appliance> find(Criteria criteria) {
		ServiceFactory factory = ServiceFactory.getInstance();
		HelperService service = factory.getHelperService();

		List<Appliance> findAppliances = new ArrayList<Appliance>();
		List<Appliance> findgroupAppliances = new ArrayList<Appliance>();
		String groupSearchName = criteria.getGroupSearchName();

		for (Appliance appliance : appliances) {
			if (appliance.getClass().getSimpleName().equals(groupSearchName)) {
				findgroupAppliances.add(appliance);
			}
		}
		if (findgroupAppliances.size() == 0) {
			return null;
		}
		Map<String, Object> criterias = criteria.getCriterias();
		for (Appliance appliance : findgroupAppliances) {
			boolean isCriteriasEquals = true;
			for (String key : criterias.keySet()) {
				String methodName = service.getMethodGetterName(key);
				Object result = service.methodCaller(methodName, appliance);
				if (result == null || !result.equals(criterias.get(key))) {
					isCriteriasEquals = false;
				}
			}
			if (isCriteriasEquals) {
				findAppliances.add(appliance);
			}
		}
		if (findAppliances.size() == 0) {
			return null;
		}
		return findAppliances;

	}

	/**
	 * Sorts the list of appliance ascending order by price
	 * 
	 * @return List of appliance
	 */
	public List<Appliance> sortByPrice() {
		TreeSet<Appliance> sortAppliances = new TreeSet<Appliance>();
		for (Appliance appliance : appliances) {
			sortAppliances.add(appliance);
		}
		return new ArrayList<Appliance>(sortAppliances);
	}
}