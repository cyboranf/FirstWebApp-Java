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
      <a href="/user/list" class="btn btn-secondary btn-icon-split">
        <span class="icon text-white-50"><i class="fas fa-arrow-right"></i></span>
        <span class="text">Lista użytkowników</span>
      </a>
    </div>

    <div>
      <div class="col-lg-6 mb-4 card bg-danger text-white shadow card-body">
        Jesteś pewien, że chcesz usunąć użytkownika ${user.userName}?
      </div>
      <form method="post">
        <input type="hidden" name="id" value="${user.id}">
        <button type="submit" name="ifDelete" value="true" class="btn btn-danger btn-icon-split">
          <span class="icon text-white-50"><i class="fas fa-trash"></i></span>
          <span class="text">Usuń</span>
        </button>
        <button type="submit" name="ifDelete" value="false" class="btn btn-secondary btn-icon-split">
          <span class="icon text-white-50"><i class="fas fa-arrow-alt-circle-left"></i></span>
          <span class="text">Anuluj</span>
        </button>
      </form>
    </div>




  </div>
  <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/footer.jsp" %>
