package fr.eni.encheres.bo;

import java.sql.Date;

/**
 * classe pour l'article
 */
public class Article {
	private int idArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private Integer prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	private String rueRetrait;
	private String codePostalRetrait;
	private String villeRetrait;
		
	/**
	 * constructeur pour l'article
	 */
	public Article() {
	}
	
	/**
	 * Contructeur avec parametres suivants
	 * @param idArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param utilisateur
	 * @param categorie
	 * @param rueRetrait
	 * @param codePostalRetrait
	 * @param villeRetrait
	 */
	public Article(int idArticle, String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,
			int miseAPrix, Integer prixVente, Utilisateur utilisateur, Categorie categorie, String rueRetrait, String codePostalRetrait, String villeRetrait) {
		this(nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, utilisateur, categorie, rueRetrait, codePostalRetrait, villeRetrait);
		this.idArticle = idArticle;
	}
	
	/**
	 * Contructeur avec parametres suivants
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param utilisateur
	 * @param categorie
	 * @param rueRetrait
	 * @param codePostalRetrait
	 * @param villeRetrait
	 */
	public Article(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres,	int miseAPrix, 
			Integer prixVente, Utilisateur utilisateur, Categorie categorie, String rueRetrait, String codePostalRetrait, String villeRetrait) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.rueRetrait = rueRetrait;
		this.codePostalRetrait = codePostalRetrait;
		this.villeRetrait = villeRetrait;
	}
	
	/**
	 * GetIdArticle
	 * @return idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}
	
	/**
	 * SetIdArticle
	 * @param idArticle 
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	/**
	 * getNomArticle
	 * @return nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}
	
	/**
	 * setNomArticle
	 * @param nomArticle 
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	/**
	 * getDescription
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * setdescription
	 * @param description 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * getDateDebutEncheres
	 * @return dateDebutEncheres
	 */
	public Date getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	/**
	 * SetDateDebutEncheres
	 * @param dateDebutEncheres 
	 */
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	/**
	 * getDateFinEncheres
	 * @return the dateFinEncheres
	 */
	public Date getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	/**
	 * getDateFinEncheres
	 * @param dateFinEncheres 
	 */
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	/**
	 * getMiseAPrix
	 * @return miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	/**
	 * setMiseAPrix
	 * @param miseAPrix
	 */
	
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	/**getPrixVente
	 * @return prixVente
	 */
	public int getPrixVente() {
		int prixVenteInt=(prixVente != null) ? prixVente : 0;
		return prixVenteInt;
	}
	
	/**
	 * setPrixVente
	 * @param prixVente
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	/**
	 * getUtilisateur
	 * @return utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	/**
	 * setUtilisateur
	 * @param utilisateur
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	/**
	 * getCategorie
	 * @return categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	
	/** setCategorie
	 * @param categorie
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/**
	 * getRueRetrait
	 * @return rueRetrait
	 */
	public String getRueRetrait() {
		return rueRetrait;
	}
	
	/**
	 * setRueRetrait
	 * @param rueRetrait
	 */
	public void setRueRetrait(String rueRetrait) {
		this.rueRetrait = rueRetrait;
	}
	
	/**
	 * getCodePostalRetrait
	 * @return codePostalRetrait
	 */
	public String getCodePostalRetrait() {
		return codePostalRetrait;
	}
	
	/**
	 * setCodePostalRetrait
	 * @param codePostalRetrait
	 */
	public void setCodePostalRetrait(String codePostalRetrait) {
		this.codePostalRetrait = codePostalRetrait;
	}
	
	/**
	 * getVilleRetrait
	 * @return villeRetrait
	 */
	public String getVilleRetrait() {
		return villeRetrait;
	}
	
	/**
	 * setVilleRetrait
	 * @param villeRetrait 
	 */
	public void setVilleRetrait(String villeRetrait) {
		this.villeRetrait = villeRetrait;
	}
}
