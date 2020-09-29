package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.demo.dto.GuitaristDTO;
import com.qa.demo.dto.exception.GutaristNotFoundException;
import com.qa.demo.persistance.domain.Guitarist;
import com.qa.demo.persistance.repository.GuitaristRepo;
import com.qa.demo.utils.DemoBeanUtils;


@Service
public class GuitaristService {
	
	//Create, read, readById, update, delete
	
	private GuitaristRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public GuitaristService(GuitaristRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private GuitaristDTO mapToDTO(Guitarist guitarist) {
		return this.mapper.map(guitarist, GuitaristDTO.class);
	}
	
	private Guitarist mapFromDTO(GuitaristDTO guitaristDTO) {
		return this.mapper.map(guitaristDTO, Guitarist.class);
	}
	
	//Create
	public GuitaristDTO createGuitarist(GuitaristDTO guitaristDTO) {
		Guitarist toSave = this.mapFromDTO(guitaristDTO);
		Guitarist saved = this.repo.save(toSave);
		return this.mapToDTO(saved);
	}
	
	//read
	public List<GuitaristDTO> readAllGuitarist(){
		
		return this.repo.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
	
	//read by id
	public GuitaristDTO readById(Long id) {
		Guitarist found = this.repo.findById(id).orElseThrow(GutaristNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	//Update
	public GuitaristDTO update (GuitaristDTO guitaristDTO, Long id) {
		//Find the object I want to update
		Guitarist toUpdate = this.repo.findById(id).orElseThrow(GutaristNotFoundException::new);
		//merge the old with the new in the toUpdate object
		DemoBeanUtils.mergeObject(guitaristDTO, toUpdate);
		//Save the new file in the repository
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//Delete
	public boolean delete (Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
}
