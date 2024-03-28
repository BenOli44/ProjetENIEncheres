package fr.eni.encheres.dal;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * interface pour la UtilisateurDAO
 */
public interface UtilisateurDAO {
	/**
	 * inserer un utilisateur en BDD
	 * @param Utilisateur
	 * @throws BusinessException
	 */
	public void insert(Utilisateur Utilisateur) throws BusinessException;

	/**
	 * supprimer un utilisateur suivant l'id
	 * @param id
	 * @throws BusinessException
	 */
	public void delete(int id) throws BusinessException;
	
	/**
	 * modifier l'utilisateur enBDD
	 * @param Utilisateur
	 * @throws BusinessException
	 */
	public void update(Utilisateur Utilisateur) throws BusinessException;
	
	/**
	 *  selectionne un utilisateur by id
	 * @param id
	 * @return utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur selectById(int id) throws BusinessException;

	// ajout par Dorothée pour pouvoir récupérer le pseudo ou l'email de l'utilisateur
	/**
	 * selectionne l'utiilisateur par le pseudo
	 * @param Pseudo
	 * @param motDePasse
	 * @return utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur selectByPseudo(String Pseudo, String motDePasse) throws BusinessException;

	/**
	 * selectionne l'utilisateur par le email
	 * @param Email
	 * @param motDePasse
	 * @return utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur selectByEmail(String Email, String motDePasse) throws BusinessException;

	// ajout par Jérôme pour le contrôle d'unicité du pseudo et de l'email
	// boolean pseudoExiste(String pseudo) throws BusinessException;
	// boolean emailExiste(String email) throws BusinessException;
}
