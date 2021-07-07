package com.project.stockmarketcharting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketcharting.entity.SectorEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.impl.SectorServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class SectorController {

	@Autowired
	private SectorServiceImpl sectorService;

	@PostMapping("sector/add")
	public ResponseEntity<Object> addSector(@RequestBody SectorEntity sector) {
		try {
			SectorEntity createdSector = sectorService.createsector(sector);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdSector.getId());
		} catch (EntityAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/sectors")
	public ResponseEntity<List<SectorEntity>> getAllSectors() {
		List<SectorEntity> allSectors = sectorService.getAllSectors();
		if (allSectors.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(allSectors);
	}

	@DeleteMapping("/sector/{id}")
	public ResponseEntity<String> deleteSector(@PathVariable("id") Long sectorId) {
		sectorService.deleteSector(sectorId);
		return ResponseEntity.ok().body("Sector with Id : " + sectorId + " succesfully Deleted");
	}
}
