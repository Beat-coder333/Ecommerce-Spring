package it.object.mapstruct.ecommerce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.OrdineDTO;
import it.object.mapstruct.ecommerce.mapper.OrdineMapper;
import it.object.mapstruct.ecommerce.model.Carrello;
import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;
import it.object.mapstruct.ecommerce.model.Ordine;
import it.object.mapstruct.ecommerce.model.RigaOrdine;
import it.object.mapstruct.ecommerce.model.Utente;
import it.object.mapstruct.ecommerce.repository.CarrelloRepository;
import it.object.mapstruct.ecommerce.repository.OrdineRepository;
import it.object.mapstruct.ecommerce.repository.OrdineRigaRepository;
import it.object.mapstruct.ecommerce.repository.UtenteRepository;

@Service
public class OrdineService {

	@Autowired
	private OrdineRepository orderRepo;

	@Autowired
	private OrdineMapper orderMapper;

	@Autowired
	private OrdineRigaRepository rigaOrdRepo;

	@Autowired
	private UtenteRepository userRepo;

	@Autowired
	private CarrelloRepository cartRepo;

	public Integer getDailyOrders(String date) {
		return orderRepo.countByData(date);
	}

	public List<OrdineDTO> getOrdersByIdUser(Long idUtente) {
		List<OrdineDTO> ordersList = orderMapper.toDto(orderRepo.findByUserId(idUtente));
		return ordersList;
	}

	public void saveOrder(String numOrder, Long idUtente) {
		LocalDate now = LocalDate.now();
		String date = now.toString();
		Optional<Utente> user = userRepo.findById(idUtente);
		Ordine order = new Ordine();
		order.setNumOrder(numOrder);
		order.setUser(user.get());
		order.setData(date);
		orderRepo.save(order);

		saveRigaOrdine(idUtente, order);
	}

	private void saveRigaOrdine(Long idUtente, Ordine order) {
		Carrello cart = cartRepo.findByUserId(idUtente);
		List<CarrelloDettaglio> cartDetList = cart.getCartDetailsList();

		for (CarrelloDettaglio element : cartDetList) {
			RigaOrdine rigaOrdine = new RigaOrdine();
			rigaOrdine.setArticle(element.getArticolo());
			rigaOrdine.setQuantity(element.getQuantita());
			rigaOrdine.setOrderId(order.getId());
			rigaOrdRepo.save(rigaOrdine);

		}
	}

}
