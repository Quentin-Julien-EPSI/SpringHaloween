package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Service;
import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import fr.epsi.springHalloween.springHalloween.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="service")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    // 1. GET : ALL Services
    @RequestMapping(path="/all", method= RequestMethod.GET)
    public List<Service> getAllServices(){
        return (List<Service>) serviceRepository.findAll();
    }

    // 2. GET : Service by id
    @RequestMapping(path = "/find", method = RequestMethod.GET)
    public Service getService(@RequestParam Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.orElse(null);
    }

}
