package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Discount;
import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import fr.epsi.springHalloween.springHalloween.entity.User;
import fr.epsi.springHalloween.springHalloween.repository.ServiceRepository;
import fr.epsi.springHalloween.springHalloween.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="servicetype")
public class ServiceTypeController {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @RequestMapping(path="getAll", method= RequestMethod.GET)
    public List<ServiceType> getAllServiceTypes(){
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @RequestMapping(path = "getById", method = RequestMethod.GET)
    public ServiceType getServiceType(@RequestParam Integer id) {
        Optional<ServiceType> serviceType = serviceTypeRepository.findById(id);
        return serviceType.orElse(null);
    }

    @RequestMapping(path="create", method = RequestMethod.POST)
    public String setServiceType(@RequestBody ServiceType serviceType){
        serviceTypeRepository.save(serviceType);
        return serviceType.getName() + " has been added !";
    }

    @PutMapping (path = "update")
    public ServiceType update(@RequestBody ServiceType serviceType) {
        Optional<ServiceType> ServiceType = serviceTypeRepository.findById(serviceType.getId());
        if(ServiceType.isPresent()){
            serviceTypeRepository.save(serviceType);
            return serviceType;
        }else{
            return null;
        }
    }

    @DeleteMapping (path = "delete")
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        Optional<ServiceType> serviceType = serviceTypeRepository.findById(id);
        if (serviceType.isPresent()) {
            serviceTypeRepository.delete(serviceType.get());
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
