<%@ page import="entities.User" %>
<%@ page import="entities.Project" %>
<%@ page import="dao.UserData" %>
<%@ page import="dao.ProjectData" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Atualizar Projetos</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="projetos.jsp">Voltar</a>

    <div class="escopo">
        <h1>Editar Projeto</h1>
        <div class="form-geral">
            <form action="ProjectServlet" method="post">
                <div class="campos-1">
                	<input type="hidden" id="id" name="id" required value="${project.getPrjId()}">
                    <label>Descrição</label>
                    <textarea id="story" name="description"rows="10" cols="55">${project.getPrjDescription()}</textarea>
                    <label>Cliente</label>
                    <input type="text" id="customer" name="customer" required value="${project.getPrjCustomer()}">
                    <label>Status</label>
                    <select id="status" name="status">
						<option>
                            Não Iniciado
                        </option>
                        <option>
                            Em Andamento
                        </option>
                        <option>
                            Parado
                        </option>
                        <option>
                            Concluído
                        </option>
                    </select>
                </div>
                <div class="campos-2">
                    <label>Data Início</label>
                    <input type="date" id="start-date" name="start-date" required value="${project.getPrjStartDate()}">
                    <label>Data Fim</label>
                    <input type="date" id="end-date" name="end-date" required value="${project.getPrjEndDate()}">
                    <label>Responsável</label>
                    <select id="owner" name="owner">
                    <%
                    UserData userData = new UserData();
                    
                    List<User> usersList = userData.listUsers();
                            	
                    for ( User u : usersList )
                    {
                    %>
                        <option value="">
                            ${project.getPrjOwner().getUsrName()}
                        </option>
                   <%
                    }
                   %>
                    </select>
                </div>
                <div class="btn-cadastro">
                    <button>Atualizar Projeto</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>