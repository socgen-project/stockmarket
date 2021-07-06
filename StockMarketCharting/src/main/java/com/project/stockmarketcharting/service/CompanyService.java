package com.project.stockmarketcharting.service;

import java.util.List;

import com.project.stockmarketcharting.entity.CompanyEntity;

public interface CompanyService {

	public CompanyEntity createCompany(CompanyEntity company);

	public CompanyEntity getCompanyById(Long companyId);

	public void deleteCompanyById(Long companyId);

	public List<CompanyEntity> getAllCompanies();
}
