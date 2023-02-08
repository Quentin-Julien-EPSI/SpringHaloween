package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.Basket;
import fr.epsi.springHalloween.springHalloween.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    @Autowired
    BasketRepository basketRepository;

    @GetMapping(path = "getAll")
    public Iterable<Basket> getAll() {
        return basketRepository.findAll();
    }

    @GetMapping(path = "getById")
    public Basket getById(Integer id) {
        Optional<Basket> basket = basketRepository.findById(id);
        if(basket.isPresent()) {
            return basket.get();
        }else{
            return null;
        }
    }

    @PostMapping(path = "create")
    public Basket create(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }

    @PutMapping(path = "update")
    public Basket update(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }
}
