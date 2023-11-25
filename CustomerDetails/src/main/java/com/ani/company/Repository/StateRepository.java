package com.ani.company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.company.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

	
}
