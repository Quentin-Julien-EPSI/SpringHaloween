package fr.epsi.springHalloween.springHalloween.repository;

import fr.epsi.springHalloween.springHalloween.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}