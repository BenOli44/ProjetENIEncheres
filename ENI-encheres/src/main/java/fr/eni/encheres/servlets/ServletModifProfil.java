package fr.eni.encheres.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletModifProfil
 */
@WebServlet("/modifProfil")
public class ServletModifProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/modifProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//Récupération des champs du formulaire pour mettre à jour les variables de l'utilisateur en session
				String pseudo = request.getParameter("newPseudo");
				String nom = request.getParameter("newNom");
				String prenom = request.getParameter("newPrenom");
				String email = request.getParameter("newEmail");
				String telephone = request.getParameter("newTelephone");
				String rue = request.getParameter("newRue");
				String codePostal = request.getParameter("newCodePostal");
				String ville = request.getParameter("newVille");
				String motDePasse = request.getParameter("newMotDePasse");
				String motDePasseConfirme = request.getParameter("motDePasseConfirme");
				
				try {
			        // Récupérer l'utilisateur depuis la session
			        HttpSession session = request.getSession();
			        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			        
			        utilisateurManager = new UtilisateurManager();

			        utilisateur.setPseudo(pseudo);
			        utilisateur.setNom(nom);
			        utilisateur.setPrenom(prenom);
			        utilisateur.setEmail(email);
			        utilisateur.setTelephone(telephone);
			        utilisateur.setRue(rue);
			        utilisateur.setCodePostal(codePostal);
			        utilisateur.setVille(ville);
			        utilisateur.setMotDePasse(motDePasse); 
			        
			        utilisateurManager.mettreAJourUtilisateur(utilisateur);

			        session.setAttribute("utilisateur", utilisateur);

			        response.sendRedirect(request.getContextPath() + "/profil");

			    } catch (BusinessException e) {
			        // Gérer les erreurs
			        request.setAttribute("erreur", e.getListeCodesErreur());
			        request.getRequestDispatcher("WEB-INF/pages/modifProfil.jsp").forward(request, response);
			    }
		}
  }

