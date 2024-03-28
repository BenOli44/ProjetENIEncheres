package fr.eni.encheres.servlets;
import java.io.IOException;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager;

	@Override
	public void init() throws ServletException {
		utilisateurManager = new UtilisateurManager();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String motDePasseConfirme = request.getParameter("motDePasseConfirme");
		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		
		 try {
	            
	            utilisateurManager.inscrireUtilisateur(utilisateur);
	            HttpSession session = request.getSession();
	            session.setAttribute("utilisateur", utilisateur);
	            response.sendRedirect(request.getContextPath() + "/encheres");
	            
	        } catch (BusinessException e) {
	          
	            request.setAttribute("erreur", e.getListeCodesErreur());
	            request.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(request, response);
	        }	
	}
}