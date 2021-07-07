package com.project.stockmarketcharting.service;

import org.springframework.data.domain.Page;

import com.project.stockmarketcharting.entity.CompanyEntity;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;

public interface CompanyService {

	public CompanyEntity createCompany(CompanyEntity company) throws EntityAlreadyExistsException;

	public CompanyEntity getCompanyById(Long companyId);

	public void deleteCompanyById(Long companyId);

	public Page<CompanyEntity> getAllCompanies();
}
