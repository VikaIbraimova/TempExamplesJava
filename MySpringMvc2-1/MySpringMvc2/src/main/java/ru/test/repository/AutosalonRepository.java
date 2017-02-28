package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.test.model.Autosalon;

import java.util.List;

public interface AutosalonRepository extends JpaRepository<Autosalon,Long> {
//public interface AutosalonRepository extends CrudRepository<Autosalon,Long> {
    //@Query("select distinct(address),worker_id from autosalon where address like '%S%'")
    @Query("select b from Autosalon b where b.address = :address")
    Autosalon findByAddress(@Param("address") String address);

    //@Query("FROM Test where dummy = ?1 ORDER BY tries ASC")
    //List<Product> findTests(boolean dummyVal);
    //@Query("FROM autosalon WHERE address = ?1 ORDER BY address ASC")
    //List<Autosalon> getAddress(String address);
}
