package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Article manager gere la partie metier pour l'article
 */
public class ArticleManager {

	private static ArticleManager instance = new ArticleManager();
	private ArticleDAO articleDAO;

	public ArticleManager(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	/**
	 * Constructeur
	 */
		public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	/**
	 * getInstance permet obtenir l'instance unique de ArticleManager. Utilise la
	 * synchronisation pour garantir la sécurité dans un environnement multi-thread.
	 * 
	 * @return L'instance unique de ArticleManager.
	 */
	public static synchronized ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}

	/**
	 * getListeArticles pour récuperer la listes de tous les articles
	 * 
	 * @return La liste des articles
	 * @throws BusinessException
	 */
	public List<Article> getListeArticles() throws BusinessException {
		return this.articleDAO.selectAllEnCours();
	}

	/**
	 * creationArticle
	 * 
	 * @param article
	 * @throws BusinessException
	 */
	public void creationArticle(Article article) throws BusinessException {
    	// Ajout de l'utilisateur à la base de données
		articleDAO.insert(article);
	}

	/**
	 * Methode pour récuperer la listes de tous les articles filtre par cetgorie et filtre
	 * 
	 * @param categorie, filtreNomArticle
	 * @return La liste des articles
	 * @throws BusinessException
	 */
	public List<Article> getListeArticlesByCategorieAndFiltres(String categorie, String filtreNomArticle)
			throws BusinessException {
		List<Article> listeArticles = new ArrayList<Article>();
		if (categorie.equals("Toutes") && filtreNomArticle.equals("")) {
			listeArticles = this.articleDAO.selectAllEnCours();
		} else if (categorie.equals("Toutes") && !filtreNomArticle.equals("")) {
			listeArticles = this.articleDAO.selectArticlesEnCoursByFiltre(filtreNomArticle);
		} else if (!categorie.equals("Toutes") && filtreNomArticle.equals("")) {
			Integer categorieId = Integer.parseInt(categorie);
			listeArticles = this.articleDAO.selectArticlesEnCoursByCategorie(categorieId);
		} else if (!categorie.equals("Toutes") && !filtreNomArticle.equals("")) {
			Integer categorieId = Integer.parseInt(categorie);
			listeArticles = this.articleDAO.selectArticlesEnCoursByFiltreAndCategorie(filtreNomArticle, categorieId);
		}
		return listeArticles;
	}
}
