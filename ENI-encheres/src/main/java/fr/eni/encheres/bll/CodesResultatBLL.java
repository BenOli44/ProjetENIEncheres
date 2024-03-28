package fr.eni.encheres.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	//Pour chaque erreur ajouter une ligne (Constante numérotée), les récupérer dans la servlet et afficher dans la jsp
	/**
	 * Echec le pseudo ne respect pas les règles défini
	 */
	public static final int PSEUDO_KO = 20000;
	public static final int PSEUDO_CARACT_SPEC = 20001;
	/**
	 * Echec l'email ne respect pas les règles défini
	 */
	public static final int EMAIL_KO = 20002;
	public static final int EMAIL_FORMAT = 20003;
	/**
	 * Le téléphone ne respect pas les règles défini
	 */
	public static final int TELEPHONE_FORMAT = 20004;
	/**
	 * Le Code Postal ne respect pas les règles défini
	 */
	public static final int CODEPOSTAL_KO = 20005;
	public static final int CODEPOSTAL_FORMAT = 20006;
	/**
	 * Le nom doit être défini
	 */
	public static final int NOM_KO = 20007;
	/**
	 * Le prénom doit être défini
	 */
	public static final int PRENOM_KO = 20008;
	/**
	 * Le mot de passe doit être défini
	 */
	public static final int MOTDEPASSE_KO = 20009;
	/**
	 * La rue doit être défini
	 */
	public static final int RUE_KO = 20010;
	/**
	 * La ville doit être défini
	 */
	public static final int VILLE_KO = 20011;
}
