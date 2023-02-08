package fr.epsi.springHalloween.springHalloween.controller;


import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Product;
import fr.epsi.springHalloween.springHalloween.repository.AddressRepository;
import fr.epsi.springHalloween.springHalloween.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    //1 Get product
    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Product> getProduct() {
        return (List<Product>) productRepository.findAll();
    }

    //2 get product by name
    @RequestMapping(path = "find", method = RequestMethod.GET)
    public Product getProduct(@RequestParam Integer id) {
        Optional<Product> Product = productRepository.findById(id);
        if (Product.isPresent()) {
            return (Product.get());
        } else {
            return null;
        }
    }

    //3 Create Product

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

}
