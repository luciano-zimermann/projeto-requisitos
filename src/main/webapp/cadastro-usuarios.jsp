<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Cadastrar Usuário</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="conta.jsp">Voltar</a>

    <div class="escopo">
        <h1>Usuários</h1>
        <div class="form-geral">
            <form action="UserRegisterServlet" method="post">
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
                    <label>Permissão</label>
                    <select id="permission" name="permission">
                        <option value="administrator">
                            Administrador
                        </option>
                        <option value="user">
                            Usuário
                        </option>
                    </select>
                </div>
                <div class="btn-cadastro">
                    <button type="submit">Cadastrar Usuário</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>