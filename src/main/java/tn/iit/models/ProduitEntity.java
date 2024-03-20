package tn.iit.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produits")
public class ProduitEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8912110507500323631L;
	/**
	 * 
	 */

	@Id
	private Integer id;

	@Column(nullable = false)
	private String libelle;

	@Column(nullable = false)
	private String ref;

	@Column(nullable = false)
	private BigDecimal prix;

	@Column(nullable = false)
	private double quantite_stock;

	@OneToMany(mappedBy = "produit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LigneFactureEntity> factureEntities;

}
