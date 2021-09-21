<%@ page import="entities.User" %>
<%@ page import="dao.UserData" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Cadastrar Projetos</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="projetos.jsp">Voltar</a>

    <div class="escopo">
        <h1>Projetos</h1>
        <div class="form-geral">
            <form action="ProjectServlet" method="post">
                <div class="campos-1">
                    <label>Descri��o</label>
                    <textarea id="story" name="description" required="required"
                    rows="10" cols="55"></textarea>
                    <label>Cliente</label>
                    <input type="text" id="customer" name="customer" required>
                    <label>Status</label>
                    <select id="status" name="status">
                    	<option value="not-started">
                            N�o Iniciado
                        </option>
                        <option value="running">
                            Em Andamento
                        </option>
                        <option value="stopped">
                            Parado
                        </option>
                        <option value="concluded">
                            Conclu�do
                        </option>
                    </select>
                </div>
                <div class="campos-2">
                    <label>Data In�cio</label>
                    <input type="date" id="start-date" name="start-date" required="required">
                    <label>Data Fim</label>
                    <input type="date" id="end-date" name="end-date" required="required">
                    <label>Respons�vel</label>
                    <select id="owner" name="owner">
                    <%
                    UserData userData = new UserData();
                    
                    List<User> usersList = userData.listUsers();
                            	
                    for ( User u : usersList )
                    {
                    %>
                        <option>
                            <%= u.getUsrName().toUpperCase()%>
                        </option>
                    <%
                    }
                    %>
                    </select>
                </div>
                <div class="btn-cadastro">
                    <button type="submit">Cadastrar Projeto</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>