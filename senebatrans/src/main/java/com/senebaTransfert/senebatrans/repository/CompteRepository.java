package com.senebaTransfert.senebatrans.repository;


import com.senebaTransfert.senebatrans.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findById(int id);
}