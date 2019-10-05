package com.senebaTransfert.senebatrans.repository;



import com.senebaTransfert.senebatrans.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
    
}