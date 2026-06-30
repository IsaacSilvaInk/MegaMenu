<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 11/05/2026
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Editar Lancheria</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background:#f4f6f9;
            margin:0;
            padding:30px;
        }

        .container{
            max-width:600px;
            margin:auto;
        }

        .card{
            background:white;
            padding:25px;
            border-radius:10px;
            box-shadow:0 2px 10px rgba(0,0,0,0.1);
            margin-bottom:20px;
        }

        label{
            display:block;
            margin-top:10px;
            font-weight:bold;
        }

        input[type=text]{
            width:100%;
            padding:10px;
            margin-top:5px;
            border:1px solid #ccc;
            border-radius:5px;
            box-sizing:border-box;
        }

        button{
            margin-top:20px;
            background:#2d89ef;
            color:white;
            border:none;
            padding:10px 20px;
            border-radius:5px;
            cursor:pointer;
        }

        button:hover{
            background:#1f6fd1;
        }

        a{
            text-decoration:none;
            color:#2d89ef;
            font-weight:bold;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="card">

        <h1>Editar Lancheria</h1>

        <form action="lancheria" method="post">

            <input type="hidden" name="acao" value="atualizar">
            <input type="hidden" name="codigo" value="${lancheria.codigo}">

            <label>Endereço</label>
            <input type="text"
                   name="endereco"
                   value="${lancheria.endereco}"
                   required>

            <label>Nome</label>
            <input type="text"
                   name="nome"
                   value="${lancheria.nome}"
                   required>

            <button type="submit">
                Salvar Alterações
            </button>

        </form>

    </div>

    <div class="card">
        <a href="javascript:history.back()">
            ← Voltar
        </a>
    </div>

</div>

</body>
</html>