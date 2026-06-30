<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 11/05/2026
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Lancherias</title>

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

        input{
            padding:8px;
            width:100%;
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

        <h1>Cadastro de Lancherias</h1>

        <form action="lancheria" method="post">

            <input
                    type="text"
                    name="nome"
                    placeholder="Nome da lancheria"
                    required>

            <input
                    type="text"
                    name="endereco"
                    placeholder="Endereço"
                    required>

            <button type="submit">
                Cadastrar
            </button>

        </form>

    </div>

    <div class="card">

        <h2>Lancherias cadastradas</h2>

        <table>

            <tr>
                <th>Nome</th>
                <th>Endereço</th>
                <th>Ações</th>
            </tr>

            <c:forEach var="lancheria" items="${listalancherias}">

                <tr>

                    <td>${lancheria.nome}</td>

                    <td>${lancheria.endereco}</td>

                    <td>

                        <a href="cardapio?codigo_lancheria=${lancheria.codigo}">
                            Cardápio
                        </a>

                        |

                        <a href="lancheria?acao=editar&codigo=${lancheria.codigo}">
                            Editar
                        </a>

                        |

                        <a href="lancheria?acao=excluir&codigo=${lancheria.codigo}">
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