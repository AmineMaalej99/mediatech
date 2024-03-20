package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.models.ClientEntity;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
	
	ClientEntity findByNom(String nom);
	

}
