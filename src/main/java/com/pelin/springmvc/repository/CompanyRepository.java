package com.pelin.springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pelin.springmvc.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer>{
}
