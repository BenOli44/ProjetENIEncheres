package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	/**
	 * Echec général quand tentative d'ajouter un utilisateur null
	 */
	public static final int INSERT_USER_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=10001;
		
	/**
	 * Erreur à la suppression d'un utilisateur
	 */
	public static final int SUPPRESSION_UTILISATEUR_ERREUR = 10006;
	
	/**
	 * Echec lors du select d'une categorie
	 */
	public static final int SELECT_CATEGORIE_ECHEC = 10007;
	
	/**
	 * Categorie inexistant
	 */
	public static final int SELECT_CATEGORIE_INEXISTANT = 10008;
	
	/**
	 * Echec lors du select des articles
	 */
	public static final int SELECT_ARTICLES_ECHEC = 10009;
	
	/**
	 * Echec général quand erreur non gérée à la mise à jour sur un cas de null
	 */
	public static final int UPDATE_PROFIL_NULL = 10010;
	
	/**
	 * Echec général quand erreur non gérée à la mise à jour 
	 */
	public static final int UPDATE_PROFIL_FAIL = 10011;
	
	/**
	 * Echec général quand un objet est null 
	 */
	public static final int INSERT_OBJET_NULL = 10012;
}












