package com.project.stockmarketcharting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarketcharting.entity.SectorEntity;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Long> {
	public SectorEntity findBysectorName(String sectorName);
}
