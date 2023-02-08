package fr.epsi.springHalloween.springHalloween.repository;

import fr.epsi.springHalloween.springHalloween.entity.Enterprise;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EnterpriseRepository extends CrudRepository<Enterprise, Integer> {

}