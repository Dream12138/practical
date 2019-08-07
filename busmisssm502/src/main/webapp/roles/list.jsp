<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../include/head.jsp" %>
 </head>
 
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <!-- header -->
  <jsp:include page="../include/header.jsp" />
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="../include/menubar.jsp" /> 

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>用户管理<small>管理主页</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
        <li class="active">仪表盘</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
       <!-- Main row -->
	   <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">用户列表</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>账号</th>
                  <th>姓名</th>
                  <th>年龄</th>
                  <th>入职日期</th>
                  <th>激活状态</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="um">
                <tr>
                  <td>${um.id }</td>
                  <td>${um.name }</td>
                  <td>${um.age }</td>
                  <td><fmt:formatDate value="${um.joinDate}"/>  </td>
                  <td>${um.statusName}</td>
                  <td><a href="tomodify.do?id=${um.id }" class="btn btn-info">修改</a> <a href="delete.do?id=${um.id }" class="btn btn-info">删除</a> <a href="todetail.do?id=${um.id }" class="btn btn-info">详细</a> 
                   	<c:if test="${um.status=='Y' }">
                   <a href="active.do?id=${um.id }" class="btn btn-info">不激活</a>
                   </c:if>
                   <c:if test="${um.status=='N' }">
                   <a href="inactive.do?id=${um.id }" class="btn btn-info">激活</a>
                   </c:if>
                   </td>
                </tr>
                </c:forEach>
                
                
                
                </tfoot>
              </table>
             
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
           <a href="toregister.do" class="btn btn-info">注册用户</a>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
      
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="../include/footer.jsp" />
  
 
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->
<%@ include file="../include/alljs.jsp" %>
</body>
</html>

