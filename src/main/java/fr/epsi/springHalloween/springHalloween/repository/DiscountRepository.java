package fr.epsi.springHalloween.springHalloween.repository;

import fr.epsi.springHalloween.springHalloween.entity.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount, Integer> {
}