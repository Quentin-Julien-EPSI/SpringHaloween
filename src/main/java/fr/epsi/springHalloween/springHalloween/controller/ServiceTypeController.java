package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Discount;
import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import fr.epsi.springHalloween.springHalloween.entity.User;
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

    @RequestMapping(path="all", method= RequestMethod.GET)
    public List<ServiceType> getAllServiceTypes(){
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @RequestMapping(path = "find", method = RequestMethod.GET)
    public ServiceType getServiceType(@RequestParam Long id) {
        Optional<ServiceType> serviceType = serviceTypeRepository.findById(id);
        return serviceType.orElse(null);
    }

    @RequestMapping(path="create", method= RequestMethod.POST)
    public String setServiceType(@RequestParam String name){
        ServiceType serviceType = new ServiceType();
        serviceType.setName(name);
        serviceTypeRepository.save(serviceType);
        return name + " has been added !";
    }

    @PutMapping (path = "update")
    public ServiceType update(@RequestBody ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
        return serviceType;
    }

    @DeleteMapping (path = "delete")
    public void delete(@RequestParam Long id) {
        serviceTypeRepository.deleteById(id);
    }
}
