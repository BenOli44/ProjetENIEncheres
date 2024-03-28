package fr.eni.encheres.bo;

/**
 * classe pour la categorie
 */
public class Categorie {
	private int idCategorie;
	private String libelle;
	
	/**
	 * Constructeur pour Categorie
	 */
	public Categorie() {
		super();
	}

	/**
	 * Constructeur pour categorie
	 * @param libelle
	 */
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	/**
	 * Constructeur pour categorie
	 * @param idCategorie
	 * @param libelle
	 */
	public Categorie(int idCategorie, String libelle) {
		super();
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}

	/**
	 * getIdCategorie
	 * @return idCategorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}
	
	/**
	 * setIdCategorie
	 * @param idCategorie
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	/**
	 * getLibelle
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * setLibelle
	 * @param libelle 
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
