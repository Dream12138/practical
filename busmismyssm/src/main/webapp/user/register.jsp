<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <h1>用户管理<small>注册新用户</small></h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
        <li class="active">仪表盘</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
       <!-- Main row -->
	  <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">用户注册</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" action = "register.do">
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">账号</label>
                  <input type="text" class="form-control" name = "id" placeholder="账号">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">密码</label>
                  <input type="password" class="form-control" name = "password" placeholder="密码">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">姓名</label>
                  <input type="text" class="form-control" name = "name" placeholder="姓名">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">职位</label>
                  <input type="text" class="form-control" name = "role" placeholder="职位">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">年龄</label>
                  <input type="number" class="form-control" name = "age" placeholder="年龄">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">入职日期</label>
                  <input type="date" class="form-control" name = "joinDate" placeholder="入职日期">
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">提交</button>
              </div>
            </form>
          </div>
          <!-- /.box -->
      
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

