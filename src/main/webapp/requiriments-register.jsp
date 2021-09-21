<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Cadastrar Requisitos</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="requirements.jsp">Voltar</a>

    <div class="escopo">
        <h1>Requisitos</h1>
        <div class="form-geral">
            <form action=RequirementsServlet method="post">
                <div class="campos-1">
                    <div id="div-requisitos-esq">
                        <label>Código</label>
                        <input type="text" id="code" name="code" required="required">
                        <label>Descrição</label>
                        <textarea id="story" name="description" rows="10" cols="55" required></textarea>
                    </div>
                </div>
                <div class="campos-2">
                    <label>Requisito</label>
                    <input type="input" id="requirement" name="requirement" required>
                    <label>Versão</label>
                    <input type="number" id="version" name="version" required>
                    <label>Justificativa</label>
                    <input type="text" id="justification" name="justification" required>
                </div>
                <div class="btn-cadastro">
                    <button type="submit">Cadastrar Requisito</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>