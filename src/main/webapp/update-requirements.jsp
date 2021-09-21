<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Atualizar Requisitos</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="requirements.jsp">Voltar</a>

    <div class="escopo">
        <h1>Editar Requisito</h1>
        <div class="form-geral">
            <form action="RequirementsServlet" method="post">
                <div class="campos-1">
                    <div id="div-requisitos-esq">
                    	<input type="hidden" id="id" name="id" value="${requirements.getReqId()}">
                        <label>Código</label>
                        <input type="text" id="code" name="code" required="required" required value="${requirements.getReqCode()}">
                        <label>Descrição</label>
                        <textarea id="story" name="description" required="required" rows="10" cols="55">${requirements.getReqDescription()}</textarea>
                    </div>
                </div>
                <div class="campos-2">
                    <label>Requisito</label>
                    <input type="input" id="requirement" name="requirement" required="required" required value="${requirements.getReqRequeriment()}">
                    <label>Versão</label>
                    <input type="number" id="version" name="version" required="required" required value="${requirements.getReqVersion()}">
                    <label>Justificativa</label>
                    <input type="text" id="justification" name="justification" required="required" required value="${requirements.getReqJustification()}">
                </div>
                <div class="btn-cadastro">
                    <button>Cadastrar Requisito</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>