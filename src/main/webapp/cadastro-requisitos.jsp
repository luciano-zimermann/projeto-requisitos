<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Cadastrar Projeto</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="pendente.jsp">Voltar</a>

    <div class="escopo">
        <h1>Requisitos</h1>
        <div class="form-geral">
            <form>
                <div class="campos-1">
                    <div id="div-requisitos-esq">
                        <label>Código</label>
                        <input type="text">
                        <label>Descrição</label>
                        <textarea id="story" name="story" rows="10" cols="55"></textarea>
                    </div>
                </div>
                <div class="campos-2">
                    <label>Requisito</label>
                    <input type="input">
                    <label>Versão</label>
                    <input type="number">
                    <label>Justificativa</label>
                    <input type="text">
                </div>
                <div class="btn-cadastro">
                    <button>Cadastrar Requisito</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>