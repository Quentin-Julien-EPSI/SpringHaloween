package fr.epsi.springHalloween.springHalloween.controller;


import fr.epsi.springHalloween.springHalloween.entity.Address;
import fr.epsi.springHalloween.springHalloween.entity.Order;
import fr.epsi.springHalloween.springHalloween.entity.Product;
import fr.epsi.springHalloween.springHalloween.entity.User;
import fr.epsi.springHalloween.springHalloween.repository.AddressRepository;
import fr.epsi.springHalloween.springHalloween.repository.OrderRepository;
import fr.epsi.springHalloween.springHalloween.repository.ProductRepository;
import fr.epsi.springHalloween.springHalloween.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping (path = "order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    //1 Get orders
    @RequestMapping(path = "getAll",method = RequestMethod.GET)
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    //2 get orders by name
    @RequestMapping(path = "getById", method = RequestMethod.GET )
    public Order getOrder(@RequestParam Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            return(order.get());
        }
        else {
            return null;
        }
    }

    //3 Create order

    @RequestMapping(path = "create",method = RequestMethod.POST)
    public Order createOrder(@RequestBody Map<String, Object> payload) {
        Integer productId = Integer.parseInt((String) payload.get("product_id"));
        Integer userId = Integer.parseInt((String) payload.get("user_id"));
        Integer addressId = Integer.parseInt((String) payload.get("address_id"));

        Optional<Product> product = productRepository.findById(productId);
        Optional<User> user = userRepository.findById(userId);
        Optional<Address> address = addressRepository.findById(addressId);

        if(product.isPresent() && user.isPresent() && address.isPresent()) {
            Order order = new Order();
            order.setProduct(product.get());
            order.setUser(user.get());
            order.setAddress(address.get());
            order.setValid(true);
            orderRepository.save(order);
            return order;
        }
        else {
            return null;
        }
    }

    @RequestMapping(path = "update",method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
    }

    @RequestMapping(path = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@RequestParam Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            orderRepository.delete(order.get());
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
