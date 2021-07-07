package com.project.stockmarketcharting.service;

import java.util.List;

import com.project.stockmarketcharting.entity.SectorEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;

public interface SectorService {
	public SectorEntity createsector(SectorEntity sector) throws EntityAlreadyExistsException;

	public List<SectorEntity> getAllSectors();

	public void deleteSector(Long sectorId);

}
