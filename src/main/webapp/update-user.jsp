<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Edit User</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="usuarios.jsp">Voltar</a>

    <div class="escopo">
        <h1>Editar Usuário</h1>
        <div class="form-geral">
            <form action="UserServlet" method="post">
                <div class="campos-1">
                    <div id="div-usuarios-esq">
                    	<input type="hidden" id="id" name="id" required="required" required value="${user.getUsrId()}">
                        <label>Nome</label>
                        <input type="text" id="name" name="name" required="required" required value="${user.getUsrName()}">
                        <label>Login</label>
                        <input type="text" id="login" name="login" required="required" required value ="${user.getUsrLogin()}">
                    </div>
                </div>
                <div class="campos-2">
                    <label>Senha</label>
                    <input type="password" id="password" name="password" required="required" required value ="${user.getUsrPassword()}">
                    <label>Permissão</label>
                    <select id="permission" name="permission" value="${user.getUsrPermission()}">
                        <option value="administrator">
                            Administrador
                        </option>
                        <option value="user">
                            Usuário
                        </option>
                    </select>
                </div>
                <div class="btn-cadastro">
                    <button type="submit">Atualizar Usuário</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>