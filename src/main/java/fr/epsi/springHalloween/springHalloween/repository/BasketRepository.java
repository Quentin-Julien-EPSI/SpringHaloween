package fr.epsi.springHalloween.springHalloween.repository;

import fr.epsi.springHalloween.springHalloween.entity.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Integer> {
}