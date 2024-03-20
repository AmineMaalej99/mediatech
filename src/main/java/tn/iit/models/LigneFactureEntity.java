package tn.iit.models;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "ligne_facture")
@Data
@ToString
public class LigneFactureEntity implements Serializable {

	private static final long serialVersionUID = -7507840055643841153L;

	@EmbeddedId
	private LigneFactureKey id;

	@ManyToOne
	@JoinColumn(name = "facture_id", insertable = false, updatable = false)
	private FactureEntity facture;

	@ManyToOne
	@JoinColumn(name = "produit_id", insertable = false, updatable = false)
	private ProduitEntity produit;

	private double quantite;
}
