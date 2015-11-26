
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
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/jquery.maskedinput.js" type="text/javascript"></script>
        <!-- Import CSS file for validation engine (in Head section of HTML) -->
        <link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css" />

        <!-- Import Javascript files for validation engine (in Head section of HTML) -->
        <script type="text/javascript" src="js/jquery.validationEngine.js"></script>
        



        <script type="text/javascript">
            $(document).ready(function () {
                $('#VendaTable').jtable({
                    title: 'Produtos',
                    actions: {
                        listAction: 'ConsultaProduto?action=list'
                        //createAction: 'ControllerUsuario?action=create',
                        //updateAction: 'ControllerUsuario?action=update',
                        //deleteAction: 'ControllerUsuario?action=delete'
                        
                    },
                    fields: {
                        id_venda: {
                            title: 'Id Venda',
                            width: '30%',
                            list: true
                        },
                        id_produto: {
                            title: 'Id Produto',
                            width: '30%',
                            list: true

                        },
                        qtd_vendida: {
                            title: 'Qtd Vendida',
                            width: '30%',
                            list: true
                        },
                        valor_venda: {
                            title: 'Total Venda',
                            width: '20%',
                            list: true
                        }

                    }

                });
                $('#VendaTable').jtable('load');
//                //Re-load records when user click 'load records' button.
//                $('#LoadRecordsButton').click(function (e) {
//                    e.preventDefault();
//                    $('#UserTable').jtable('load', {
//                        nome: $('#nome').val()
//                    });
//                });
//                //remove your comments .. the code below is for running the function above when loadrecords button is clicked
//                $('#LoadRecordsButton').click();
            });

        </script>

    </head>
    <body>

        <div id="VendaTable"></div>



    </body>
</html>