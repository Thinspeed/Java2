package by.bsuir.Thinspeed.service.impl;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import by.bsuir.Thinspeed.entity.Appliance;
import by.bsuir.Thinspeed.entity.Appliances;
import by.bsuir.Thinspeed.service.JAXBService;

/** Implementation of JAXB service interface */
public class JAXBServiceImpl implements JAXBService {

    /**
     * Deserializes data from xml file list of appliance
     * 
     * @param file DB file
     * @return List of appliance
     */
    public List<Appliance> unmarshalAppliance(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Appliances.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Appliances appliances = (Appliances) jaxbUnmarshaller.unmarshal(file);
            return appliances.getAppliances();
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
