package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.UtilisateurDAO;

/*
 * Classe pour implementer l'interface d'utilisateurDAO et pouvoir recupérer les informations conernant les articles de la BDD
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ? and mot_de_passe = ?";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email = ? and mot_de_passe = ?";
	private static final String SELECT_BY_ID = "select * from utilisateurs where id_utilisateur = ?";
	private static final String INSERT = "insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_PROFIL = "update utilisateurs set pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? where id_utilisateur = ?";
	private static final String DELETE = "delete from utilisateurs where id_utilisateur = ?;";

	/**
	 * inserer un utilisateur
	 * @param utilisateur à inserer en BDD
	 */
	public void insert(Utilisateur utilisateur) throws BusinessException {

		if (utilisateur == null) {

			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_USER_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {

		    ResultSet rs = null;
		    
		    try {
		        cnx.setAutoCommit(false);
		        PreparedStatement pstmt;
		        
		        if (utilisateur.getIdUtilisateur() == 0) {
		            pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
		            pstmt.setString(1, utilisateur.getPseudo());
		            pstmt.setString(2, utilisateur.getNom());
		            pstmt.setString(3, utilisateur.getPrenom());
		            pstmt.setString(4, utilisateur.getEmail());
		            pstmt.setString(5, utilisateur.getTelephone());
		            pstmt.setString(6, utilisateur.getRue());
		            pstmt.setString(7, utilisateur.getCodePostal());
		            pstmt.setString(8, utilisateur.getVille());
		            pstmt.setString(9, utilisateur.getMotDePasse());
		            pstmt.setInt(10, 100);
		            pstmt.setBoolean(11, false);
		            pstmt.executeUpdate();

					rs = pstmt.getGeneratedKeys();
					if (rs.next()) {
						utilisateur.setIdUtilisateur(rs.getInt(1));
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

	/**
	 * Modifier un utilisateur en BDD
	 * @param utilisateur à modifier
	 */
	public void update(Utilisateur utilisateur) throws BusinessException {

		if (utilisateur == null || utilisateur.getIdUtilisateur() == 0) {

			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_PROFIL_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);

				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_PROFIL);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, utilisateur.getIdUtilisateur());

				pstmt.executeUpdate();

				cnx.commit();

			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;

			} finally {

			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_PROFIL_FAIL);
			throw businessException;
		}
	}

	/**
	 * supprimer un utilisateur suivant son id
	 * @param identifiant de l'utilisateur à supprimer
	 */
	public void delete(int id) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_UTILISATEUR_ERREUR);
			throw businessException;
		}
	}

	/**
	 * selectionne l'utilisateur by pseudo
	 * @param pseudo de l'utilisateur
	 * @param motDePasse de l'utilisateur
	 * @return Utilisateur seltionner suivant le pseudo
	 */
	public Utilisateur selectByPseudo(String pseudo, String motDePasse) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection())

		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);

			pstmt.setString(1, pseudo);
			pstmt.setString(2, motDePasse);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return new Utilisateur(rs.getInt("id_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}

	/**
	 * selectionne l'utilisateur byid
	 * @param idUtilisateur
	 * @return utilisateur selectionné suivant son id
	 */
	public Utilisateur selectById(int idUtilisateur) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, idUtilisateur);
			ResultSet rs = pstmt.executeQuery();
			boolean premiereLigne = true;
			while (rs.next()) {
				if (premiereLigne) {
					utilisateur.setIdUtilisateur(idUtilisateur);
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setRue(rs.getString("rue"));
					utilisateur.setCodePostal(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
					premiereLigne = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * selectionne l'utilisateur by email
	 * @param email de l'utilisateur
	 * @param motDePasse de l'utilisateur
	 * @return Utilisateur seltionner suivant le email
	 */
	public Utilisateur selectByEmail(String email, String motDePasse) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_EMAIL);

			pstmt.setString(1, email);
			pstmt.setString(2, motDePasse);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return new Utilisateur(rs.getInt("id_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
		/*
		 * BusinessException businessException = new BusinessException();
		 * businessException.ajouterErreur(CodesResultatDAL.SELECT_UTILISATEUR_ECHEC);
		 * throw businessException;
		 * 
		 * if(utilisateur.getIdUtilisateur()==0) { BusinessException businessException =
		 * new BusinessException(); businessException.ajouterErreur(CodesResultatDAL.
		 * SELECT_UTILISATEUR_INEXISTANT); throw businessException; }
		 * 
		 * return utilisateur;
		 */
	}
}
