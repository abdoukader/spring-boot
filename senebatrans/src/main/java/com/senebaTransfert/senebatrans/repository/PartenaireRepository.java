package com.senebaTransfert.senebatrans.repository;


import com.senebaTransfert.senebatrans.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    
}