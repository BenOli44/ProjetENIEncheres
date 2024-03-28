package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Categorie manager gere la partie metier pour la categorie
 */
public class CategorieManager {
	private static CategorieManager instance;
	private CategorieDAO categorieDAO;

	/**
	 * Constructeur
	 */
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}

	/**
	 * Méthode pour obtenir l'instance unique de CategorieManager. Utilise la
	 * synchronisation pour garantir la sécurité dans un environnement multi-thread.
	 * 
	 * @return L'instance unique de CategorieManager.
	 */
	public static synchronized CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

	/**
	 * Methode pour récuperer la listes de tous les articles
	 * 
	 * @return La liste des articles
	 * @throws BusinessException
	 */
	public List<Categorie> getListeCategories() throws BusinessException {
		return this.categorieDAO.selectAll();
	}

	/**
	 * Methode pour récuperer une categorie suivant son Id
	 * @param IdCategorie
	 * @return un objet Categorie
	 * @throws BusinessException
	 */
	public Categorie getCategorie(int IdCategorie) throws BusinessException {
		return this.categorieDAO.selectById(IdCategorie);

	}
}
