<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 11/05/2026
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Dashboard</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="container">

    <div class="card">

        <h1>Bem-vindo, ${usuario.nome}</h1>

        <div class="menu">

            <a href="usuario">Usuários</a>

            <a href="lancheria">Lancherias</a>

            <a href="lanche">Lanches</a>

        </div>

    </div>

    <p style="margin-top:20px">
        <a href="javascript:history.back()">
            ← Voltar
        </a>
    </p>

</div>

</body>
</html>
