package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;

/**
 * interface pour l'articleDAO
 */
public interface ArticleDAO {
	
	/**
	 *  selectionne l'article en BDD by ID
	 * @param idArticle
	 * @return article
	 * @throws BusinessException
	 */
	public Article selectById(int idArticle) throws BusinessException;

	/**
	 *  Selectionne tous les articles en cours d'encheres
	 * @return Liste d'articles
	 * @throws BusinessException
	 */
	public List<Article> selectAllEnCours() throws BusinessException;
	
	/**
	 * Inserer un article en BDD
	 * @param article
	 * @throws BusinessException
	 */
	public void insert(Article article) throws BusinessException;
	
	/**
	 * Modifier l'article en BDD
	 * @param article
	 * @throws BusinessException
	 */
	public void update(Article article) throws BusinessException;
	
	/**
	 * Selecionnes les articles en cours d'encheres par filtre et par catégorie
	 * @param filtreNomArticle
	 * @param categorieId
	 * @return Liste d'articles
	 * @throws BusinessException
	 */
	public List<Article> selectArticlesEnCoursByFiltreAndCategorie(String filtreNomArticle, Integer categorieId) throws BusinessException;
	
	/**
	 * Selecionnes les articles en cours d'encheres par filtre 
	 * @param filtreNomArticle
	 * @return Liste d'articles
	 * @throws BusinessException
	 */
	public List<Article> selectArticlesEnCoursByFiltre(String filtreNomArticle) throws BusinessException;
	
	/**
	 * Selecionnes les articles en cours d'encheres par catégorie
	 * @param categorieId
	 * @return Liste d'articles
	 * @throws BusinessException
	 */
	public List<Article> selectArticlesEnCoursByCategorie(Integer categorieId) throws BusinessException;	
}