<%@ page import="entities.User" %>
<%@ page import="dao.UserData" %>
<%@ page import="java.util.List" %>

<%
	String message = null;
	String validator = request.getParameter( "id" );
	
	if ( validator == null )
	{
		message = "Usu�rio n�o exclu�do, tente novamente mais tarde";
	}
	
	else
	{
		UserData userData = new UserData();
		User user = new User();
		user.setUsrId( Integer.valueOf( validator ) );
		
		userData.delete( user );
		
		response.sendRedirect( "successful-deleting-user.jsp" );
	}
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Usu�rios</title>
    <style type="text/css">
    
    	#table-head {
	    	background-color: salmon;
	    	font-family: Calibri;
    	}
    	
    </style>
</head>
<body style="background-image: url(images/bg-login.jfif);">

        <a id="voltar" href="administrator-account.jsp">Voltar</a>

        <div class="titulo-tabela">
            <h1>Usu�rios</h1>
        </div>

    <div class="usr-prj">
        <div>
            <button  type=type="button" onclick="document.location.href = 'cadastro-usuarios.jsp';">
                Cadastrar Usu�rio
            </button>
        </div>
    
        <div>
            <table>
                <tr id="table-head">
                	<th>Id</th>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Permiss�o</th>
                <tr>
                <%
                UserData userData = new UserData();
                                
                List<User> usersList = userData.listUsers();
                        	
                for ( User u : usersList )
                {
                %>
                <tr>
                	<td><%= u.getUsrId() %></td>
                    <td><%= u.getUsrName() %></td>
                    <td><%= u.getUsrLogin() %></td>
                    <td><%= u.getUsrPassword() %></td>
                    <td><%= u.getUsrPermission() %></td>
                    <td><a href="UserServlet?action=upd&id=<%=u.getUsrId()%>" class="btn-edit">Editar</a></td>
                    <td><a href="?id=<%=u.getUsrId()%> "class="btn-delete"> Excluir</a></td>
                </tr>                
                <%
                }
                %>
            </table>
        </div>
    </div>
</body>
</html>