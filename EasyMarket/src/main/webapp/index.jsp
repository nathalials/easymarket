<%-- 
    Document   : index
    Created on : 02/11/2015, 08:45:59
    Author     : DU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EasyMarket</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <script language="JavaScript" src="jquery.js"></script>	
    </head>

    <body>

        <div id="aba">
            <label id="logo_easymarket">EasyMarket</label>
            <img id="img_carrinho" src="carrinhoDeCompras.png"></img>
            <div id="aba1" class="sel" onClick="sel(this.id)">Usuários</div>
            <div id="aba2" class="unsel" onClick="sel(this.id)">Filiais</div>
            <div id="aba3" class="unsel" onClick="sel(this.id)">Produtos</div>
            <div id="aba4" class="unsel" onClick="sel(this.id)">Vendas</div>
            <div id="aba5" class="unsel" onClick="sel(this.id)">Estoque</div>
            <div id="aba6" class="unsel" onClick="sel(this.id)">Relatório</div>
        </div>

        <!-- Aba usuario -->
        <div id="textaba1" class="divsel">
            <iframe src="abaUsuario.jsp" width="100%" height="100%"></iframe>
        </div>

        <div id="textaba2" class="divunsel">Aba 2</div>


        <!-- Aba produtos -->
        <div id="textaba3" class="divunsel">
        <iframe src="abaProduto.jsp" width="100%" height="100%"></iframe>       
        </div>
        <div id="textaba4" class="divunsel">Conteúdo da aba4 aqui</div>
        <div id="textaba5" class="divunsel">Conteúdo da aba5 aqui</div>
        <div id="textaba6" class="divunsel">Conteúdo da aba6 aqui</div>
    </body>
</html>
