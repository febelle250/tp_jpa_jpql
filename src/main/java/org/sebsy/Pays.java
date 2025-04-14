package org.sebsy;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String nom;
	
	@ManyToMany
	@JoinTable(name="film_pays", joinColumns = { @JoinColumn(name = "id_pays") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_film") } )
	private Set<Film> films = new HashSet<>();
	
	public Pays() {

	}
	public Pays(String nom) {
		super();
		this.nom = nom;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(nom).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pays)) {
			return false;
		}
		Pays autre = (Pays)obj;
		return new EqualsBuilder().append(nom, autre.getNom()).isEquals();
	}
	
	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter pour films
	 * @return the films
	 */
	public Set<Film> getFilms() {
		return films;
	}
	/** Setter pour films
	 * @param films the films to set
	 */
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	

}