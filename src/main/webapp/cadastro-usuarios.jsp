<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Cadastrar Usu�rio</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="usuarios.jsp">Voltar</a>

    <div class="escopo">
        <h1>Usu�rios</h1>
        <div class="form-geral">
            <form action="UserServlet" method="post">
                <div class="campos-1">
                    <div id="div-usuarios-esq">
                        <label>Nome</label>
                        <input type="text" id="name" name="name" required="required">
                        <label>Login</label>
                        <input type="text" id="login" name="login" required="required">
                    </div>
                </div>
                <div class="campos-2">
                    <label>Senha</label>
                    <input type="password" id="password" name="password" required="required">
                    <label>Permiss�o</label>
                    <select id="permission" name="permission">
                        <option>
                            Administrador
                        </option>
                        <option>
                            Usu�rio
                        </option>
                    </select>
                </div>
                <div class="btn-cadastro">
                    <button type="submit">Cadastrar Usu�rio</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>