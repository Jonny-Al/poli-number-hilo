package com.poli.hilos.repository;

import com.poli.hilos.entity.EntityNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IEntityRepository extends JpaRepository<EntityNumber, Integer> {

    @Query (nativeQuery = true, value = "SELECT * FROM (SELECT * FROM polinumeros.ENTITY_NUMBER ORDER BY NUMBER_INDEX ASC LIMIT 500) AS NUMBER_MAYOR")  /*primeros*/
    List<EntityNumber> getTheHighestNumberFirstAll();

    @Query (nativeQuery = true, value = "SELECT * FROM (SELECT * FROM polinumeros.ENTITY_NUMBER ORDER BY NUMBER_INDEX DESC LIMIT 500) AS NUMBER_MAYOR")  /*ultimos*/
    List<EntityNumber> getTheHighestNumberLastAll();

}
