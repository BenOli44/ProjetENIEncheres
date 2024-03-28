<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<%@ page import="fr.eni.encheres.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<%@ include file="../fragments/head.html"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
<title>ENI-Enchères</title>
</head>

<body>
	<%@ include file="../fragments/header.html"%>
	<h2>Liste des enchères</h2>
	<div class="filtres container-fluid">
		<form action="" method="post">
			<div class="row">
				<h3>Filtres :</h3>
			</div>
			<div class="row">
				<div class="col-3">
					<input type="text" name="filtre" id="filtre" class="filtre" autofocus placeholder="Le nom de l'article contient" title="Saisissez une partie du nom de l'article" size="38">
					<br>
					<br> <label for="categorie">Categorie :</label> 
					<select name="categorie" id="categorie" class="categorie">
						<option value="Toutes">Toutes</option>
						<c:choose>
							<c:when test="${listeCategories.size()>0}">
								<c:forEach var="categorie" items="${listeCategories}">
									<option value="${categorie.idCategorie}">${categorie.libelle}</option>
								</c:forEach>
							</c:when>
						</c:choose>
					</select>
				</div>
				<div class="col-9">
					<input class="btn btn-primary button" type="submit" value="Rechercher" id="submit" data-toggle="tooltip" data-placement="bottom" title="Rechercher">
				</div>
			</div>
			<br>
			<br>
		</form>
	</div>
	<br>
	<c:if test="${sessionScope.utilisateur != null}">
		<!--code à faire pour les achats et ventes quand l'utilisateur est connecté-->
	</c:if>
	<form action="inscription" method="post">
		<div class="container-fluid articles">
			<c:choose>
				<c:when test="${listeArticles.size()>0}">
					<div class="container">
					    <div class="row row-cols-1 row-cols-md-2 g-3">
					        <c:forEach var="article" items="${listeArticles}">
					            <div class="col">
					                <div class="card mb-3">
					                    <div class="row g-0">
					                        <div class="col-md-3">
					                            <img src="${pageContext.request.contextPath}/images/photo_non_disponible.png" class="img-fluid rounded-start image" alt="article photo">
					                        </div>
					                        <div class="col-md-9">
					                            <div class="card-body texte_article">
					                                <h5 class="card-title">
					                                <c:choose>
														<c:when test="${sessionScope.utilisateur != null}">
															<a href="${pageContext.request.contextPath}/article?id=${article.idArticle}" title="Voir l'article">${article.nomArticle}</a>
														</c:when>
														<c:otherwise>
															${article.nomArticle}
														</c:otherwise>
													</c:choose>
					                                    </h5>
					                                <p class="card-text article">Prix : ${article.miseAPrix} points</p>
					                                <p class="card-text article">Fin de l'enchère : ${article.dateFinEncheres}</p>
					                                <p class="card-text article">Vendeur : ${article.utilisateur.getPseudo()}</p>
					                                <p class="card-text">
					                                    <small class="text-body-secondary"></small>
					                                </p>
					                            </div>
					                        </div>
					                    </div>
					                </div>
					            </div>
					        </c:forEach>
					    </div>
					</div>
				</c:when>
				<c:otherwise>
					<p>Pas d'articles actuellement ou pas de résultat pour cette recherche.<p>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
	<footer>
		<%@ include file="../fragments/footer.html"%>
	</footer>
</body>
</html>