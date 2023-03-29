package fr.epsi.springHalloween.springHalloween.controller;


import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Product;
import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import fr.epsi.springHalloween.springHalloween.repository.AddressRepository;
import fr.epsi.springHalloween.springHalloween.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(path = "getAll", method = RequestMethod.GET)
    public List<Product> getProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(path = "getById", method = RequestMethod.GET)
    public Product getProduct(@RequestParam Integer id) {
        Optional<Product> Product = productRepository.findById(id);
        if (Product.isPresent()) {
            return (Product.get());
        } else {
            return null;
        }
    }

    @RequestMapping(path = "create", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @RequestMapping(path = "update", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        Optional<Product> Product = productRepository.findById(product.getId());
        if(Product.isPresent()){
            productRepository.save(product);
            return product;
        }else{
            return null;
        }

    }

    @RequestMapping(path = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@RequestParam Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
