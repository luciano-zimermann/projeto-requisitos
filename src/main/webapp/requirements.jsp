<%@ page import="entities.Requirements" %>
<%@ page import="dao.RequirementsData" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Requisitos</title>
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
            <h1>Requisitos</h1>
        </div>

    <div class="usr-prj">
        <div>
            <button type="button" onclick="document.location.href = 'requiriments-register.jsp';">Cadastrar Requisitos</button>
            <button onClick="generateReport()">Relatório</button>
        </div>
        <div>
            <table border="1" id=requirements>
                <tr id="table-head">
                	<th>Id</th>
                    <th>Código</th>
                    <th>Requisito</th>
                    <th>Descrição</th>
                    <th>Versão</th>
                    <th>Justificativa</th>
                <tr>
                <%
                RequirementsData reqData = new RequirementsData();
                                
                List<Requirements> reqList = reqData.listRequeriments();
                        	
                for ( Requirements r : reqList )
                {
                %>
                <tr>
                	<td><%= r.getReqId() %></td>
                    <td><%= r.getReqCode() %></td>
                    <td><%= r.getReqRequeriment() %></td>
                    <td><%= r.getReqDescription() %></td>
                    <td><%= r.getReqVersion()%></td>
                    <td><%= r.getReqJustification()%></td>
                    <td><a href="RequirementsServlet?action=upd&id=<%=r.getReqId()%>" class="btn-edit">Editar</a></td>
                    <td><a href="RequirementsServlet?action=del&id=<%=r.getReqId()%> "class="btn-delete"> Excluir</a></td>
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
        	
            html2canvas(document.getElementById('requirements'), {
                onrendered: function (canvas) {
                	
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 480
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Requirements.pdf");
                }
            });
        }
    </script>
</body>
</html>