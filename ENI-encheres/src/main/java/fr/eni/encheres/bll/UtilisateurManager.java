package fr.eni.encheres.bll;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Utilisateur manager gere la partie metier pour l'article
 */
public class UtilisateurManager {
	private static UtilisateurManager instance = new UtilisateurManager();
	private UtilisateurDAO utilisateurDAO;

	/**
	 * Constructeur qui permet d'initialiser la variable membre utilisateurDAO pour
	 * permettre une communication avec la base de données modifier en fonction de
	 * la vidéo Démonstration - L'intégration dans le pattern DAO (module 4 JEE)
	 * 
	 * @param utilisateurDAO
	 */
	public UtilisateurManager(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	/**
	 * Constructeur
	 */
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	/**
	 * recuperation de l'instance de ce manager
	 * @return instance
	 */
	public static UtilisateurManager getInstance() {
		return instance;
	}

	/**
	 * getutilisateur suivant l'id
	 * @param idUtilisateur
	 * @return utilisateur
	 * @throws BusinessException
	 */

	public Utilisateur getUtilisateur(int idUtilisateur) throws BusinessException {
		return this.utilisateurDAO.selectById(idUtilisateur);
	}

	// TODO revoir partie exceptions
	/**
	 * connexion qu site web
	 * @param identifiant
	 * @param motDePasse
	 * @return utilisateur qui s'est connecté
	 * @throws Exception
	 */
	public Utilisateur connexion(String identifiant, String motDePasse) throws Exception {

		Utilisateur utilisateur = new Utilisateur();

		if (identifiant.contains("@")) {
			utilisateur = DAOFactory.getUtilisateurDAO().selectByEmail(identifiant, motDePasse);

		} else {
			utilisateur = DAOFactory.getUtilisateurDAO().selectByPseudo(identifiant, motDePasse);
		}
		if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
				return utilisateur;	
					
		 } else {
			 throw new Exception ("Identifiant ou mot de passe erroné");
		 }
	}
		
	/**
	 * Verification données utilisateur
	 * @param utilisateur
	 * @throws BusinessException
	 */
	private void verifDonneesUtilisateur(Utilisateur utilisateur) throws BusinessException {
		BusinessException businessException = new BusinessException();

	    if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty()) {
	        businessException.ajouterErreur(CodesResultatBLL.PSEUDO_KO);
	    }
	    if (utilisateur.getPseudo().matches("[A-Za-z0-9]") ) {
	        businessException.ajouterErreur(CodesResultatBLL.PSEUDO_CARACT_SPEC); 
	    }
	    if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
	    	businessException.ajouterErreur(CodesResultatBLL.PRENOM_KO);
	    }
	    if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()) {
	        businessException.ajouterErreur(CodesResultatBLL.NOM_KO);
	    }
	    if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().isEmpty()) {
	    	businessException.ajouterErreur(CodesResultatBLL.CODEPOSTAL_KO);
	    }
	    if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isEmpty()) {
	    	businessException.ajouterErreur(CodesResultatBLL.MOTDEPASSE_KO);
	    }
	    if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
	        businessException.ajouterErreur(CodesResultatBLL.EMAIL_KO);
	    }
	    if (utilisateur.getRue() == null || utilisateur.getRue().isEmpty()) {
	        businessException.ajouterErreur(CodesResultatBLL.RUE_KO);
	    }
	    if (utilisateur.getVille() == null || utilisateur.getVille().isEmpty()) {
	        businessException.ajouterErreur(CodesResultatBLL.VILLE_KO);
	    }
	    if (utilisateur.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
	        businessException.ajouterErreur(CodesResultatBLL.EMAIL_FORMAT);
	    }
	    if (utilisateur.getTelephone().matches("^(0|\\+33|0033)[1-9][0-9]{8}$")) {
	    	businessException.ajouterErreur(CodesResultatBLL.TELEPHONE_FORMAT);
	    }
	    if (utilisateur.getCodePostal().matches("^(F-)?((2[A|B])|[0-9]{2})[0-9]{3}$")) {
	        businessException.ajouterErreur(CodesResultatBLL.CODEPOSTAL_FORMAT); 
	    if (businessException.hasErreurs()) {
	        throw businessException;
	    }
	}
}
	
	/**
	 * inserer Utilisateur en base
	 * @param utilisateur
	 * @throws BusinessException
	 */
	public void inscrireUtilisateur(Utilisateur utilisateur) throws BusinessException {

		verifDonneesUtilisateur(utilisateur);
		utilisateurDAO.insert(utilisateur);
	}
	
	/**
	 * modifier l'utilisateur
	 * @param utilisateur
	 * @throws BusinessException
	 */
	public void mettreAJourUtilisateur(Utilisateur utilisateur) throws BusinessException {

		verifDonneesUtilisateur(utilisateur);
		utilisateurDAO.update(utilisateur);
	}
	
	/**
	 * recuperer la rue de l'utilisateur pour la rue de retrait d'un article à vendre
	 * @param utilisateur
	 * @return string qui est la rue
	 * @throws BusinessException
	 */
	public String getRueUtilisateur(Utilisateur utilisateur) throws BusinessException {

		return utilisateur.getRue();
	}

	/**
	 * recuperer le code postal de l'utilisateur pour le code postal de retrait d'un article à vendre
	 * @param utilisateur
	 * @return string qui est le code postal
	 * @throws BusinessException
	 */
	public String getCodePostalUtilisateur(Utilisateur utilisateur) throws BusinessException {

		return utilisateur.getCodePostal();
	}

	/**
	 * recuperer la ville de l'utilisateur pour le ville de retrait d'un article à vendre
	 * @param utilisateur
	 * @return string qui est la ville
	 * @throws BusinessException
	 */
	public String getVilleUtilisateur(Utilisateur utilisateur) throws BusinessException {

		return utilisateur.getVille();
	}
}
