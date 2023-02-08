package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Discount;
import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import fr.epsi.springHalloween.springHalloween.repository.ServiceRepository;
import fr.epsi.springHalloween.springHalloween.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="servicetype")
public class ServiceTypeController {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    // 1. GET : ALL Service Types
    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<ServiceType> getAllServiceTypes(){
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    // 2. GET : Service Type by id
    @RequestMapping(path = "/find", method = RequestMethod.GET)
    public ServiceType getServiceType(@RequestParam Long id) {
        Optional<ServiceType> serviceType = serviceTypeRepository.findById(id);
        return serviceType.orElse(null);
    }

    // 3. POST : New Service Type
    @RequestMapping(path="", method= RequestMethod.POST)
    public String setServiceType(@RequestParam String name){
        ServiceType serviceType = new ServiceType();
        serviceType.setName(name);
        serviceTypeRepository.save(serviceType);
        return name + " has been added !";
    }
}
