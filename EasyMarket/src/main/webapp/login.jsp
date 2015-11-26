
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EasyMarket</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <div id="aba"> 
            <label id="logo_easymarket">EasyMarket</label>
            <img id="img_carrinho" src="css/images/product20-512.png"></img>
            <div class="login">
                <form name="form_validarLogin" action="ValidarLogin" method="post">
                    <p class="login">
                        <label for="login" class="dados">Login</label> <input type="text" id="loginid" placeholder="Login" required="required" name="login" class="campo"/>
                    </p>
                    <p class="senha">
                        <label for="senha" class="dados">Senha</label> <input type="password" id="senhaid" placeholder="Senha" name="senha" class="campo"/>
                    </p><br>
                    <p class="submit">
                        <input type="submit" onclick="Enviar();" value="Entrar" />
                    </p>
                </form>
            </div>
            <img id="img_online" src="css/images/online-shopping-1600-clr.png"></img>
        </div>
    </div>
</html>
