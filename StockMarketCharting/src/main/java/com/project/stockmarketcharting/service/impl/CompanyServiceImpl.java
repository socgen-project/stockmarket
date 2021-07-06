package com.project.stockmarketcharting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

		return null;
	}

	@Override
	public void deleteCompanyById(Long companyId) {

	}

	@Override
	public List<CompanyEntity> getAllCompanies() {
		return companyRepository.findAll(Sort.by(Sort.Direction.ASC, "companyName"));
	}

}
