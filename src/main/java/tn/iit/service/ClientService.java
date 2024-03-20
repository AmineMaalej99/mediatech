package tn.iit.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import tn.iit.dto.ClientRequestDto;
import tn.iit.dto.ClientResponseDto;

public interface ClientService {
	ClientResponseDto save(ClientRequestDto clientRequestDto);

	ClientResponseDto findById(Integer id);

	ClientResponseDto findByNom(String Nom);

	void delete(Integer id);

	ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException;

	List<ClientResponseDto> findAll();

}
