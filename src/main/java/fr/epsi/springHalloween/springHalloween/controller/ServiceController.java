package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Product;
import fr.epsi.springHalloween.springHalloween.entity.Service;
import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import fr.epsi.springHalloween.springHalloween.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="service")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping(path="getAll", method= RequestMethod.GET)
    public List<Service> getAllServices(){
        return (List<Service>) serviceRepository.findAll();
    }

    @RequestMapping(path = "getById", method = RequestMethod.GET)
    public Service getService(@RequestParam Integer id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.orElse(null);
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Service create(@RequestBody Service service) {
        serviceRepository.save(service);
        return service;
    }

    @RequestMapping(path = "update", method = RequestMethod.PUT)
    public Service updateService(@RequestBody Service service) {
        serviceRepository.save(service);
        return service;
    }

    @RequestMapping(path = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteService(@RequestParam Integer id) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            serviceRepository.delete(service.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
