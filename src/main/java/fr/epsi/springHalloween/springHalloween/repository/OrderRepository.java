package fr.epsi.springHalloween.springHalloween.repository;

import fr.epsi.springHalloween.springHalloween.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;



public interface OrderRepository extends CrudRepository<Order, Integer> {

}