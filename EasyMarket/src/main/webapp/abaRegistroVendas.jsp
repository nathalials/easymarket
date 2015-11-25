<%-- 
    Document   : registroVendas
    Created on : 21/11/2015, 13:56:30
    Author     : Equipe F5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
        <link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
        <!-- Include jTable script file. -->
        <script src="js/jquery-1.8.2.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
        <script src="js/jquery.jtable.js" type="text/javascript"></script>
        <script src="js/jquery.maskedinput.js" type="text/javascript"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
            <div id="logo_registroVendas">Registro de Vendas</div>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#ProdutoTable').jtable({
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
                            list: true,
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
                        qtdAtual: {
                            title: 'Qtd Atual',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false
                        },
                        precoVenda: {
                            title: 'Preço Venda',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false
                        }
                    }
         
                });
                $('#ProdutoTable').jtable('load');
            });
        </script>

    </head>
    <body>
        <div style="width: 50%; text-align: center; height: 50%; position: relative; left:2%; top: 5%"><div style="width: 50%; text-align: center; height: 50%; position: relative; left:2%; top: 5%"></div>
            <label>a tag para achar é tamanho no arquivo jquery.jtable</label>
            <div id="ProdutoTable"></div>
        </div>
    </body>
</html>
