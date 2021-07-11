package com.project.stockmarketcharting.service;

import java.util.List;

import com.project.stockmarketcharting.entity.StockExchangeEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;

public interface StockExchangeService {
	public StockExchangeEntity createStockExchange(StockExchangeEntity stockExchange)
			throws EntityAlreadyExistsException;

	StockExchangeEntity getStockExchangeById(Long stockExchangeId);

	List<StockExchangeEntity> getAllStockExchange();

	int getNumberOfStockExchange();
}
