<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>招聘职位管理 <span class="c-gray en">&gt;</span>
		招聘职位查询 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="11">招聘职位查询</th>
				</tr>
				<tr class="text-c">
					<th class="center">发布人</th>
					<th class="center">标题</th>
					<th class="center">职业类型</th>
					<th class="center">招聘人数</th>
					<th class="center">报名人数</th>
					<th class="center">薪资</th>
					<th class="center">发布日期</th>
					<th class="center">点击数</th>
					<th class="center">状态</th>
				</tr>
			</thead>
			<c:forEach items="${jobsList}" var="jobs">
				<tr class="text-c">
					<td class="center">${jobs.realname}</td>
					<td class="center">${jobs.title}</td>
					<td class="center">${jobs.catename}</td>
					<td class="center">${jobs.num}</td>
					<td class="center">${jobs.asignnum}</td>
					<td class="center">${jobs.salary}</td>
					<td class="center">${jobs.addtime}</td>
					<td class="center">${jobs.hits}</td>
					<td class="center">${jobs.status}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 mt-20"></div>
		<div class="text-c">
			<form action="jobs/queryJobsByCond.action" name="myform" method="post">
				查询条件： <span class="select-box" style="width: 200px;"><select name="cond" class="select">
						<option value="usersid">按发布人查询</option>
						<option value="title">按标题查询</option>
						<option value="cateid">按职业类型查询</option>
						<option value="num">按招聘人数查询</option>
						<option value="asignnum">按报名人数查询</option>
						<option value="salary">按薪资查询</option>
						<option value="addtime">按发布日期查询</option>
						<option value="hits">按点击数查询</option>
						<option value="status">按状态查询</option>
				</select></span>&nbsp;&nbsp;关键字<input type="text" name="name" required style="width: 200px" class="input-text" />
				<button type="submit" class="btn btn-success radius">
					<i class="Hui-iconfont">&#xe665;</i> 查询
				</button>
			</form>
		</div>
	</div>
</body>
</html>

