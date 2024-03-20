package tn.iit.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import tn.iit.dao.ClientDao;
import tn.iit.dto.ClientRequestDto;
import tn.iit.dto.ClientResponseDto;
import tn.iit.exception.EntityNotFoundException;
import tn.iit.models.ClientEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {

        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {

        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Client Not Found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);

    }

    @Override
    public ClientResponseDto findByNom(String Nom) {

        ClientEntity clientEntity = clientDao.findByNom(Nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if (clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = clientEntityOptional.get();
            clientDao.delete(clientEntity);
        } else {
            throw new RuntimeException("Client not found with ID: " + id);
        }
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);

        if (clientEntityOptional.isPresent()) {
            ClientEntity existingClientEntity = clientEntityOptional.get();
            existingClientEntity.setNom(clientRequestDto.getNom());
            existingClientEntity.setPrenom(clientRequestDto.getPrenom());
            existingClientEntity.setTelephone(clientRequestDto.getTelephone());
            ClientEntity updated = clientDao.save(existingClientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        } else {
            throw new EntityNotFoundException("client Nof Found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll().stream().map(el -> modelMapper.map(el, ClientResponseDto.class))
                .collect(Collectors.toList());
    }

}
