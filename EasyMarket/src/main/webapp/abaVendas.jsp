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
                    title: 'Produtos',
                    actions: {
                        listAction: 'ControllerProduto?action=list',
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
                            list: true,
                            edit: false,
                            create: false
                        },
                        dataValidade: {
                            title: 'Data Validade',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false,
                            type: 'date'
                        },
                        setor: {
                            title: 'Setor',
                            width: '20%',
                            list: true,
                            edit: false,
                            create: false,
                            options: {"Alimentos": 'Alimentos', "Higiene": 'Higiene', "Limpeza": 'Limpeza', "Bebidas": 'Bebidas'}

                        },
                        precoCompra: {
                            title: 'Preço Compra',
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
                            list: true,
                            edit: false,
                            create: false

                        },
                        ativo: {
                            title: 'Status',
                            width: '20%',
                            type: 'radiobutton',
                            options: {"S": 'Ativado', "N": 'Desativado'},
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
    </body>
</html>