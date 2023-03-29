package fr.epsi.springHalloween.springHalloween.controller;


import fr.epsi.springHalloween.springHalloween.entity.Order;
import fr.epsi.springHalloween.springHalloween.repository.OrderRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

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
    public Order createOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
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
