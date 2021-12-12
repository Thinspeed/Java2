package by.bsuir.Thinspeed.main;

import static by.bsuir.Thinspeed.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.bsuir.Thinspeed.entity.Appliance;
import by.bsuir.Thinspeed.entity.criteria.Criteria;
import by.bsuir.Thinspeed.service.ApplianceService;
import by.bsuir.Thinspeed.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		Criteria criteria = new Criteria(Teapot.class.getSimpleName());

		appliances = service.find(criteria);

		PrintApplianceInfo.print(appliances);

		System.out.println("The cheapest item");
		PrintApplianceInfo.print(service.sortByPrice().get(0));
		System.out.println();

		criteria = new Criteria(TabletPC.class.getSimpleName());
		criteria.add(TabletPC.COLOR.toString(), "blue");
		criteria.add(TabletPC.DISPLAY_INCHES.toString(), 14.0);
		criteria.add(TabletPC.MEMORY_ROM.toString(), 8000);

		appliances = service.find(criteria);
		PrintApplianceInfo.print(appliances);
	}

}
