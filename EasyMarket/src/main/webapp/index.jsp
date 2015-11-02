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
            <form action="/EasyMarket/CadastrarUsuario" method="post" id="form_user">
                <table  id="t_usuario">
                    <tr><td>Nome</td><td><input type="text" name="user_nome"><br></td></tr>
                    <tr><td>Login<td><input type="text" name="user_login"><br></td></tr>
                    <tr><td>Senha</td><td><input type="text" name="user_senha"><br></td></tr>
                    <tr><td>Email</td><td><input type="text" name="user_email"><br></td></tr>
                    <tr><td>CPF</td><td><input type="text" name="user_cpf"><br></td></tr>
                    <tr><td>Cargo</td><td><input type="text" name="user_cargo"><br></td></tr>
                    <tr><td>Status</td><td><input type="text" name="user_status"><br></td></tr>
                    <tr></tr>
                    <tr><td></td><td><input type="submit" value="Enviar"></td></tr>
                </table>
            </form>
            
        </div>

        <div id="textaba2" class="divunsel">Conteúdo da aba2 aqui</div>
        
        <!-- Aba produtos -->
        <div id="textaba3" class="divunsel">
             <table  id="t_produto">
                    <tr>
                        <td>Nome</td><td><input type="text" id="produto_nome"><br></td>
                        <td>Preço Compra</td><td><input type="text" id="produto_compra"><br></td>
                    </tr>   
                    <tr>
                        <td>Marca<td><input type="text" id="produto_marca"><br></td>
                        <td>Preço Venda</td><td><input type="text" id="produto_venda"><br></td>
                    </tr> 
                    <tr>
                        <td>Fornecedor</td><td><input type="text" id="produto_fornecedor"><br></td>
                        <td>Estoque Mínimo</td><td><input type="text" id="produto_minimo"><br></td>
                    </tr>
                    <tr>
                        <td>Código de Barras</td><td><input type="text" id="produto_cod"><br></td>
                        <td>Estoque máximo</td><td><input type="text" id="produto_maximo"><br></td>
                    </tr> 
                    <tr>
                        <td>Lote</td><td><input type="text" id="produto_lote"><br></td>
                        <td>Quantidade Atual</td><td><input type="text" id="produto_qtdAtual"><br></td>
                    </tr>
                    <tr>
                        <td>Data de validade</td><td><input type="text" id="produto_validade"><br></td>
                        <td>Status</td><td><input type="text" id="produto_status"><br></td>
                    </tr>
                    <tr>
                        <td>Setor</td><td><input type="text" id="produto_setor"><br></td>
                    </tr>
                    <tr></tr>
                    <tr><td></td><td><input type="submit" value="Enviar" id="produto_enviar"></td>
                    </tr>
                </table>        
        </div>
        <div id="textaba4" class="divunsel">Conteúdo da aba4 aqui</div>
        <div id="textaba5" class="divunsel">Conteúdo da aba5 aqui</div>
        <div id="textaba6" class="divunsel">Conteúdo da aba6 aqui</div>
    </body>
</html>
