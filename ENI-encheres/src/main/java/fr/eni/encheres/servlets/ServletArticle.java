package fr.eni.encheres.servlets;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletArticle
 */
@WebServlet("/article")
public class ServletArticle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ArticleManager articleManager;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession session = request.getSession();
		 	Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
						
	    
			CategorieManager categorieManager = CategorieManager.getInstance();
			List<Categorie> listeCategories = new ArrayList<Categorie>();
			listeCategories = categorieManager.getListeCategories();
			request.setAttribute("listeCategories", listeCategories);
			
			request.getRequestDispatcher("/WEB-INF/pages/article.jsp").forward(request, response);
			
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
		}
		
			
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
				 try {
					 	// Récupération des champs du formulaire
					 	
					 	String nomArticle = request.getParameter("nomArticle");
						String description = request.getParameter("description");
						String dateDebutEncheres = request.getParameter("dateDebutEncheres");
						String dateFinEncheres = request.getParameter("dateFinEncheres");
						int    miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
						Integer idCategorie = Integer.parseInt(request.getParameter("categorie"));
						String rueRetrait = request.getParameter("rueRetrait");
						String codePostalRetrait = request.getParameter("codePostalRetrait");
						String villeRetrait = request.getParameter("villeRetrait");
								
			            
					 	Date dateDebutEncheresConvertie = Date.valueOf(dateDebutEncheres);
					 	Date dateFinEncheresConvertie = Date.valueOf(dateFinEncheres);
					 
					 	HttpSession session = request.getSession();
					 	Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
					 	CategorieManager categorieManager = CategorieManager.getInstance();
					 	Categorie categorie = categorieManager.getCategorie(idCategorie);
						
					 	ArticleManager articleManager = ArticleManager.getInstance();
						
					 	
					 	Article article = new Article(nomArticle, description, dateDebutEncheresConvertie, dateFinEncheresConvertie, miseAPrix, null, utilisateur, categorie, rueRetrait, codePostalRetrait, villeRetrait);

					 	
						articleManager.creationArticle(article);
					 	
					 	
			            session.setAttribute("article", article);
			            response.sendRedirect(request.getContextPath() + "/encheres");
			         
			            
			        } catch (BusinessException e) {
			        	e.printStackTrace(); 
			            request.setAttribute("erreur", ((BusinessException) e).getListeCodesErreur());
			            response.sendRedirect(request.getContextPath() + "/encheres");
			        }	
				 
			}

				 	
				 
				 
}

	
	






