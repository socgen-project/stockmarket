package com.project.stockmarketcharting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketcharting.entity.StockExchangeEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.impl.StockExchangeServiceImpl;

@RestController
@CrossOrigin
public class StockExchangeController {

	@Autowired
	StockExchangeServiceImpl stockExchangeService;

	@PostMapping("admin/stock-exchanges/add")
	public ResponseEntity<StockExchangeEntity> createStockExchange(@RequestBody StockExchangeEntity stockExchange)
			throws EntityAlreadyExistsException {
		return ResponseEntity.ok(stockExchangeService.createStockExchange(stockExchange));
	}

	@GetMapping("/stock-exchanges")
	public ResponseEntity<List<StockExchangeEntity>> getAllStockExchange() {
		List<StockExchangeEntity> allStockExchanges = stockExchangeService.getAllStockExchange();
		return ResponseEntity.ok(allStockExchanges);
	}

	@GetMapping("/stock-exchanges/length")
	public ResponseEntity<Integer> getNumberOfStockExchange() {
		int numberOfStockExchange = stockExchangeService.getNumberOfStockExchange();
		return ResponseEntity.ok(numberOfStockExchange);
	}

	@DeleteMapping("/stock-exchanges/{stockExchangeId}")
	public ResponseEntity<Object> deleteStockExchange() {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Deleting a Stock Exchange is not Permitted");
	}

	{

	}

}
