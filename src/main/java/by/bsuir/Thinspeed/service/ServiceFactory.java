package by.bsuir.Thinspeed.service;

import by.bsuir.Thinspeed.service.impl.ApplianceServiceImpl;
import by.bsuir.Thinspeed.service.impl.HelperServiceImpl;
import by.bsuir.Thinspeed.service.impl.JAXBServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();

	private final HelperService helperService = new HelperServiceImpl();

	private final JAXBService jAXBService = new JAXBServiceImpl();

	private ServiceFactory() {
	}

	public JAXBService getJAXBService() {
		return jAXBService;
	}

	public ApplianceService getApplianceService() {
		return applianceService;
	}

	public HelperService getHelperService() {
		return helperService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}
