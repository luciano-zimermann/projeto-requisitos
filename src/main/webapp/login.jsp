<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Login - Requereasy Tech</title>
</head>
<body>

    <div id="requereasy">
        Requereasy Tech - Soluções Para os seus Projetos de Requisitos
    </div>

    <div id="description">
        Cadastre seus projetos com requisitos e versione os requisitos para ajudar no controle de seus projetos!
    </div>

    <div class="back-geral-login">
        <div class="back-login">
            <div class="login">   
                <form action="LoginServlet" method="post" onSubmit="return validateLogin()">
                    <label id="spacing" for="login">Login</label>
                    <input type="text" name=login id="login">
                    <label for="password">Senha</label>
                    <input type="password" name=password id="password" >
                    <div class="efeito">
                        <button type="submit" value="Entrar" >Entrar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/login-validation.js"></script>
</body>
</html>