package com.project.stockmarketcharting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketcharting.entity.CompanyEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.impl.CompanyServiceImpl;

@RestController
public class CompanyController {

	@Autowired
	private CompanyServiceImpl companyService;

	@GetMapping("/companies/{id}")
	public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable("id") Long companyId) {
		CompanyEntity companyById = companyService.getCompanyById(companyId);
		return ResponseEntity.ok().body(companyById);

	}

	@PostMapping("/admin/companies/add")
	public ResponseEntity<Object> addCompany(@RequestBody CompanyEntity company) throws EntityAlreadyExistsException {
		return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(company));
	}

	@DeleteMapping("/admin/companies/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long companyId) {
		companyService.deleteCompanyById(companyId);
		return ResponseEntity.ok().body("Company with Id : " + companyId + " succesfully Deleted");
	}

}
