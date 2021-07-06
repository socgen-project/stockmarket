package com.project.stockmarketcharting.service.impl;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.project.stockmarketcharting.dao.CompanyRepository;
import com.project.stockmarketcharting.entity.CompanyEntity;
import com.project.stockmarketcharting.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public CompanyEntity createCompany(CompanyEntity company) {
		return companyRepository.save(company);
	}

	@Override
	public CompanyEntity getCompanyById(Long companyId) {
		Optional<CompanyEntity> company = companyRepository.findById(companyId);
		if (!company.isPresent()) {
			throw new ObjectNotFoundException(companyId, "Company");
		}
		return company.get();
	}

	@Override
	public void deleteCompanyById(Long companyId) {
		Optional<CompanyEntity> findById = companyRepository.findById(companyId);
		if (!findById.isPresent()) {
			throw new ObjectNotFoundException(companyId, "Company");
		}
		companyRepository.deleteById(companyId);
	}

	@Override
	public Page<CompanyEntity> getAllCompanies() {
		return null;

	}

}
