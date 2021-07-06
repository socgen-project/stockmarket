package com.project.stockmarketcharting.service;

import org.springframework.data.domain.Page;

import com.project.stockmarketcharting.entity.CompanyEntity;

public interface CompanyService {

	public CompanyEntity createCompany(CompanyEntity company);

	public CompanyEntity getCompanyById(Long companyId);

	public void deleteCompanyById(Long companyId);

	public Page<CompanyEntity> getAllCompanies();
}
