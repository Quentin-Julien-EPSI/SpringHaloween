package fr.epsi.springHalloween.springHalloween.controller;

import fr.epsi.springHalloween.springHalloween.entity.*;
import fr.epsi.springHalloween.springHalloween.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "getAll", method = RequestMethod.GET)
    public Iterable<Basket> getAll() {
        return basketRepository.findAll();
    }

    @RequestMapping(path = "getById", method = RequestMethod.GET)
    public Basket getById(Integer id) {
        Optional<Basket> basket = basketRepository.findById(id);
        if(basket.isPresent()) {
            return basket.get();
        }else{
            return null;
        }
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Basket create(@RequestBody Map<String, Object> payload) {
        Integer discountId = Integer.parseInt((String) payload.get("discount_id"));
        Integer userId = Integer.parseInt((String) payload.get("user_id"));
        if (payload.get("discount_id") instanceof Integer) {
            discountId = (Integer) payload.get("discount_id");
        } else if (payload.get("discount_id") instanceof String) {
            discountId = Integer.parseInt((String) payload.get("discount_id"));
        }

        if (payload.get("user_id") instanceof Integer) {
            userId = (Integer) payload.get("user_id");
        } else if (payload.get("user_id") instanceof String) {
            userId = Integer.parseInt((String) payload.get("user_id"));
        }

        List<String> servicesIdStrings = (List<String>) payload.get("services_id");
        List<String> productsIdStrings = (List<String>) payload.get("products_id");

        List<Integer> servicesId = servicesIdStrings.stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> productsId = productsIdStrings.stream().map(Integer::parseInt).collect(Collectors.toList());


        Optional<Discount> discount = discountRepository.findById(discountId);
        Discount discount1 = null;
        if (discount.isPresent()) {
            discount1 = discount.get();
        }
        List<Product> products = new ArrayList<Product>();
        productsId.forEach(product ->
                {
                    Optional<Product> product1 = productRepository.findById(product);
                    products.add(product1.get());
                }
        );
        List<Service> services = new ArrayList<Service>();
        servicesId.forEach(service ->
                {
                    Optional<Service> service1 = serviceRepository.findById(service);
                    services.add(service1.get());
                }
        );
        Optional<User> user = userRepository.findById(userId);
        User user1 = null;
        if (user.isPresent()) {
            user1 = user.get();
        }
        Basket basket = new Basket();
        basket.setDiscount(discount1);
        basket.setProducts(products);
        basket.setServices(services);
        basket.setUser(user1);
        return basketRepository.save(basket);
    }

    @RequestMapping(path = "update", method = RequestMethod.PUT)
    public Basket update(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }

    @RequestMapping(path = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(Integer id) {
        Optional<Basket> basket = basketRepository.findById(id);
        if(basket.isPresent()) {
            basketRepository.delete(basket.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
