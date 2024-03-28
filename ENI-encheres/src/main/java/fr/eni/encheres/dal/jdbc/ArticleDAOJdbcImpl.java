package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;

/*
 * Classe pour implementer l'interface d'ArticleDAO et pouvoir recupérer les informations conernant les articles de la BDD
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {
	private static final String SQL_SELECT_BY_ID = "select * from ARTICLES where id_article = ?";
	private static final String SQL_SELECT_ALL_EN_COURS = "select * from ARTICLES WHERE date_debut_encheres < GETDATE() AND date_fin_encheres > GETDATE();";
	private static final String SQL_INSERT = "insert into ARTICLES(nom_article,description,date_debut_encheres,"
			+ "date_fin_encheres,prix_initial,prix_vente,id_utilisateur,id_categorie,rue_retrait,code_postal_retrait,"
			+ "ville_retrait) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "update ARTICLES set nom_article=?,description=?,date_debut_encheres=?,"
			+ "date_fin_encheres=?,prix_initial=?,prix_vente=?,id_utilisateur=?,id_categorie=?,rue_retrait=?,code_postal_retrait=?,ville_retrait=? where id_article=?";
	private static final String SQL_SELECT_ALL_EN_COURS_BY_FILTRE_CATEGORIE = "select * from ARTICLES where nom_article LIKE ? and id_categorie = ? and date_debut_encheres < GETDATE() AND date_fin_encheres > GETDATE();";
	private static final String SQL_SELECT_ALL_EN_COURS_BY_FILTRE = "select * from ARTICLES where nom_article LIKE ? and date_debut_encheres < GETDATE() AND date_fin_encheres > GETDATE();";
	private static final String SQL_SELECT_ALL_EN_COURS_BY_CATEGORIE = "select * from ARTICLES where id_categorie = ? and date_debut_encheres < GETDATE() AND date_fin_encheres > GETDATE();";

	// TODO à tester
	// TODO à reprendre
	public Article selectById(int idArticle) throws BusinessException {
		Article article = new Article();
//		// Utilisation de java.lang.AutoCloseable et try-with-resources
//		try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);) {
//			rqt.setInt(1, idArticle);
//
//			try (ResultSet rs = rqt.executeQuery();) {
//				if (rs.next()) {
//					article = new Article(rs.getInt("id_article"),
//							rs.getString("nom_article"),
//							rs.getString("description").trim(),
//							rs.getDate("date_debut_encheres"),
//							rs.getDate("date_fin_encheres"), 
//							rs.getInt("prix_initial"), 
//							rs.getInt("prix_vente"),
//							rs.getString("prix_vente"));
//				}
//			}
//		} catch (SQLException e) {
//			throw new DALException("selectById failed - id = " + idArticle, e);
//		}
//		Article article = new Article();
		return article;
	}

	/**
	 * Récupere tous les articles de la BDD en cours d'encheres
	 * @return liste articles
	 */
	public List<Article> selectAllEnCours() throws BusinessException {
		List<Article> listeArticles = new ArrayList<Article>();
		try (Connection cnx = ConnectionProvider.getConnection(); Statement stmt = cnx.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_EN_COURS);) {
				creationListArticlesSuivantResultSet(rs, listeArticles);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLES_ECHEC);
			throw businessException;
		}
		return listeArticles;
	}

	// TODO à tester
	/**
	 * inserer un article en BDD
	 * @param article
	 */
	public void insert(Article article) throws BusinessException {

		if (article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {

	    	ResultSet rs = null;
	    	
		    try {   
		    		cnx.setAutoCommit(false);
		    		
		    		PreparedStatement pstmt;
		    		
		        
		    		if (article.getIdArticle() == 0) {
		    			
		            pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		            
		            pstmt.setString(1, article.getNomArticle());
		            pstmt.setString(2, article.getDescription());
		            pstmt.setDate(3, (Date) article.getDateDebutEncheres());
		            pstmt.setDate(4, (Date) article.getDateFinEncheres());
		            pstmt.setInt(5, article.getMiseAPrix());
		            pstmt.setInt(6, article.getPrixVente());
		            pstmt.setInt(7, article.getUtilisateur().getIdUtilisateur());
	
		            pstmt.setInt(8, article.getCategorie().getIdCategorie());
	
		            pstmt.setString(9, article.getRueRetrait());
		            pstmt.setString(10, article.getCodePostalRetrait());
		            pstmt.setString(11, article.getVilleRetrait());
		            pstmt.executeUpdate();

					rs = pstmt.getGeneratedKeys();

					if (rs.next()) {
						article.setIdArticle(rs.getInt(1));
					}
				}

				cnx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;

			} finally {

				if (rs != null) {
					rs.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	// TODO à tester
	// TODO à reprendre
	/**
	 * Modifier un article en BDD
	 * @param article à modifier
	 */
	public void update(Article article) throws BusinessException {
		
//		 try(Connection cnx = ConnectionProvider.getConnection(); PreparedStatement rqt = cnx.prepareStatement(SQL_UPDATE);) {
//			 rqt.setString(1,article.getReference());
//			 rqt.setString(2, article.getMarque());
//		  rqt.setString(3, article.getDesignation());
//		  rqt.setFloat(4, article.getPrixUnitaire());
//		  rqt.setInt(5, article.getQteStock());
//		  rqt.setInt(8, article.getIdArticle());
//		  
//		  rqt.executeUpdate();
//		  
//		  } catch (SQLException e) {
//			  throw new DALException("Update article failed - " + article, e); 
//			  }
	}

	/**
	 * selectionner les articles en cours d'encheres suivant un filte et categorie
	 * @param filtreNomArticle filtre sur le nom d'article
	 * @param categorieId filtre sur une des categorie
	 * @return liste d'articles en cours d'encheres suivant un filte et categorie 
	 */
	public List<Article> selectArticlesEnCoursByFiltreAndCategorie(String filtreNomArticle, Integer categorieId) throws BusinessException {
		List<Article> listeArticles = new ArrayList<Article>();
		try (Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL_EN_COURS_BY_FILTRE_CATEGORIE);) {
			pstmt.setString(1, '%' + filtreNomArticle + '%');
			pstmt.setInt(2, categorieId);
			try (ResultSet rs = pstmt.executeQuery();) {
				//appel d'une methode qui crée la liste d'article suivant le resultset
				creationListArticlesSuivantResultSet(rs, listeArticles);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLES_ECHEC);
			throw businessException;
		}
		return listeArticles;
	}
	
	/**
	 * selectionner les articles en cours d'encheres suivant un filte
	 * @param filtreNomArticle filtre sur le nom d'article
	 * @return liste d'articles en cours d'encheres suivant un filte
	 */
	public List<Article> selectArticlesEnCoursByFiltre(String filtreNomArticle) throws BusinessException {
		List<Article> listeArticles = new ArrayList<Article>();
		try (Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL_EN_COURS_BY_FILTRE);) {
			pstmt.setString(1, '%' + filtreNomArticle + '%');
			try (ResultSet rs = pstmt.executeQuery();) {
				//appel d'une methode qui crée la liste d'article suivant le resultset
				creationListArticlesSuivantResultSet(rs, listeArticles);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLES_ECHEC);
			throw businessException;
		}
		return listeArticles;
	}

	/**
	 * selectionner les articles en cours d'encheres suivant une categorie
	 * @param categorieId filtre sur une des categorie
	 * @return liste d'articles en cours d'encheres suivant une categorie 
	 */
	public List<Article> selectArticlesEnCoursByCategorie(Integer categorieId) throws BusinessException {
		List<Article> listeArticles = new ArrayList<Article>();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL_EN_COURS_BY_CATEGORIE);) {
			pstmt.setInt(1, categorieId);
			try (ResultSet rs = pstmt.executeQuery();) {
				creationListArticlesSuivantResultSet(rs, listeArticles);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLES_ECHEC);
			throw businessException;
		}
		return listeArticles;
	}
	
	/**
	 * creation d'une liste article suivant un resultset de la BDD
	 * @param rs : resulset
	 * @param listeArticles (quel quel soit)
	 * @throws SQLException
	 * @throws BusinessException
	 */
	private void creationListArticlesSuivantResultSet(ResultSet rs, List<Article> listeArticles) throws SQLException, BusinessException {
		Article article = new Article();
		while (rs.next()) {
			article = new Article(rs.getInt("id_article"),
					rs.getString("nom_article"),
					rs.getString("description").trim(),
					rs.getDate("date_debut_encheres"),
					rs.getDate("date_fin_encheres"),
					rs.getInt("prix_initial"),
					rs.getInt("prix_vente"),
					(new UtilisateurDAOJdbcImpl()).selectById(rs.getInt("id_utilisateur")),
					(new CategorieDAOJdbcImpl()).selectById(rs.getInt("id_categorie")),
					rs.getString("rue_retrait"),
					rs.getString("code_postal_retrait"),
					rs.getString("ville_retrait"));
			listeArticles.add(article);
		}
	}
}
