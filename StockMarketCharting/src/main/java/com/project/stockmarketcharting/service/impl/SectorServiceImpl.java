package com.project.stockmarketcharting.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.stockmarketcharting.dao.SectorRepository;
import com.project.stockmarketcharting.entity.SectorEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.SectorService;

@Service
public class SectorServiceImpl implements SectorService {

	@Autowired
	private SectorRepository sectorRepository;

	@Override
	public SectorEntity createsector(SectorEntity sector) throws EntityAlreadyExistsException {
		SectorEntity findBysectorName = sectorRepository.findBysectorName(sector.getSectorName());
		if (findBysectorName != null) {
			throw new EntityAlreadyExistsException("Sector");
		}

		return sectorRepository.save(sector);
	}

	@Override
	public List<SectorEntity> getAllSectors() {
		return sectorRepository.findAll(Sort.by(Sort.Direction.ASC, "sectorName"));
	}

	@Override
	public void deleteSector(Long sectorId) throws ObjectNotFoundException {
		Optional<SectorEntity> findById = sectorRepository.findById(sectorId);
		if (!findById.isPresent()) {
			throw new ObjectNotFoundException(sectorId, "Sector");
		}
		sectorRepository.deleteById(sectorId);
	}

}
