<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% String erreur = (String) request.getAttribute("erreur"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/connexion.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<title>ENI Enchères-connexion</title>
</head>
<body>
		<% if(erreur !=null) { %>
		<p><%=erreur %></p>
		<% } %>
    
    <div class="px-4 py-5 px-md-5 text-center text-lg-start" >
      <div class="container">
        <div class="row gx-sm-1 align-items-center">
            <div class="card">
              <div class="card-body py-5 px-md-5">
                <form action="connexion" method="POST">
                  
                  <div class="row">
                    <h1 class="my-5 display-3 fw-bold ls-tight">ENI-ENCHERES<br>
                      <span class="text-primary">Les objets sont nos amis</span>
                    </h1>
                    <p>
                      Explorez un monde sans argent, où les trésors oubliés trouvent une nouvelle vie. Notre système de vente aux enchères utilise des crédits gagnés en vendant vos objets pour acquérir des trésors d'autres.
                    </p>
                  </div>
                 
                  <div class="form-outline mb-4">
                    <label class="form-label" for="identifiant">Identifiant (pseudo ou e-mail)</label>
                    <input type="text" name="identifiant" id="identifiant" class="form-control" />
                  </div>
  
                  <div class="form-outline mb-4">
                    <label class="form-label" for="motDePasse">Mot de Passe</label>
                    <input type="password" name="motDePasse" id="motDePasse" class="form-control" />
                  </div>

                 <div class="form-check d-flex justify-content-center mb-4">
                    <input class="form-check-input me-2" type="checkbox" value="" id="" checked />
                    <label class="form-check-label" for="">
                        Se souvenir de moi
                    </label>
                  </div>

                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block mb-4">
                        Connexion
                    </button>
                  </div>
                  <div class="btn btn-succes btn-block mb-4">
              	  <a href="${pageContext.request.contextPath}/inscription">Créer un compte</a>
				</div>
                  </div>
                </form>
              </div>
            
          </div>
        </div>
      </div>
    </div>
    
 

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		









</body>
</html>