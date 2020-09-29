package com.qa.demo.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistance.domain.Band;

@Repository
public interface BandRepo extends JpaRepository<Band, Long> {

}
