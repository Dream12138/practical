<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">主功能选择</li>
        <li class="active treeview menu-open">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>系统主页</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
           <ul class="treeview-menu">
            <li><a href="../home/tomain.do"><i class="fa fa-circle-o"></i>返回主页</a></li>
           
          </ul>
         
        </li>
        <c:forEach var="module" items="${moduleList}">
        <li class="treeview menu-open">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>${module.name }</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <c:forEach var="function" items="${module.functions}">
            <li><a href="${function.url}"><i class="fa fa-circle-o"></i>${function.name }</a></li>
            </c:forEach>
           
            
          </ul>
        </li>
        </c:forEach>
        
       
        
      
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>