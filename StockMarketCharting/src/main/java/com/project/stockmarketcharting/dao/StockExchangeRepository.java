package com.project.stockmarketcharting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarketcharting.entity.StockExchangeEntity;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity, Long> {

}
