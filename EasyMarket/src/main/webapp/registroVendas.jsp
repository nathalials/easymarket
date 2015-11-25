
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
                $('#CompraProdutoTable').jtable({
                    title: 'Produtos',
                    actions: {
                        listAction: 'ControllerProduto?action=list',
                        //createAction: 'ControllerProduto?action=create',
                        //updateAction: 'ControllerProduto?action=update',
                        //deleteAction: 'ControllerProduto?action=delete'
                    },
                    fields: {
                        idProduto: {
                            title: 'Id',
                            width: '30%',
                            key: true,
                            list: false,
                            edit: false,
                            create: false
                        },
                        nome: {
                            title: 'Nome',
                            width: '30%',
                            list: true,
                            edit: false,
                            create: false
                        },
                        marca: {
                            title: 'Marca',
                            width: '30%',
                            list: true,
                            edit: false,
                            create: false
                        },
                        codigoDeBarras: {
                            title: 'Cód Barras',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false
                        },
                        lote: {
                            title: 'Lote',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false
                        },
                        dataValidade: {
                            title: 'Data Validade',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false,
                            type: 'date'
                        },
                        setor: {
                            title: 'Setor',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false,
                            options: {"Alimentos": 'Alimentos', "Higiene": 'Higiene', "Limpeza": 'Limpeza', "Bebidas": 'Bebidas'}

                        },
                        precoCompra: {
                            title: 'Preço Compra',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false

                        },
                        precoVenda: {
                            title: 'Preço Unitário',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false

                        },
                        estoqueMinimo: {
                            title: 'Estq Mín',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false

                        },
                        estoqueMaximo: {
                            title: 'Estq Máx',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false

                        },
                        qtdAtual: {
                            title: 'Qtd Atual',
                            width: '20%',
                            list: false,
                            edit: false,
                            create: false

                        },
                        ativo: {
                            title: 'Status',
                            width: '20%',
                            type: 'radiobutton',
                            options: {"S": 'Ativado', "N": 'Desativado'},
                            list: false,
                            edit: false,
                            create: false

                        }


                    }

                });
                $('#CompraProdutoTable').jtable('load');
            });
        </script>

    </head>

    <body>

        <div id="aba"> 

            <label id="logo_easymarket">EasyMarket</label>
            <img id="img_carrinho" src="css/images/product20-512.png"></img>




            <div class="compraProduto">
                <form name="form_consultaProduto" action="ConsultaProduto" method="post" class="registroProduto">
                    <br>
                    <label class="dadosRegistro">Código de Barras:</label><br>
                    <input type="text" name="codigoDeBarras" class="campo"/>
                    <input type="submit" value="Buscar" id="botaoBuscar" onclick="javascript: form.action='ConsultaProduto  ';"/><br>
                    <label  class="dadosRegistro" for="nome">Nome:</label> <br>
                    <input value='<%=request.getAttribute("nome")%>' type="text" name="nome" readonly="readonly" />
                    <br><label class="dadosRegistro">Quantidade:</label><br>
                    <input type="text" class="input value1" name="qtdVendida"><br>
                    <label  class="dadosRegistro" for="precoVenda">Preço Unitário:</label> <br> 
                    <input value='<%=request.getAttribute("precoVenda")%>' type="text" class="input value2" readonly="readonly" >
                    <br><label class="dadosRegistro">Preço Total:</label><br>
                    <input type="text" disabled="disabled" id="result">
                    <input type="submit" value="+" id="botaoBuscar" onclick="javascript: form.action='AdicionaProdutoVenda';"/>

                </form>
            </div>
                    
                   <div id="CompraProdutoTable"></div>

        </div>
        <script>
            $(document).ready(function () {
                $(".input").keyup(function () {
                    var val1 = +$(".value1").val();
                    var val2 = +$(".value2").val();
                    $("#result").val(val1 * val2);
                });
            });
        </script>
</html>
