package fr.eni.encheres.bo;

/**
 * classe pour la utilisateur
 */
public class Utilisateur {
	
	private int idUtilisateur;
	private String pseudo, nom, prenom, email, telephone;
	private String rue, codePostal, ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;
	
	/**
	 * Constructeur
	 */
	public Utilisateur() {
	}

	/** 
	 * Constructeur utilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
				String codePostal, String ville, String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}

	/**
	 * Constructeur utilisateur
	 * @param idUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(int idUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	/**
	 * getPseudo
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * setPseudo
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * getNom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * setNom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * getPrenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * setPrenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * getEmail
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getTelephone
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * setTelephone
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * getRue
	 * @return rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * setRue
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * getCodePostal
	 * @return codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * setCodePostal
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * getVille
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * setVille
	 * @param ville 
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * getMotDePasse
	 * @return motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * setMotDePasse
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * getCredit
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * setCredit
	 * @param credit
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * getIdUtilisateur
	 * @return idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * setIdUtilisateur
	 * @return idUtilisateur
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * isAdministrateur
	 * @return administrateur
	 */
	public boolean isAdministrateur() {
		return administrateur;
	}
	
	/**
	 * setAdministrateur
	 * @param administrateur 
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public boolean contains(String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
