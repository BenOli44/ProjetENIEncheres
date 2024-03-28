package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;

/*
 * Classe pour implementer l'interface categorieDAO et pouvoir recupérer les informations conernant les categories de la BDD
 */
public class CategorieDAOJdbcImpl implements CategorieDAO {
	private static final String SQL_SELECT_BY_ID = "select * from CATEGORIES where id_categorie = ?";
	private static final String SQL_SELECT_ALL = "select * from CATEGORIES";

	/**
	 * Selectionne la categorie by id
	 * @param id_categorie
	 * @return Categorie
	 */
	public Categorie selectById(int id_categorie) throws BusinessException {
		Categorie categorie = new Categorie();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, id_categorie);
			ResultSet rs = pstmt.executeQuery();
			boolean premiereLigne=true;
			while(rs.next())
			{
				if(premiereLigne)
				{
					categorie.setIdCategorie(id_categorie);
					categorie.setLibelle(rs.getString("libelle"));
				
					premiereLigne=false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_CATEGORIE_ECHEC);
			throw businessException;
		}
		if(categorie.getIdCategorie()==0)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_CATEGORIE_INEXISTANT);
			throw businessException;
		}
		
		return categorie;
	}
	
	/**
	 * Récupere tous les Categories de la BDD
	 * @return liste de toutes les categories
	 */
	public List<Categorie> selectAll() throws BusinessException {
		List<Categorie> listeCategories = new ArrayList<Categorie>();
		try (Connection cnx = ConnectionProvider.getConnection(); Statement stmt = cnx.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);) {
				while (rs.next()) {
					Categorie categorie = new Categorie(rs.getInt("id_categorie"),rs.getString("libelle"));
					listeCategories.add(categorie);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_CATEGORIE_ECHEC);
			throw businessException;
		}
		return listeCategories;
	}
}
