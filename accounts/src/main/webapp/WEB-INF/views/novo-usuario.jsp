<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <style><%@include file="/WEB-INF/css/novo-usuario.css"%></style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSP Usuarios</title>
</head>
<body>
    <div>
        <h2>Novo Usuario</h2>
        <hr/>
        <div>
            <div class = "container">
                
                <h4>Criando Via Ajax+JQuery</h4>
	            <p>Nome <input type="text" id="nome" required></p>
	            <p>Email <input type="text" id="email" required></p>
	            <p>Senha <input type="password" id="senha" required></p>
	            <div id = "table">
	                <p>DDD <input type="text" id="ddd" required></p>
	                <p>Numero <input type="text" id="numero" required></p>
	                <p>Tipo <input type="text" id="tipo" required></p>
	            </div> 
	            
                
            </div>
            
            <a href="/"><button id="add-usuario" >Adicionar Usuario</button></a>
            <button id="add-linhas" >Adicionar Linhas</button>
            
        </div>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/criar-campo-telefone.js"></script>
    
    
    </body>
</html>