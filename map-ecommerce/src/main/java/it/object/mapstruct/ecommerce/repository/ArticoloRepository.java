package it.object.mapstruct.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.object.mapstruct.ecommerce.model.Articolo;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Long> {

	@Override
	public List<Articolo> findAll();

	@Override
	public Optional<Articolo> findById(Long id);

}
