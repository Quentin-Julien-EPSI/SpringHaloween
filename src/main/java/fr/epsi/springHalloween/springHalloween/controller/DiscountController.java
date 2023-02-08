package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Discount;
import fr.epsi.springHalloween.springHalloween.entity.Order;
import fr.epsi.springHalloween.springHalloween.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "discount")
public class DiscountController {

    @Autowired
    DiscountRepository discountRepository;

    //1 Get discount
    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Discount> getDiscount() {
        return (List<Discount>) discountRepository.findAll();
    }

    //2 get discount by name
    @RequestMapping(path = "find", method = RequestMethod.GET)
    public Discount getDiscount(@RequestParam Integer id) {
        Optional<Discount> Discount = discountRepository.findById(id);
        if (Discount.isPresent()) {
            return (Discount.get());
        } else {
            return null;
        }
    }

    //3 Create discount

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Discount createDiscount(@RequestBody Discount discount) {
        discountRepository.save(discount);
        return discount;
    }

    //4 Delete Discount

    @RequestMapping(path = "delete", method = RequestMethod.DELETE)
    public void deleteDiscount(@RequestParam Integer id) {
        discountRepository.deleteById(id);
    }
}
