package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.BusinessException;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Categorie;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/encheres")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			// Obtenez l'instance unique de ArticleManager pour récuperer la liste des articles
			ArticleManager articleManager = ArticleManager.getInstance();
			List<Article> listeArticles = new ArrayList<Article>();
			HttpSession session = request.getSession();
			if (session.getAttribute("listeArticles") != null) {
				listeArticles = (List<Article>) session.getAttribute("listeArticles");
			} else {
				listeArticles = articleManager.getListeArticles();
			}
			request.setAttribute("listeArticles", listeArticles);

			// Obtenez l'instance unique de ArticleManager pour récuperer la liste des articles
			CategorieManager categorieManager = CategorieManager.getInstance();
			List<Categorie> listeCategories = new ArrayList<Categorie>();
			listeCategories = categorieManager.getListeCategories();
			request.setAttribute("listeCategories", listeCategories);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Récupération des champs du formulaire
			String filtre = request.getParameter("filtre");
			String categorie = request.getParameter("categorie");
			ArticleManager articleManager = ArticleManager.getInstance();
			List<Article> listeArticles = new ArrayList<Article>();
			listeArticles = articleManager.getListeArticlesByCategorieAndFiltres(categorie, filtre);
			HttpSession session = request.getSession();
			session.setAttribute("listeArticles", listeArticles);
			response.sendRedirect(request.getContextPath() + "/encheres");
		} catch (BusinessException e) {
			request.setAttribute("erreur", e.getListeCodesErreur());
			request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
		}
	}
}
