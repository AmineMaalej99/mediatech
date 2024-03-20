package tn.iit.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9010543033194060512L;
	@Id
	@GeneratedValue
	private Integer id;

	private String avatar;

	private String telephone;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
