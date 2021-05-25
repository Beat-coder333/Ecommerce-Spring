package it.object.mapstruct.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.RigaOrdine;

@Repository
public interface OrdineRigaRepository extends JpaRepository<RigaOrdine, Long> {

}
