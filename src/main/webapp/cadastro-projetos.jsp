<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Cadastrar Requisitos</title>
</head>

<body style="background-image: url(images/bg-login.jfif);">

    <a id="voltar" href="projetos.jsp">Voltar</a>

    <div class="escopo">
        <h1>Projetos</h1>
        <div class="form-geral">
            <form>
                <div class="campos-1">
                    <label>Descri��o</label>
                    <textarea id="story" name="story"
                    rows="10" cols="55">
                    
                    </textarea>
                    <label>Cliente</label>
                    <input type="text">
                    <label>Status</label>
                    <select>
                        <option value="">
                            Em Andamento
                        </option>
                        <option value="">
                            Parado
                        </option>
                    </select>
                </div>
                <div class="campos-2">
                    <label>Data In�cio</label>
                    <input type="date">
                    <label>Data Fim</label>
                    <input type="date">
                    <label>Respons�vel</label>
                    <select>
                        <option value="">
                            Fulano
                        </option>
                        <option value="">
                            Ciclano
                        </option>
                    </select>
                </div>
                <div class="btn-cadastro">
                    <button  type="button" onclick="document.location.href = 'cadastro-requisitos.jsp';">Cadastrar Requisitos</button>
                    <button>Cadastrar Projeto</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>