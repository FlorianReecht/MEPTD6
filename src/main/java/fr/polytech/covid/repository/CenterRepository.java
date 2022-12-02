package fr.polytech.covid.repository;

import fr.polytech.covid.entity.Center;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CenterRepository extends CrudRepository<Center, Integer> {
    List<Center> findByOrderByNameAsc();

    List<Center> findByCityContainsIgnoreCaseOrderByNameAsc(String city);
    List<Center> findByNameContainsIgnoreCaseOrderByNameAsc(String name);





}
