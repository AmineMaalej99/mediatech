package tn.iit.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LigneFactureKey implements Serializable {

	private static final long serialVersionUID = -7507840055643841153L;

	@Column(name = "facture_id", nullable = false)
	private Integer factureId;

	@Column(name = "produit_id", nullable = false)
	private Integer produitId;

	
}
