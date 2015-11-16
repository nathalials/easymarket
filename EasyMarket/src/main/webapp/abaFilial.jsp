<%-- 
    Document   : abaFilial
    Created on : 16/11/2015, 08:57:13
    Author     : DU
--%>

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
                $('#FilialTable').jtable({
                    title: 'Lista Filiais',
                    actions: {
                        listAction: 'ControllerFilial?action=list',
                        createAction: 'ControllerFilial?action=create',
                        updateAction: 'ControllerFilial?action=update',
                        deleteAction: 'ControllerFilial?action=delete'
                    },
                    fields: {
                        idFilial: {
                            title: 'Id',
                            width: '30%',
                            key: true,
                            list: true,
                            edit: false,
                            create: false
                        },
                        razaoSocial: {
                            title: 'Razão Social',
                            width: '30%',
                            edit: true
                        },
                        cnpj: {
                            title: 'CNPJ',
                            width: '30%',
                            edit: true
                        },
                        endereco: {
                            title: 'Endereço',
                            width: '20%',
                            edit: true
                        },
                        cep: {
                            title: 'CEP',
                            width: '20%',
                            edit: true
                        },
                        bairro: {
                            title: 'Bairro',
                            width: '20%',
                            edit: true
                        },
                        cidade: {
                            title: 'Cidade',
                            width: '20%',
                            edit: true
                        },
                        telefone: {
                            title: 'Telefone',
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
                $('#FilialTable').jtable('load');
            });
        </script>

    </head>
    <body>
        <div style="width: 100%; text-align: center; height: 100%;">

            <div id="FilialTable"></div>
        </div>
    </body>
</html>