<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 30/05/2026
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Cardápio</title>

    <style>
        body{
            font-family: Arial, sans-serif;
            background:#f4f4f4;
            margin:40px;
        }

        .container{
            max-width:1000px;
            margin:auto;
        }

        .card{
            background:white;
            padding:20px;
            border-radius:10px;
            box-shadow:0 0 10px rgba(0,0,0,.1);
            margin-bottom:20px;
        }

        input,select{
            width:100%;
            padding:8px;
            margin-bottom:10px;
        }

        button{
            padding:10px 20px;
            background:#2196F3;
            color:white;
            border:none;
            border-radius:5px;
        }

        table{
            width:100%;
            border-collapse:collapse;
        }

        th,td{
            border:1px solid #ddd;
            padding:10px;
        }

        th{
            background:#2196F3;
            color:white;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="card">

        <h1>
            Cardápio - ${lancheria.nome}
        </h1>

        <form action="cardapio" method="post">

            <input
                    type="hidden"
                    name="codigo_lancheria"
                    value="${lancheria.codigo}">

            <label>Lanche</label>

            <select name="codigo_lanche">

                <c:forEach var="lanche" items="${todosLanches}">

                    <option value="${lanche.codigo}">
                            ${lanche.nome}
                    </option>

                </c:forEach>

            </select>

            <label>Preço</label>

            <input
                    type="number"
                    step="0.01"
                    name="preco"
                    required>

            <button type="submit">
                Adicionar ao Cardápio
            </button>

        </form>

    </div>

    <div class="card">

        <h2>Itens cadastrados</h2>

        <table>

            <tr>
                <th>Lanche</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Ações</th>
            </tr>

            <c:forEach var="item" items="${listaCardapio}">

                <tr>

                    <td>${item.lanche.nome}</td>

                    <td>${item.lanche.descricao}</td>

                    <td>R$ ${item.preco}</td>

                    <td>

                        <a href="cardapio?acao=excluir&codigo_cardapio=${item.codigo}&codigo_lancheria=${lancheria.codigo}">
                            Excluir
                        </a>

                    </td>

                </tr>

            </c:forEach>

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