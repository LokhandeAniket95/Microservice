package com.ani.company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.company.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
