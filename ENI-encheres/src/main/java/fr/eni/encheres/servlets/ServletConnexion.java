package fr.eni.encheres.servlets;

import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet ("/connexion")
public class ServletConnexion extends HttpServlet {
	private final static long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
					
		try {
						
						UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
											
						Utilisateur utilisateur = utilisateurManager.connexion(request.getParameter("identifiant"), request.getParameter("motDePasse"));
							
						HttpSession session = request.getSession();

						session.setAttribute("utilisateur", utilisateur);					
				
						response.sendRedirect("encheres");
					
					} catch (Exception e) {
						
						request.setAttribute("erreur", e.getMessage());
						doGet(request,response);
						
					}				

					}
		
	}		
		


	

	
	
	

