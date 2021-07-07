package com.project.stockmarketcharting.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.project.stockmarketcharting.dao.CompanyRepository;
import com.project.stockmarketcharting.dao.DirectorRepository;
import com.project.stockmarketcharting.entity.CompanyEntity;
import com.project.stockmarketcharting.entity.Director;
import com.project.stockmarketcharting.exception.EntityAlreadyExistsException;
import com.project.stockmarketcharting.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	DirectorRepository directorRepository;

	@Override
	public CompanyEntity createCompany(CompanyEntity company) throws EntityAlreadyExistsException {
		CompanyEntity existingCompany = companyRepository.findBycompanyName(company.getCompanyName());
		if (existingCompany != null) {
			throw new EntityAlreadyExistsException(company.getClass().getSimpleName());
		}
		List<Director> directors = company.getDirectors();
		for (Director d : directors) {
			directorRepository.save(d);
		}
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
