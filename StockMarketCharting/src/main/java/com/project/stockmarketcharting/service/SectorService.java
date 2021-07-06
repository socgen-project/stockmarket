package com.project.stockmarketcharting.service;

import java.util.List;

import com.project.stockmarketcharting.entity.SectorEntity;

public interface SectorService {
	public SectorEntity createsector(SectorEntity sector) throws Exception;

	public List<SectorEntity> getAllSectors();

	public void deleteSector(Long sectorId);

}
