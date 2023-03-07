package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Discount;
import fr.epsi.springHalloween.springHalloween.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "adress")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    //1 Get address
    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Address> getAddress() {
        return (List<Address>) addressRepository.findAll();
    }

    //2 get Address by name
    @RequestMapping(path = "find", method = RequestMethod.GET)
    public Address getAddress(@RequestParam Integer id) {
        Optional<Address> Address = addressRepository.findById(id);
        if (Address.isPresent()) {
            return (Address.get());
        } else {
            return null;
        }
    }

    //3 Create Address

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Address createAddress(@RequestBody Address address) {
        addressRepository.save(address);
        return address;
    }

    @RequestMapping(path = "delete", method = RequestMethod.DELETE)
    public Integer deleteAddress(@RequestParam Integer id){
        Optional<Address> Address = addressRepository.findById(id);
        if(Address.isPresent()){
            addressRepository.delete(Address.get());
            return 204;
        }else{
            return 
        }
    }
}
