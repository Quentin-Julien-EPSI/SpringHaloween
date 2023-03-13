package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Discount;
import fr.epsi.springHalloween.springHalloween.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "address")
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
    public ResponseEntity<Void> deleteAddress(@RequestParam Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.delete(address.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(path = "update", method = RequestMethod.PUT)
    public Address updateAddress(@RequestBody Address address){
        Optional<Address> Address = addressRepository.findById(address.getId());
        if(Address.isPresent()){
            addressRepository.save(address);
            return address;
        }else{
            return null;
        }
    }
}
