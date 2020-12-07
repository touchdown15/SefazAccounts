<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <style><%@include file="/WEB-INF/css/edit-usuario.css"%></style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSP Usuarios</title>
</head>
<body>
    <div>
        <h2>Atualização de Usuario</h2>
        <hr/>
        <div>
            <div class = "container">
            	
                <form:form action="${usuario.id}/update" modelAttribute="usuario" method="post">
                    <div>
                        <div>
                            <label>Id: </label> ${usuario.id}
                        </div>
                        <div>
                            <form:label path="nome">Nome</form:label>
                            <form:input type="text" id="nome" path="nome"/>
                            <form:errors path="nome" />
                        </div>
                        <div>
                            <form:label path="email">Email</form:label>
                            <form:input type="text" id="email" path="email"/>
                            <form:errors path="email" />
                        </div>
                        <div>
                            <form:label path="senha">Senha</form:label>
                            <form:input type="text" id="senha" path="senha"/>
                            <form:errors path="senha" />
                        </div>
                        
                        <c:forEach var="telefone" items="${usuario.lista_de_telefone}" varStatus="i">
                        
                        		<div>
                            		<form:label path="lista_de_telefone[${i.index}].ddd">DDD</form:label>
                            		<form:input type="text" id="ddd" path="lista_de_telefone[${i.index}].ddd"/>
                            		<form:errors path="lista_de_telefone[${i.index}].ddd" />
                        		</div>
                        		
                        		<div>
                            		<form:label path="lista_de_telefone[${i.index}].numero">Numero</form:label>
                            		<form:input type="text" id="numero" path="lista_de_telefone[${i.index}].numero"/>
                            		<form:errors path="lista_de_telefone[${i.index}].numero" />
                        		</div>
                        		
                        		<div>
                           			<form:label path="lista_de_telefone[${i.index}].tipo">Tipo</form:label>
                            		<form:input type="text" id="tipo" path="lista_de_telefone[${i.index}].tipo"/>
                            		<form:errors path="lista_de_telefone[${i.index}].tipo" />
                        		</div>
                        </c:forEach>
                        
                    </div>
                    <div>
						<button class = "buttonPadrao" type="submit" value="Atualizar Usuario">Atualizar Usuario</button>                		
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    
    
    </body>
</html>