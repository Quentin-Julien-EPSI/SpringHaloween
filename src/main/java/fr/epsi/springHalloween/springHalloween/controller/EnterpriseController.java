package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Enterprise;
import fr.epsi.springHalloween.springHalloween.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "enterprise")
public class EnterpriseController {
    @Autowired
    EnterpriseRepository enterpriseRepository;

    @GetMapping(path = "getAll")
    public Iterable<Enterprise> getAll(){
        return enterpriseRepository.findAll();
    }

    @GetMapping(path = "getById")
    public Enterprise getById(Integer id){
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if(enterprise.isPresent()){
            return enterprise.get();
        }else{
            return null;
        }
    }

    @PostMapping(path = "create")
    public Enterprise create(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    @PutMapping(path = "update")
    public Enterprise update(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    @DeleteMapping(path = "delete")
    public void delete(Integer id){
        enterpriseRepository.deleteById(id);
    }
}
