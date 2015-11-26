    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EasyMarket</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>

    <body>

        <div id="aba"> 
            <label id="logo_easymarket">EasyMarket</label>
            <img id="img_carrinho" src="css/images/product20-512.png"></img>
            <a href="login.jsp">
                <img border="0" src="css/images/logout.png" id="logout">
            </a>`
            <br>
            <br>
            <ul class="nav nav-tabs nav-justified">

                <li><a data-toggle="tab" href="#produto">Produto</a></li>
                <li><a data-toggle="tab" href="#estoque">Estoque</a></li>
                <li><a data-toggle="tab" href="#vendas">Vendas</a></li>

            </ul>

            <div class="divsel">

                <div class="tab-content">

                    <div id="produto" class="tab-pane fade">
                        <body class="abaFrame">
                            <iframe src="abaProduto.jsp" frameborder="0"></iframe>
                        </body>
                    </div>
                    <div id="estoque" class="tab-pane fade">
                        <body class="abaFrame">
                            <iframe src="abaEstoque.jsp" frameborder="0"></iframe>
                        </body>
                    </div>
                    <div id="vendas" class="tab-pane fade">
                        <body class="abaFrame">
                            <iframe src="abaVendas.jsp" frameborder="0"></iframe>
                        </body>
                    </div>
                </div>
            </div>
        </div>
</html>
