<!DOCTYPE>
<html>
    <head>
        <title>EasyMarket</title>
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
                $('#ProdutoTable').jtable({
                    title: 'Lista Produtos',
                    actions: {
                        listAction: 'ControllerProduto?action=list',
                        createAction: 'ControllerProduto?action=create',
                        updateAction: 'ControllerProduto?action=update',
                        deleteAction: 'ControllerProduto?action=delete'
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
                            edit: true
                        },
                        marca: {
                            title: 'Marca',
                            width: '30%',
                            edit: true
                        },
                        codigoDeBarras: {
                            title: 'Cód Barras',
                            width: '20%',
                            edit: true
                        },
                        lote: {
                            title: 'Lote',
                            width: '20%',
                            edit: true
                        },
                        dataValidade: {
                            title: 'Data Validade',
                            width: '20%',
                            edit: true,
                            type: 'date'
                        },
                        setor: {
                            title: 'Setor',
                            width: '20%',
                            edit: true,
                            options: {"Alimentos": 'Alimentos', "Higiene": 'Higiene', "Limpeza": 'Limpeza', "Bebidas": 'Bebidas'}

                        },
                        precoCompra: {
                            title: 'Preço Compra',
                            width: '20%',
                            edit: true

                        },
                        precoVenda: {
                            title: 'Preço Venda',
                            width: '20%',
                            edit: true

                        },
                        estoqueMinimo: {
                            title: 'Estq Min',
                            width: '20%',
                            edit: true

                        },
                        estoqueMaximo: {
                            title: 'Estq Max',
                            width: '20%',
                            edit: true

                        },
                        qtdAtual: {
                            title: 'Qtd',
                            width: '20%',
                            edit: true

                        },
                        ativo: {
                            title: 'Status',
                            width: '20%',
                            type: 'radiobutton',
                            options: {"S": 'Ativado', "N": 'Desativado'},
                            edit: true

                        }


                    }
         
                });
                $('#ProdutoTable').jtable('load');
            });
        </script>

    </head>
    <body>
        <div style="width: 100%; text-align: center; height: 100%;">

            <div id="ProdutoTable"></div>
        </div>
    </body>
</html>