package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Enterprise;
import fr.epsi.springHalloween.springHalloween.entity.User;
import fr.epsi.springHalloween.springHalloween.repository.AddressRepository;
import fr.epsi.springHalloween.springHalloween.repository.EnterpriseRepository;
import fr.epsi.springHalloween.springHalloween.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "enterprise")
public class EnterpriseController {
    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(path = "getAll", method = RequestMethod.GET)
    public Iterable<Enterprise> getAll() {
        return enterpriseRepository.findAll();
    }

    @RequestMapping(path = "getById", method = RequestMethod.GET)
    public Enterprise getById(Integer id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if (enterprise.isPresent()) {
            return enterprise.get();
        } else {
            return null;
        }
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Enterprise create(@RequestBody Map<String, Object> payload) {
        Integer ownerId = Integer.parseInt((String) payload.get("owner_id"));
        Integer addressId = Integer.parseInt((String) payload.get("address_id"));

        Optional<User> owner = userRepository.findById(ownerId);
        Optional<Address> address = addressRepository.findById(addressId);

        if (owner.isPresent() && address.isPresent()) {
            Enterprise enterprise = new Enterprise();
            enterprise.setName((String) payload.get("name"));
            enterprise.setSiret((String) payload.get("siret"));
            enterprise.setCreation_date((String) payload.get("creation_date"));
            enterprise.setOwner(owner.get());
            enterprise.setAddress(address.get());

            return enterpriseRepository.save(enterprise);
        } else {
            return null;
        }
    }


    @RequestMapping(path = "update", method = RequestMethod.PUT)
    public Enterprise update(@RequestBody Map<String, Object> payload) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(Integer.parseInt((String) payload.get("id")));
        Integer ownerId = Integer.parseInt((String) payload.get("owner_id"));
        Integer addressId = Integer.parseInt((String) payload.get("address_id"));

        Optional<User> owner = userRepository.findById(ownerId);
        Optional<Address> address = addressRepository.findById(addressId);

        if (owner.isPresent() && address.isPresent()) {
            Enterprise new_enterprise = new Enterprise();
            new_enterprise.setName((String) payload.get("name"));
            new_enterprise.setSiret((String) payload.get("siret"));
            new_enterprise.setCreation_date((String) payload.get("creation_date"));
            new_enterprise.setOwner(owner.get());
            new_enterprise.setAddress(address.get());

            return enterpriseRepository.save(new_enterprise);
        } else {
            return null;
        }
    }

    @RequestMapping(path = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(Integer id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if (enterprise.isPresent()) {
            enterpriseRepository.delete(enterprise.get());
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }

}
