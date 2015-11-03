<!DOCTYPE>
<html>
<head>
<title>EasyMarket</title>
<!-- Include one of jTable styles. -->
<link href="css/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#StudentTableContainer').jtable({
			title : 'Lista Usuarios',
			actions : {
				listAction : 'ControllerUsuario?action=list',
				createAction : 'ControllerUsuario?action=create',
				updateAction : 'ControllerUsuario?action=update',
				deleteAction : 'ControllerUsuario?action=delete'
			},
			fields : {
				idUsuario : {
					title : 'Id Usuario',
					width : '30%',
					key : true,
					list : true,
					edit : false,
					create : false
				},
				nome : {
					title : 'Nome',
					width : '30%',
					edit : true
				},
				login : {
					title : 'Login',
					width : '30%',
					edit : true
				},
				senha : {
					title : 'Senha',
					width : '20%',
					edit : true,
                                        display : false
				},
                                email : {
					title : 'E-mail',
					width : '20%',
					edit : true
				},
                                cpf : {
					title : 'CPF',
					width : '20%',
					edit : true
				},
                                cargo : {
					title : 'Cargo',
					width : '20%',
					edit : true
				},
                                ativo : {
					title : 'Status',
					width : '20%',
					edit : true
				}
			}
		});
		$('#StudentTableContainer').jtable('load');
	});
</script>

</head>
<body>
<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">

		<h4>Usuários do EasyMarket</h4>
		<div id="StudentTableContainer"></div>
	</div>
</body>
</html>