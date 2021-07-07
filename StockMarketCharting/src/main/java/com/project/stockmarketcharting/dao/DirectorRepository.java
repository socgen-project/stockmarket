package com.project.stockmarketcharting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarketcharting.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
