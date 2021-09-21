<%@ page import="entities.Project" %>
<%@ page import="dao.ProjectData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Projetos</title>
</head>
    <style type="text/css">
    
    	#table-head {
 	    	background-color: salmon;
 	    	font-family: Calibri;
     	} 
    	
	 </style>
<body style="background-image: url(images/bg-login.jfif);">

        <a id="voltar" href="administrator-account.jsp">Voltar</a>

        <div class="titulo-tabela">
            <h1>Projetos</h1>
        </div>

    <div class="usr-prj">
        <div>
            <button type=type="button" onclick="document.location.href = 'projects-register.jsp';">Cadastrar</button>
            <button type="button" onclick="document.location.href = 'requirements.jsp';">Visualizar Requisitos</button>
            <button onClick="generateReport()">Relatório</button>
        </div>
    
        <div>
            <table border="1" id="projects">
                <tr>
                    <td>Id</td>
                    <td>Descrição</td>
                    <td>Cliente</td>
                    <td>Status</td>
                    <td>Data Início</td>
                    <td>Data Fim</td>
                    <td>Responsável</td>
                </tr>
                <%
                ProjectData projectData = new ProjectData();
                
                List<Project> projectsList = projectData.listProjects();
                
                for ( Project p : projectsList )
                {
            		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
            		String startDate = sdf.format( p.getPrjStartDate() );
            		String endDate = sdf.format( p.getPrjEndDate() );
                %>
                <tr>
                    <td><%= p.getPrjId() %></td>
                    <td><%= p.getPrjDescription() %></td>
                    <td><%= p.getPrjCustomer() %></td>
                    <td><%= p.getPrjStatus() %></td>
                    <td><%= startDate %></td>
                    <td><%= endDate %></td>
                    <td><%= p.getPrjOwner().getUsrName()%></td>
                    <td><a href="ProjectServlet?action=upd&id=<%=p.getPrjId()%>" class="btn-edit">Editar</a></td>
                    <td><a href="ProjectServlet?action=del&id=<%=p.getPrjId()%>" class="btn-delete">Excluir</a></td>
                </tr>
                <%
                }
                %>
            </table>
        </div>
    </div>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">    
    function generateReport() {
    	
        html2canvas(document.getElementById('projects'), {
            onrendered: function (canvas) {
            	
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 480
                    }]
                };
                pdfMake.createPdf(docDefinition).download("Projects.pdf");
            }
        });
    }
    </script>
</body>
</html>