<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 11/05/2026
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>


<html>
<head>
    <title>Cadastro de Usuários</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background:#f4f6f9;
            margin:0;
            padding:30px;
        }

        .container{
            max-width:1000px;
            margin:auto;
        }

        .card{
            background:white;
            padding:20px;
            border-radius:10px;
            box-shadow:0 2px 10px rgba(0,0,0,0.1);
            margin-bottom:20px;
        }

        h1,h2{
            color:#333;
        }

        label{
            display:block;
            margin-top:10px;
            font-weight:bold;
        }

        input[type=text],
        input[type=email],
        input[type=password]{
            width:100%;
            padding:10px;
            margin-top:5px;
            border:1px solid #ccc;
            border-radius:5px;
            box-sizing:border-box;
        }

        input[type=submit]{
            margin-top:15px;
            background:#2d89ef;
            color:white;
            border:none;
            padding:10px 20px;
            border-radius:5px;
            cursor:pointer;
        }

        input[type=submit]:hover{
            background:#1f6fd1;
        }

        table{
            width:100%;
            border-collapse:collapse;
        }

        th{
            background:#2d89ef;
            color:white;
            padding:12px;
        }

        td{
            padding:10px;
            border-bottom:1px solid #ddd;
        }

        tr:nth-child(even){
            background:#f8f8f8;
        }

        .mensagem{
            background:#d4edda;
            color:#155724;
            padding:10px;
            border-radius:5px;
            margin-bottom:15px;
        }

        .erro{
            background:#f8d7da;
            color:#721c24;
            padding:10px;
            border-radius:5px;
            margin-bottom:15px;
        }

        .acoes a{
            text-decoration:none;
            margin-right:10px;
            font-weight:bold;
        }

        .editar{
            color:#2d89ef;
        }

        .excluir{
            color:#dc3545;
        }

        .voltar{
            text-decoration:none;
            color:#2d89ef;
            font-weight:bold;
        }
    </style>

</head>
<body>

<div class="container">

    <div class="card">
        <h1>Cadastro de Usuários</h1>

        <form action="usuario" method="post">

            <label for="nome">Nome</label>
            <input type="text"
                   placeholder="Nome do usuário"
                   name="nome"
                   id="nome"
                   required>

            <label for="email">E-mail</label>
            <input type="email"
                   placeholder="Email do usuário"
                   name="email"
                   id="email"
                   required>

            <label for="senha">Senha</label>
            <input type="password"
                   placeholder="Senha do usuário"
                   name="senha"
                   id="senha"
                   required>

            <input type="submit" value="Cadastrar">

        </form>
    </div>

    <c:if test="${not empty erro}">
        <div class="erro">
                ${erro}
        </div>
    </c:if>

    <c:if test="${not empty retorno}">
        <div class="mensagem">
                ${retorno}
        </div>
    </c:if>

    <div class="card">

        <h2>Lista de Usuários</h2>

        <table>

            <thead>
            <tr>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Ativo</th>
                <th>Ações</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="usuario" items="${listausuarios}">
                <tr>

                    <td>${usuario.nome}</td>

                    <td>${usuario.email}</td>

                    <td>
                        <c:choose>
                            <c:when test="${usuario.ativo}">
                                Sim
                            </c:when>
                            <c:otherwise>
                                Não
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td class="acoes">
                        <a class="editar"
                           href="usuario?acao=editar&codigo=${usuario.codigo}">
                            Editar
                        </a>

                        <a class="excluir"
                           href="usuario?acao=excluir&codigo=${usuario.codigo}"
                           onclick="return confirm('Tem certeza que deseja excluir?');">
                            Excluir
                        </a>
                    </td>

                </tr>
            </c:forEach>

            </tbody>

        </table>

    </div>

    <p style="margin-top:20px">
        <a href="javascript:history.back()">
            ← Voltar
        </a>
    </p>

</div>

</body>
</html>