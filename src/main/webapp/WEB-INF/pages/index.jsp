<%@page contentType="text/html; ISO-8859-1" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>

    <title>Login</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="container">

    <div class="card">

        <h1>Sistema de Lancherias</h1>

        <h2>Login</h2>

        <form action="login" method="post">

            <input
                    type="text"
                    name="nome"
                    placeholder="Nome"
                    required>

            <input
                    type="password"
                    name="senha"
                    placeholder="Senha"
                    required>

            <input
                    type="submit"
                    value="Entrar">

        </form>

        <c:if test="${not empty erro}">
            <p class="erro">${erro}</p>
        </c:if>

    </div>

</div>

</body>
</html>