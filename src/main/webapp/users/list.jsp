<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 12.06.2022
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>

<!-- Main Content -->
<div id="content">

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <a href="/user/add" class="btn btn-primary btn-icon-split">
                <span class="icon text-white-50"><i class="fas fa-flag"></i></span>
                <span class="text">Dodaj użytkownika</span></a>
        </div>

        <table class="table-bordered" width="100%">
            <tr class="border-bottom-primary table-primary">
                <th>ID</th>
                <th>Nazwa użytkownika</th>
                <th>Email</th>
                <th>Akcje</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="/user/show?id=${user.id}" class="btn btn-info btn-circle btn-sm">
                            <i class="fas fa-info-circle"></i></a>
                        <a href="/user/edit?id=${user.id}" class="btn btn-warning btn-circle btn-sm">
                            <i class="fas fa-exclamation-triangle"></i></a>
                        <a href="/user/delete?id=${user.id}" class="btn btn-danger btn-circle btn-sm">
                            <i class="fas fa-trash"></i></a></td>
                </tr>
            </c:forEach>
        </table>


    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/footer.jsp" %>