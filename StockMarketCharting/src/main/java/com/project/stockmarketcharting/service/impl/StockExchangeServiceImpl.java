package com.project.stockmarketcharting.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockmarketcharting.dao.StockExchangeRepository;
import com.project.stockmarketcharting.entity.StockExchangeEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.StockExchangeService;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@Override
	public StockExchangeEntity createStockExchange(StockExchangeEntity stockExchange)
			throws EntityAlreadyExistsException {
		StockExchangeEntity existingStockExchange = stockExchangeRepository
				.findBystockExchangeName(stockExchange.getStockExchangeName());
		if (existingStockExchange != null) {
			throw new EntityAlreadyExistsException(stockExchange.getClass().getSimpleName());
		}

		return stockExchangeRepository.save(stockExchange);

	}

	@Override
	public StockExchangeEntity getStockExchangeById(Long stockExchangeId) {
		Optional<StockExchangeEntity> stockExchange = stockExchangeRepository.findById(stockExchangeId);
		if (!stockExchange.isPresent()) {
			throw new ObjectNotFoundException(stockExchangeId, "Company");
		}
		return stockExchange.get();
	}

	@Override
	public List<StockExchangeEntity> getAllStockExchange() {
		return stockExchangeRepository.findAll();
	}

	@Override
	public int getNumberOfStockExchange() {
		return this.getAllStockExchange().size();
	}

}
