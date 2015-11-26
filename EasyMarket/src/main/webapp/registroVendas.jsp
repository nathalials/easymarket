
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
        <!-- Include one of jTable styles. -->
        <link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
        <link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <!-- Include jTable script file. -->
        <script src="js/jquery-1.8.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="js/jquery.jtable.js" type="text/javascript"></script>
        <script src="js/jquery.maskedinput.js" type="text/javascript"></script>


        <script type="text/javascript">
            $(document).ready(function () {
                $('#ProdutoVendidoTable').jtable({
                    title: 'Produtos',
                    actions: {
                        listAction: 'ConsultaProduto?action=list',
                        //createAction: 'ControllerProduto?action=create',
                        //updateAction: 'ControllerProduto?action=update',
                        //deleteAction: 'ControllerProduto?action=delete'
                    },
                    fields: {
                        id_venda: {
                            title: 'Id Venda',
                            width: '30%',
                            key: true,
                            list: false,
                            edit: false,
                            create: false
                        },
                        id_produto: {
                            title: 'Id Produto',
                            width: '30%',
                            list: true,
                            edit: false,
                            create: false
                        },
                        qtd_vendida: {
                            title: 'Qtd Vendida',
                            width: '30%',
                            list: true,
                            edit: false,
                            create: false
                        },
                        valor_venda: {
                            title: 'Total Venda',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false
                        }


                    }

                });
                $('#ProdutoVendidoTable').jtable('load');
            });

            $(document).ready(function () {
                $(".input").keyup(function () {
                    var val1 = +$(".value1").val();
                    var val2 = +$(".value2").val();
                    $("#result").val(val1 * val2);
                });
            });
        </script>

    </head>

    <body style="background-color:#EBEBEB;">


        <div class="compraProduto">
            <form name="form_consultaProduto" action="ConsultaProduto" method="post" class="registroProduto">
                <br>
                <label class="dadosRegistro">Código de Barras:</label><br>
                <input type="text" name="codigoDeBarras" class="campo"/>
                <input type="submit" value="Buscar" id="botaoBuscar" onclick="javascript: form.action = 'ConsultaProduto?action=save';"/><br>
                <label  class="dadosRegistro" for="nome">Nome:</label> <br>
                <input value='<%=request.getAttribute("nome")%>' type="text" name="nome" readonly="readonly" />
                <br><label class="dadosRegistro">Quantidade:</label><br>
                <input type="text" class="input value1" name="qtdVendida"><br>
                <label  class="dadosRegistro" for="precoVenda">Preço Unitário:</label> <br> 
                <input value='<%=request.getAttribute("precoVenda")%>' type="text" class="input value2" readonly="readonly" >
                <br><label class="dadosRegistro">Preço Total:</label><br>
                <input type="text" disabled="disabled" id="result" name="precoTotal">
                <input type="submit" value="+" id="botaoAdicionar" onclick="javascript: form.action = 'ConsultaProduto?action=add';"/>

            </form>
        </div>


        <input type="submit" value="FECHAR VENDA" id="botaoFecharVenda" onclick="javascript: form.action = 'ConsultaProduto?action=fecharVenda';"/>

        <div id="tabela" class="tabelaProdutos">
            
            <iframe src="produtoVendidoTable.jsp" frameborder="0" style="top: 30%; left: 50%; width: 50%; height: 40%;"></iframe>
           
        </div>
    </body>
</html>
