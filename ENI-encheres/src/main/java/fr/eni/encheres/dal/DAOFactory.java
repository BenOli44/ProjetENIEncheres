package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Factory pour le projet pour permettre d'impement différents implementations
 */
public abstract class DAOFactory {
	/**
	 * getUtilisateurDAO
	 * @return utilisateurDAO
	 */
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	/**
	 * getArticleDAO
	 * @return ArticleDAO
	 */
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
	
	/**
	 * getCategorieDAO
	 * @return CategorieDAO
	 */
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
}