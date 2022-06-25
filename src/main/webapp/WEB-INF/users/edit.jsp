<%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 25.06.2022
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UsersCRUD - Edytuj użytkownika</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body>
<jsp:include page="/WEB-INF/header.jsp"/>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
    </div>
    <!-- Form -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Edytuj użytkownika</h6>
        </div>
        <div class="card-body">
            <form method="POST">
                <div class="form-group">
                    <label type="text" for="username">Nazwa</label><br>
                    <input class="form-control" type="text" name="username" id="username"
                           placeholder="Nazwa użytkownika"
                           value="${usernameField}">
                    <c:if test="${not empty usernameError}">
                        <span class="px-2 mb-2 bg-danger text-white rounded">${usernameError}</span><br>
                    </c:if>
                </div>
                <div class="form-group">
                    <label type="text" for="email">Email</label><br>
                    <input class="form-control" type="email" name="email" id="email" placeholder="Email użytkownika"
                           value="${emailField}">
                    <c:if test="${not empty emailError}">
                        <span class="px-2 mb-2 bg-danger text-white rounded">${emailError}<br></span>
                    </c:if>
                </div>
                <div class="form-group">
                    <label type="text" for="password">Hasło</label><br>
                    <input class="form-control" type="password" name="password" id="password"
                           placeholder="Hasło użytkownika">
                    <c:if test="${not empty passwordError}">
                    <span class="px-2 mb-2 bg-danger text-white rounded">${passwordError}<br>
                    </c:if>
                </div>
                <input class="btn btn-primary" type="submit" value="Zapisz">
            </form>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

<jsp:include page="/WEB-INF/footer.jsp"/>
</body>

</html>