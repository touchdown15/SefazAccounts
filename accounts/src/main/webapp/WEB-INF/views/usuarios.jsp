<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <style><%@include file="/WEB-INF/css/usuarios.css"%></style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSP Usuarios</title>
</head>
<body>
    <div>
        <div>
            <h2>Usuarios</h2>
            
            <a href="/logout">
				<button type="submit">Logout</button>
			</a>
            <hr/>
            <div>
                <div>
                    <h3>Lista de usuarios</h3>
                </div>
                <a href="/novo-usuario">
                	<button type="submit">Adicionar novo usuarios</button>
            	</a>
                <br/><br/>
                <div>
                    <table>
                        <c:forEach var="usuario" items="${usuarios}">
                            <tr>
                                <th>Nome: </th><td class = "alinhamento">${usuario.nome}</td>
                                <th>Email: </th><td class = "alinhamento">${usuario.email}</td>
                                <th>Senha: </th><td class = "alinhamento">${usuario.senha}</td>
                                <td>
                               		<th>
                                    <a href="/${usuario.id}">
										<input type="submit" value="Editar"/>
									</a>
									</th>
                                    <td>
                                    <form action="/${usuario.id}/delete" method="post">
                                        <input type="submit" value="Deletar" />
                                    </form>
                                    </td>
                                </td>
                                <c:forEach var="telefone" items="${usuario.lista_de_telefone}" >
                                	<tr>
                                	<th>DDD: </th><td class = "alinhamento">${telefone.ddd}</td>
                                	<th>Numero: </th><td class = "alinhamento">${telefone.numero}</td>
                                	<th>Tipo: </th><td class = "alinhamento">${telefone.tipo}</td>
                                	</tr>
                        		</c:forEach>
                            </tr>
                        </c:forEach>
                    </table>                 
                </div>
            </div>
        </div>
    </div>
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    
</body>
</html>