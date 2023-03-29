package fr.epsi.springHalloween.springHalloween.repository;

import fr.epsi.springHalloween.springHalloween.entity.ServiceType;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Integer> {

}