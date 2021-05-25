package it.object.mapstruct.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.Ordine;
import it.object.mapstruct.ecommerce.model.RigaOrdine;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

	public List<Ordine> findByUserId(Long userId);

	public RigaOrdine findByNumOrder(String numOrder);

	public Integer countByData(String date);

}
