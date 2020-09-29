package com.qa.demo.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistance.domain.Guitarist;

@Repository
public interface GuitaristRepo extends JpaRepository<Guitarist, Long> {
//	J-Java
//	P-Persistance
//	A-Application
	
	
	//SELECT * FROM Guitarist WHERE Guitarist.name = name;

}
